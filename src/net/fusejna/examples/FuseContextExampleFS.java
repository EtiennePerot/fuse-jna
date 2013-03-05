package net.fusejna.examples;

import java.nio.ByteBuffer;

import net.fusejna.FuseException;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;

public final class FuseContextExampleFS
{
	private static class FuseContextFS extends HelloFS
	{
		@Override
		public int read(final String path, final ByteBuffer buffer, final long size, final long offset,
				final FileInfoWrapper info)
		{
			System.out.println(path + " is being read by pid=" + getFuseContextPid() + " uid=" + getFuseContextUid() + " gid="
					+ getFuseContextGid());
			return super.read(path, buffer, size, offset, info);
		}
	}

	public static void main(final String[] args) throws FuseException
	{
		if (args.length != 1) {
			System.err.println("Usage: FuseContextExampleFS <mountpoint>");
			System.exit(1);
		}
		new FuseContextFS().mount(args[0]);
	}
}
