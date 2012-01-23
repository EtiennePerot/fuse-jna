package net.fusejna.examples;

import java.nio.ByteBuffer;

import net.fusejna.DirectoryFiller;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;
import net.fusejna.StructStat.NodeType;
import net.fusejna.StructStat.StatWrapper;
import net.fusejna.util.FuseFilesystemAdapterFull;

public class HelloFS extends FuseFilesystemAdapterFull
{
	public static void main(final String... args)
	{
		if (args.length != 1) {
			System.err.println("Usage: NullFS <mountpoint>");
			System.exit(1);
		}
		try {
			new HelloFS().log(true).mount(args[0]);
		}
		catch (final Throwable e) {
			System.err.println(e);
		}
	}

	private final String filename = "/hello";
	private final String contents = "Hello World!";

	@Override
	public int getattr(final String path, final StatWrapper stat)
	{
		if (path.equals(filename)) {
			stat.setMode(NodeType.FILE).size(contents.length());
		}
		return 0;
	}

	@Override
	public int read(final String path, final ByteBuffer buffer, final long size, final long offset, final FileInfoWrapper info)
	{
		// Compute substring that we are being asked to read
		final String s = contents.substring((int) offset,
				(int) Math.max(offset, Math.min(contents.length() - offset, offset + size)));
		buffer.put(s.getBytes());
		return s.getBytes().length;
	}

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		filler.add("hello");
		return 0;
	}
}
