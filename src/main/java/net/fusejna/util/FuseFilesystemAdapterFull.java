package net.fusejna.util;

import java.io.File;
import java.nio.ByteBuffer;

import net.fusejna.DirectoryFiller;
import net.fusejna.ErrorCodes;
import net.fusejna.FlockCommand;
import net.fusejna.FuseFilesystem;
import net.fusejna.StructFlock.FlockWrapper;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;
import net.fusejna.StructStat.StatWrapper;
import net.fusejna.StructStatvfs.StatvfsWrapper;
import net.fusejna.StructTimeBuffer.TimeBufferWrapper;
import net.fusejna.XattrListFiller;
import net.fusejna.types.TypeMode.ModeWrapper;

/**
 * An adapter that tries to put sane defaults for default return values. Will silently pretend that most non-critical operations
 * have succeeded, but return ENOSYS on non-implemented important operations.
 */
public abstract class FuseFilesystemAdapterFull extends FuseFilesystem
{
	@Override
	public int access(final String path, final int access)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public void afterUnmount(final File mountPoint)
	{
	}

	@Override
	public void beforeUnmount(final File mountPoint)
	{
	}

	@Override
	public int bmap(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int chmod(final String path, final ModeWrapper mode)
	{
		return 0;
	}

	@Override
	public int chown(final String path, final long uid, final long gid)
	{
		return 0;
	}

	@Override
	public int create(final String path, final ModeWrapper mode, final FileInfoWrapper info)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public void destroy()
	{
	}

	@Override
	public int fgetattr(final String path, final StatWrapper stat, final FileInfoWrapper info)
	{
		return getattr(path, stat);
	}

	@Override
	public int flush(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int fsync(final String path, final int datasync, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int fsyncdir(final String path, final int datasync, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int ftruncate(final String path, final long offset, final FileInfoWrapper info)
	{
		return truncate(path, offset);
	}

	@Override
	public int getattr(final String path, final StatWrapper stat)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	protected String getName()
	{
		return null;
	}

	@Override
	protected String[] getOptions()
	{
		return null;
	}

	@Override
	public int getxattr(final String path, final String xattr, final ByteBuffer buf, final long size, final long position)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public void init()
	{
	}

	@Override
	public int link(final String path, final String target)
	{
		return 0;
	}

	@Override
	public int listxattr(final String path, final XattrListFiller filler)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public int lock(final String path, final FileInfoWrapper info, final FlockCommand command, final FlockWrapper flock)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public int mkdir(final String path, final ModeWrapper mode)
	{
		return 0;
	}

	@Override
	public int mknod(final String path, final ModeWrapper mode, final long dev)
	{
		return create(path, mode, null);
	}

	@Override
	public void onMount(final File mountPoint)
	{
	}

	@Override
	public int open(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int opendir(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int read(final String path, final ByteBuffer buffer, final long size, final long offset, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		return 0;
	}

	@Override
	public int readlink(final String path, final ByteBuffer buffer, final long size)
	{
		return 0;
	}

	@Override
	public int release(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int releasedir(final String path, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int removexattr(final String path, final String xattr)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public int rename(final String path, final String newName)
	{
		return 0;
	}

	@Override
	public int rmdir(final String path)
	{
		return 0;
	}

	@Override
	public int setxattr(final String path, final ByteBuffer buf, final long size, final int flags, final long position)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public int statfs(final String path, final StatvfsWrapper wrapper)
	{
		return 0;
	}

	@Override
	public int symlink(final String path, final String target)
	{
		return 0;
	}

	@Override
	public int truncate(final String path, final long offset)
	{
		return 0;
	}

	@Override
	public int unlink(final String path)
	{
		return 0;
	}

	@Override
	public int utimens(final String path, final TimeBufferWrapper wrapper)
	{
		return -ErrorCodes.ENOSYS();
	}

	@Override
	public int write(final String path, final ByteBuffer buf, final long bufSize, final long writeOffset,
			final FileInfoWrapper wrapper)
	{
		return 0;
	}
}
