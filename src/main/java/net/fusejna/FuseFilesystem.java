package net.fusejna;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.BufferOverflowException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import net.fusejna.StructFlock.FlockWrapper;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;
import net.fusejna.StructStat.StatWrapper;
import net.fusejna.StructStatvfs.StatvfsWrapper;
import net.fusejna.StructTimeBuffer.TimeBufferWrapper;
import net.fusejna.types.*;
import net.fusejna.types.TypeMode.ModeWrapper;
import net.fusejna.types.TypeMode.NodeType;

import com.sun.jna.Function;
import com.sun.jna.Pointer;

public abstract class FuseFilesystem
{
	private static @interface FuseMethod
	{
	}

	private static @interface UserMethod
	{
	}

	private static final String defaultFilesystemName = "userfs-";
	private static final Pattern regexNormalizeFilesystemName = Pattern.compile("[a-zA-Z]");
	private final ReentrantLock mountLock = new ReentrantLock();
	private final AutoUnmountHook unmountHook = new AutoUnmountHook(this);
	private File mountPoint = null;
	private Logger logger = null;

	@FuseMethod
	final int _access(final String path, final int access)
	{
		return access(path, access);
	}

	@FuseMethod
	final int _bmap(final String path, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = bmap(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _chmod(final String path, final TypeMode mode)
	{
		return chmod(path, new ModeWrapper(mode));
	}

	@FuseMethod
	final int _chown(final String path, final TypeUid uid, final TypeGid gid)
	{
		return chown(path, uid.longValue(), gid.longValue());
	}

	@FuseMethod
	final int _create(final String path, final TypeMode mode, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = create(path, new ModeWrapper(mode), wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final void _destroy()
	{
		destroy();
	}

	@FuseMethod
	final int _fgetattr(final String path, final StructStat stat, final StructFuseFileInfo info)
	{
		final StatWrapper swrapper = new StatWrapper(path, stat);
		defaultStat(swrapper, FuseJna.getUid(), FuseJna.getGid());
		final FileInfoWrapper fwrapper = new FileInfoWrapper(path, info);
		final int result = fgetattr(path, swrapper, fwrapper);
		swrapper.write();
		fwrapper.write();
		return result;
	}

	@FuseMethod
	final int _flush(final String path, final StructFuseFileInfo info)
	{
		return flush(path, new FileInfoWrapper(path, info));
	}

	@FuseMethod
	final int _fsync(final String path, final int datasync, final StructFuseFileInfo info)
	{
		return fsync(path, datasync, new FileInfoWrapper(path, info));
	}

	@FuseMethod
	final int _fsyncdir(final String path, final int datasync, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = fsyncdir(path, datasync, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _ftruncate(final String path, final TypeOff offset, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = ftruncate(path, offset.longValue(), wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _getattr(final String path, final StructStat stat)
	{
		final StatWrapper wrapper = new StatWrapper(path, stat);
		defaultStat(wrapper, FuseJna.getUid(), FuseJna.getGid());
		final int result = getattr(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _getxattr(final String path, final String xattr, final Pointer buffer, final TypeSize size,
			final TypeUInt32 position)
	{
		final long sizeValue = size.longValue();
		if (buffer == null || sizeValue == 0L) {
			return 0;
		}
		final ByteBuffer buf = buffer.getByteBuffer(0, sizeValue);
		final int result = getxattr(path, xattr, buf, sizeValue, position == null ? 0L : position.longValue());
		if (result == 0) {
			try {
				buf.put((byte) 0);
			}
			catch (final BufferOverflowException e) {
				((ByteBuffer) buf.position(buf.limit() - 1)).put((byte) 0);
			}
		}
		return result;
	}

	@FuseMethod
	final void _init(final StructFuseConnInfo conn)
	{
		init();
	}

	@FuseMethod
	final int _link(final String path, final String target)
	{
		return link(path, target);
	}

	@FuseMethod
	final int _listxattr(final String path, final Pointer buffer, final TypeSize size)
	{
		final long sizeValue = size.longValue();
		if (buffer == null || sizeValue == 0L) {
			return 0;
		}
		final XattrListFiller filler = new XattrListFiller(buffer.getByteBuffer(0, sizeValue), sizeValue);
		return listxattr(path, filler);
	}

	@FuseMethod
	final int _lock(final String path, final StructFuseFileInfo info, final int cmd, final StructFlock flock)
	{
		final FileInfoWrapper fileWrapper = new FileInfoWrapper(path, info);
		final FlockWrapper flockWrapper = new FlockWrapper(path, flock);
		final int result = lock(path, fileWrapper, FlockCommand.fromBits(cmd), flockWrapper);
		fileWrapper.write();
		flockWrapper.write();
		return result;
	}

	@FuseMethod
	final int _mkdir(final String path, final TypeMode mode)
	{
		return mkdir(path, new ModeWrapper(mode));
	}

	@FuseMethod
	final int _mknod(final String path, final TypeMode mode, final TypeDev dev)
	{
		return mknod(path, new ModeWrapper(mode), dev.longValue());
	}

	@FuseMethod
	final int _open(final String path, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = open(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _opendir(final String path, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = opendir(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _read(final String path, final Pointer buffer, final TypeSize size, final TypeOff offset,
			final StructFuseFileInfo info)
	{
		final long bufSize = size.longValue();
		final long readOffset = offset.longValue();
		final ByteBuffer buf = buffer.getByteBuffer(0, bufSize);
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = read(path, buf, bufSize, readOffset, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _readdir(final String path, final Pointer buf, final Pointer fillFunction, final TypeOff offset,
			final StructFuseFileInfo info)
	{
		return readdir(path, new DirectoryFillerImpl(buf, Function.getFunction(fillFunction)));
	}

	@FuseMethod
	final int _readlink(final String path, final Pointer buffer, final TypeSize size)
	{
		final long bufSize = size.longValue();
		final ByteBuffer buf = buffer.getByteBuffer(0, bufSize);
		final int result = readlink(path, buf, bufSize);
		if (result == 0) {
			try {
				buf.put((byte) 0);
			}
			catch (final BufferOverflowException e) {
				((ByteBuffer) buf.position(buf.limit() - 1)).put((byte) 0);
			}
		}
		return result;
	}

	@FuseMethod
	final int _release(final String path, final StructFuseFileInfo info)
	{
		return release(path, new FileInfoWrapper(path, info));
	}

	@FuseMethod
	final int _releasedir(final String path, final StructFuseFileInfo info)
	{
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = releasedir(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _removexattr(final String path, final String xattr)
	{
		return removexattr(path, xattr);
	}

	@FuseMethod
	final int _rename(final String path, final String newName)
	{
		return rename(path, newName);
	}

	@FuseMethod
	final int _rmdir(final String path)
	{
		return rmdir(path);
	}

	@FuseMethod
	final int _setxattr(final String path, final Pointer buffer, final TypeSize size, final int flags, final TypeUInt32 position)
	{
		final long sizeValue = size.longValue();
		final ByteBuffer buf = buffer.getByteBuffer(0, sizeValue);
		return setxattr(path, buf, sizeValue, flags, position == null ? 0L : position.longValue());
	}

	@FuseMethod
	final int _statfs(final String path, final StructStatvfs statsvfs)
	{
		final StatvfsWrapper wrapper = new StatvfsWrapper(path, statsvfs);
		final int result = statfs(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _symlink(final String path, final String target)
	{
		return symlink(path, target);
	}

	@FuseMethod
	final int _truncate(final String path, final TypeOff offset)
	{
		return truncate(path, offset.longValue());
	}

	@FuseMethod
	final int _unlink(final String path)
	{
		return unlink(path);
	}

	@FuseMethod
	final int _utimens(final String path, final StructTimeBuffer timebuffer)
	{
		final TimeBufferWrapper wrapper = new TimeBufferWrapper(timebuffer);
		final int result = utimens(path, wrapper);
		wrapper.write();
		return result;
	}

	@FuseMethod
	final int _write(final String path, final Pointer buffer, final TypeSize size, final TypeOff offset,
			final StructFuseFileInfo info)
	{
		final long bufSize = size.longValue();
		final long writeOffset = offset.longValue();
		final ByteBuffer buf = buffer.getByteBuffer(0, bufSize);
		final FileInfoWrapper wrapper = new FileInfoWrapper(path, info);
		final int result = write(path, buf, bufSize, writeOffset, wrapper);
		wrapper.write();
		return result;
	}

	@UserMethod
	public abstract int access(final String path, final int access);

	public abstract void afterUnmount(final File mountPoint);

	public abstract void beforeUnmount(final File mountPoint);

	@UserMethod
	public abstract int bmap(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int chmod(final String path, final ModeWrapper mode);

	@UserMethod
	public abstract int chown(final String path, final long uid, final long gid);

	@UserMethod
	public abstract int create(final String path, final ModeWrapper mode, final FileInfoWrapper info);

	/**
	 * Subclasses may override this to customize the default parameters applied to the stat structure, or to prevent such
	 * behavior (by overriding this method with an empty one)
	 * 
	 * @param stat
	 *            The
	 */
	protected void defaultStat(final StatWrapper wrapper, final long uid, final long gid)
	{
		// Set some sensible defaults
		wrapper.setMode(NodeType.DIRECTORY).setAllTimesMillis(System.currentTimeMillis()).nlink(1).uid(FuseJna.getUid())
				.gid(FuseJna.getGid());
	}

	@UserMethod
	public abstract void destroy();

	@UserMethod
	public abstract int fgetattr(final String path, final StatWrapper stat, final FileInfoWrapper info);

	@UserMethod
	public abstract int flush(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int fsync(final String path, int datasync, final FileInfoWrapper info);

	@UserMethod
	public abstract int fsyncdir(final String path, int datasync, final FileInfoWrapper info);

	@UserMethod
	public abstract int ftruncate(final String path, final long offset, final FileInfoWrapper info);

	@UserMethod
	public abstract int getattr(final String path, final StatWrapper stat);

	/**
	 * Returns the raw fuse_context structure. Only valid when called while a filesystem operation is taking place.
	 * 
	 * @return The fuse_context structure by reference.
	 */
	protected final StructFuseContext getFuseContext()
	{
		if (!isMounted()) {
			throw new IllegalStateException("Cannot get FUSE context if the filesystem is not mounted.");
		}
		return FuseJna.getFuseContext();
	}

	/**
	 * Returns the gid field of the fuse context. Only valid when called while a filesystem operation is taking place.
	 * 
	 * @return The group ID of the process executing an operation on this filesystem.
	 */
	protected TypeGid getFuseContextGid()
	{
		return getFuseContext().gid;
	}

	/**
	 * Returns the pid field of the fuse context. Only valid when called while a filesystem operation is taking place.
	 * 
	 * @return The process ID of the process executing an operation on this filesystem.
	 */
	protected TypePid getFuseContextPid()
	{
		return getFuseContext().pid;
	}

	/**
	 * Returns the uid field of the fuse context. Only valid when called while a filesystem operation is taking place.
	 * 
	 * @return The user ID of the user running the process executing an operation of this filesystem.
	 */
	protected TypeUid getFuseContextUid()
	{
		return getFuseContext().uid;
	}

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

	final AutoUnmountHook getUnmountHook()
	{
		return unmountHook;
	}

	@UserMethod
	public abstract int getxattr(final String path, final String xattr, final ByteBuffer buf, final long size,
			final long position);

	@FuseMethod
	public abstract void init();

	public final boolean isMounted()
	{
		return getMountPoint() != null;
	}

	@UserMethod
	public abstract int link(final String path, final String target);

	@UserMethod
	public abstract int listxattr(final String path, final XattrListFiller filler);

	@UserMethod
	public abstract int lock(final String path, final FileInfoWrapper info, final FlockCommand command, final FlockWrapper flock);

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

	@UserMethod
	public abstract int mkdir(final String path, final ModeWrapper mode);

	@UserMethod
	public abstract int mknod(final String path, final ModeWrapper mode, final long dev);

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
		this.mountPoint = mountPoint;
		mountLock.unlock();
		FuseJna.mount(this, mountPoint, blocking);
		onMount(mountPoint);
	}

	public final void mount(final String mountPoint) throws FuseException
	{
		mount(new File(mountPoint), true);
	}

	public abstract void onMount(final File mountPoint);

	@UserMethod
	public abstract int open(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int opendir(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int read(final String path, final ByteBuffer buffer, final long size, final long offset,
			final FileInfoWrapper info);

	@UserMethod
	public abstract int readdir(final String path, final DirectoryFiller filler);

	@UserMethod
	public abstract int readlink(final String path, final ByteBuffer buffer, final long size);

	@UserMethod
	public abstract int release(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int releasedir(final String path, final FileInfoWrapper info);

	@UserMethod
	public abstract int removexattr(final String path, final String xattr);

	@UserMethod
	public abstract int rename(final String path, final String newName);

	@UserMethod
	public abstract int rmdir(final String path);

	void setFinalMountPoint(final File mountPoint)
	{
		mountLock.lock();
		this.mountPoint = mountPoint;
		mountLock.unlock();
	}

	@UserMethod
	public abstract int setxattr(final String path, final ByteBuffer buf, final long size, final int flags, final long position);

	@UserMethod
	public abstract int statfs(final String path, final StatvfsWrapper wrapper);

	@UserMethod
	public abstract int symlink(final String path, final String target);

	@UserMethod
	public abstract int truncate(final String path, final long offset);

	@UserMethod
	public abstract int unlink(final String path);

	public final void unmount() throws IOException, FuseException
	{
		mountLock.lock();
		if (!isMounted()) {
			return;
		}
		try {
			beforeUnmount(mountPoint);
			FuseJna.unmount(this);
			final File oldMountPoint = mountPoint;
			mountPoint = null;
			afterUnmount(oldMountPoint);
		}
		finally {
			mountLock.unlock();
		}
	}

	@UserMethod
	public abstract int utimens(final String path, final TimeBufferWrapper wrapper);

	@UserMethod
	public abstract int write(final String path, final ByteBuffer buf, final long bufSize, final long writeOffset,
			final FileInfoWrapper info);
}
