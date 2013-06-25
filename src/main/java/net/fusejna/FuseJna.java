package net.fusejna;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import net.fusejna.types.TypeSize;

public final class FuseJna
{
	private static final class MountThread extends Thread
	{
		private Integer result = null;
		private final String[] args;
		private final StructFuseOperations operations;
		private final LibFuse fuse;
		private final File mountPoint;

		private MountThread(final String filesystemName, final LibFuse fuse, final String[] args, final File mountPoint,
				final StructFuseOperations operations)
		{
			super(filesystemName + "-fuse");
			this.fuse = fuse;
			this.args = args;
			this.mountPoint = mountPoint;
			this.operations = operations;
			start();
		}

		private final Integer getResult()
		{
			return result;
		}

		@Override
		public final void run()
		{
			result = fuse.fuse_main_real(args.length, args, operations, new TypeSize(operations), null);
			unregisterFilesystemName(mountPoint);
		}
	}

	private static LibFuse libFuse = null;
	private static Lock initLock = new ReentrantLock();
	private static Lock filesystemNameLock = new ReentrantLock();
	private static final Random defaultFilesystemRandom = new Random();
	private static final Map<File, String> filesystemNames = new HashMap<File, String>();
	private static final long errorSleepDuration = 750;
	private static String fusermount = "fusermount";
	private static String umount = "umount";
	private static int currentUid = 0;
	private static int currentGid = 0;

	private static final String getFilesystemName(final File mountPoint, final String fuseName)
	{
		filesystemNameLock.lock();
		if (filesystemNames.put(mountPoint, fuseName) == null) {
			filesystemNameLock.unlock();
			return fuseName;
		}
		String suffix;
		do {
			suffix = Long.toString(defaultFilesystemRandom.nextLong());
		}
		while (filesystemNames.put(mountPoint, fuseName + suffix) != null);
		filesystemNameLock.unlock();
		return fuseName + suffix;
	}

	static StructFuseContext getFuseContext()
	{
		return init().fuse_get_context();
	}

	static final int getGid()
	{
		return currentGid;
	}

	static final int getUid()
	{
		return currentUid;
	}

	private static final boolean handleShutdownHooks()
	{
		final SecurityManager security = System.getSecurityManager();
		if (security == null) {
			return true;
		}
		try {
			security.checkPermission(new RuntimePermission("shutdownHooks"));
			return true;
		}
		catch (final SecurityException e) {
			return false;
		}
	}

	static final LibFuse init() throws UnsatisfiedLinkError
	{
		if (libFuse != null) {
			// No need to lock if everything is fine already
			return libFuse;
		}
		initLock.lock();
		if (libFuse == null) {
			libFuse = Platform.fuse();
		}
		try {
			currentUid = Integer.parseInt(new ProcessGobbler("id", "-u").getStdout());
			currentGid = Integer.parseInt(new ProcessGobbler("id", "-g").getStdout());
		}
		catch (final Exception e) {
			// Oh well, keep default values
		}
		initLock.unlock();
		return libFuse;
	}

	static final void mount(FuseFilesystem filesystem, File mountPoint, final boolean blocking) throws FuseException
	{
		mountPoint = mountPoint.getAbsoluteFile();
		try {
			mountPoint = mountPoint.getCanonicalFile();
		}
		catch (final IOException e) {
			throw new NotADirectoryMountpointException(mountPoint);
		}
		if (!mountPoint.isDirectory()) {
			throw new NotADirectoryMountpointException(mountPoint);
		}
		if (!mountPoint.canRead() || !mountPoint.canWrite() || !mountPoint.canExecute()) {
			boolean successful = true;
			try {
				successful = mountPoint.setReadable(true) && successful;
				successful = mountPoint.setWritable(true) && successful;
				successful = mountPoint.setExecutable(true) && successful;
			}
			catch (final Exception e) {
				throw new InvalidPermissionsMountpointException(mountPoint);
			}
			if (!successful) {
				throw new InvalidPermissionsMountpointException(mountPoint);
			}
		}
		final Logger logger = filesystem.getLogger();
		if (logger != null) {
			filesystem = new LoggedFuseFilesystem(filesystem, logger);
		}
		filesystem.setFinalMountPoint(mountPoint);
		final String filesystemName = getFilesystemName(mountPoint, filesystem.getFuseName());
		final String[] options = filesystem.getOptions();
		final String[] argv;
		if (options == null) {
			argv = new String[3];
		}
		else {
			argv = new String[3 + options.length];
			for (int i = 0; i < options.length; i++) {
				argv[i + 2] = options[i];
			}
		}
		argv[0] = filesystemName;
		argv[1] = "-f";
		argv[argv.length - 1] = mountPoint.getAbsolutePath();
		final LibFuse fuse = init();
		final StructFuseOperations operations = new StructFuseOperations(filesystem);
		final Integer result;
		if (handleShutdownHooks()) {
			Runtime.getRuntime().addShutdownHook(filesystem.getUnmountHook());
		}
		if (blocking) {
			result = fuse.fuse_main_real(argv.length, argv, operations, new TypeSize(operations), null);
			unregisterFilesystemName(mountPoint);
		}
		else {
			final MountThread mountThread = new MountThread(filesystemName, fuse, argv, mountPoint, operations);
			try {
				Thread.sleep(errorSleepDuration);
			}
			catch (final InterruptedException e) {
				// Carry on
			}
			result = mountThread.getResult();
		}
		if (result != null && result != 0) {
			throw new FuseException(result);
		}
	}

	public static final void setFusermount(final String fusermount)
	{
		FuseJna.fusermount = fusermount;
	}

	public static final void setUmount(final String umount)
	{
		FuseJna.umount = umount;
	}

	/**
	 * Try to unmount an existing FUSE mountpoint. NOTE: You should use {@link FuseFilesystem#unmount FuseFilesystem.unmount()}
	 * for unmounting the FuseFilesystem (or let the shutdown hook take care unmounting during shutdown of the application).
	 * This method is available for special cases, e.g. where mountpoints were left over from previous invocations and need to
	 * be unmounted before the filesystem can be mounted again.
	 * 
	 * @param mountPoint
	 *            The location where the filesystem is mounted.
	 * @return The exit code from running `fusermount` or `umount`, 0 indicates success. You can change the location of these
	 *         utilities using `setFusermount` and `setUmount`.
	 * @throws IOException
	 *             thrown if an error occurs while starting the external process.
	 */
	public static int unmount(final File mountPoint) throws IOException
	{
		ProcessGobbler process;
		try {
			process = new ProcessGobbler(FuseJna.fusermount, "-z", "-u", mountPoint.toString());
		}
		catch (final IOException e) {
			process = new ProcessGobbler(FuseJna.umount, mountPoint.toString());
		}
		return process.getReturnCode();
	}

	static void unmount(final FuseFilesystem fuseFilesystem) throws IOException, FuseException
	{
		if (handleShutdownHooks()) {
			try {
				Runtime.getRuntime().removeShutdownHook(fuseFilesystem.getUnmountHook());
			}
			catch (final IllegalStateException e) {
				// Already shutting down; this is fine and expected, ignore the exception.
			}
		}
		final File mountPoint = fuseFilesystem.getMountPoint();
		final int result = unmount(mountPoint);
		if (result != 0) {
			throw new FuseException(result);
		}
		unregisterFilesystemName(fuseFilesystem.getMountPoint());
	}

	private static final void unregisterFilesystemName(final File mountPoint)
	{
		filesystemNameLock.lock();
		filesystemNames.remove(mountPoint);
		filesystemNameLock.unlock();
	}
}
