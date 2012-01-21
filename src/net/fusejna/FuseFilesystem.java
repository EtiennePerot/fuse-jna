package net.fusejna;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import net.fusejna.structures.StructStat.StatSetter;

public abstract class FuseFilesystem
{
	private static @interface FuseMethod
	{
	}

	private static final String defaultFilesystemName = "userfs-";
	private static final Pattern regexNormalizeFilesystemName = Pattern.compile("[a-zA-Z]");
	private final ReentrantLock mountLock = new ReentrantLock();
	private File mountPoint = null;
	private Logger logger = null;

	public abstract void afterUnmount(final File mountPoint);

	public abstract void beforeUnmount(final File mountPoint);

	@FuseMethod
	public abstract void destroy();

	@FuseMethod
	public abstract int getattr(final String path, final StatSetter stat);

	final String getFuseName()
	{
		String name = getName();
		if (name == null) {
			return defaultFilesystemName;
		}
		name = regexNormalizeFilesystemName.matcher(name).replaceAll("");
		if (name.isEmpty()) {
			return defaultFilesystemName;
		}
		return name.toLowerCase();
	}

	final Logger getLogger()
	{
		return logger;
	}

	public final File getMountPoint()
	{
		mountLock.lock();
		final File mountPoint = this.mountPoint;
		mountLock.unlock();
		return mountPoint;
	}

	protected abstract String getName();

	protected abstract String[] getOptions();

	@FuseMethod
	public abstract void init();

	public final boolean isMounted()
	{
		return getMountPoint() != null;
	}

	protected final FuseFilesystem log(final boolean logging)
	{
		return log(logging ? Logger.getLogger(getClass().getCanonicalName()) : null);
	}

	protected final FuseFilesystem log(final Logger logger)
	{
		mountLock.lock();
		if (mountPoint != null) {
			mountLock.unlock();
			throw new IllegalStateException("Cannot turn logging on/orr when filesystem is already mounted.");
		}
		this.logger = logger;
		mountLock.unlock();
		return this;
	}

	public final void mount(final File mountPoint) throws FuseException
	{
		mount(mountPoint, true);
	}

	public final void mount(final File mountPoint, final boolean blocking) throws UnsatisfiedLinkError, FuseException
	{
		mountLock.lock();
		if (isMounted()) {
			throw new IllegalStateException(getFuseName() + " is already mounted at " + this.mountPoint);
		}
		try {
			FuseJna.mount(this, mountPoint, blocking);
			this.mountPoint = mountPoint;
			onMount(mountPoint);
		}
		finally {
			mountLock.unlock();
		}
	}

	public final void mount(final String mountPoint) throws FuseException
	{
		mount(new File(mountPoint), true);
	}

	public abstract void onMount(final File mountPoint);

	void setFinalMountPoint(final File mountPoint)
	{
		mountLock.lock();
		this.mountPoint = mountPoint;
		mountLock.unlock();
	}

	public final void unmount() throws IOException, FuseException
	{
		mountLock.lock();
		try {
			beforeUnmount(mountPoint);
			FuseJna.unmount(this);
			final File oldMountPoint = mountPoint;
			mountPoint = null;
			beforeUnmount(oldMountPoint);
		}
		finally {
			mountLock.unlock();
		}
	}
}
