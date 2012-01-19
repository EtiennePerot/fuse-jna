package net.fusejna;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import net.fusejna.examples.NullFS;
import net.fusejna.structures.StructFuseContext;
import net.fusejna.structures.StructFuseOperations;
import net.fusejna.types.TypeSize;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

final class FuseJna
{
	private interface LibFuse extends Library
	{
		StructFuseContext fuse_get_context();

		int fuse_main_real(int argc, String[] argv, StructFuseOperations op, TypeSize size, Pointer user_data);
	}

	private static LibFuse libFuse = null;
	private static Lock libFuseLoadLock = new ReentrantLock();

	static LibFuse getFuse() throws UnsatisfiedLinkError
	{
		if (libFuse != null) {
			// No need to lock if everything is fine already
			return libFuse;
		}
		libFuseLoadLock.lock();
		if (libFuse == null) {
			Native.setProtected(true);
			libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
		}
		libFuseLoadLock.unlock();
		return libFuse;
	}

	public static void main(final String... args)
	{
		final LibFuse fuse = getFuse();
		final String[] argv = { "userfs", "-f", args[0] };
		final StructFuseOperations.ByReference operations = new StructFuseOperations.ByReference(new NullFS());
		fuse.fuse_main_real(argv.length, argv, operations, new TypeSize(operations.size()), null);
		System.err.println("Mounted");
	}

	static void mount(final FuseFilesystem filesystem, final File mountpoint) throws InvalidMountpointException, FuseException,
			UnsatisfiedLinkError
	{
		if (!mountpoint.isDirectory()) {
			throw new NotADirectoryMountpointException(mountpoint);
		}
		if (!mountpoint.canRead() || !mountpoint.canWrite() || !mountpoint.canExecute()) {
			boolean successful = true;
			try {
				successful = mountpoint.setReadable(true) && successful;
				successful = mountpoint.setWritable(true) && successful;
				successful = mountpoint.setExecutable(true) && successful;
			}
			catch (final Exception e) {
				throw new InvalidPermissionsMountpointException(mountpoint);
			}
			if (!successful) {
				throw new InvalidPermissionsMountpointException(mountpoint);
			}
		}
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
		argv[0] = filesystem.getFuseName();
		argv[1] = "-f";
		argv[argv.length - 1] = mountpoint.getAbsolutePath();
		final LibFuse fuse = getFuse();
		final StructFuseOperations operations = new StructFuseOperations(filesystem);
		final int result = fuse.fuse_main_real(argv.length, argv, operations, new TypeSize(operations), null);
		if (result != 0) {
			throw new FuseException(result);
		}
	}
}
