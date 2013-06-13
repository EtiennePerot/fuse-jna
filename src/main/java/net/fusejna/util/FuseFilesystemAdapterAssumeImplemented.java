package net.fusejna.util;

import java.nio.ByteBuffer;

import net.fusejna.FlockCommand;
import net.fusejna.StructFlock.FlockWrapper;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;
import net.fusejna.StructStat.StatWrapper;
import net.fusejna.StructTimeBuffer.TimeBufferWrapper;
import net.fusejna.XattrListFiller;
import net.fusejna.types.TypeMode.ModeWrapper;

/**
 * An adapter that assumes everything is implemented and works, returning success all the time.
 */
public abstract class FuseFilesystemAdapterAssumeImplemented extends FuseFilesystemAdapterFull
{
	@Override
	public int access(final String path, final int access)
	{
		return 0;
	}

	@Override
	public int create(final String path, final ModeWrapper mode, final FileInfoWrapper info)
	{
		return 0;
	}

	@Override
	public int getattr(final String path, final StatWrapper stat)
	{
		return 0;
	}

	@Override
	public int getxattr(final String path, final String xattr, final ByteBuffer buf, final long size, final long position)
	{
		return 0;
	}

	@Override
	public int listxattr(final String path, final XattrListFiller filler)
	{
		return 0;
	}

	@Override
	public int lock(final String path, final FileInfoWrapper info, final FlockCommand command, final FlockWrapper flock)
	{
		return 0;
	}

	@Override
	public int removexattr(final String path, final String xattr)
	{
		return 0;
	}

	@Override
	public int setxattr(final String path, final ByteBuffer buf, final long size, final int flags, final long position)
	{
		return 0;
	}

	@Override
	public int utimens(final String path, final TimeBufferWrapper wrapper)
	{
		return 0;
	}
}
