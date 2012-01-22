package net.fusejna.examples;

import java.io.File;

import net.fusejna.DirectoryFiller;
import net.fusejna.StructStat.NodeType;
import net.fusejna.StructStat.StatSetter;
import net.fusejna.util.FuseFilesystemAdapterFull;

public final class NullFS extends FuseFilesystemAdapterFull
{
	public static void main(final String... args)
	{
		final String mountPoint = System.getProperty("user.home") + File.separator + "tempmount";
		try {
			new NullFS().log(true).mount(mountPoint);
		}
		catch (final Throwable e) {
			System.err.println(e);
		}
	}

	@Override
	public int getattr(final String path, final StatSetter stat)
	{
		stat.setMode(NodeType.DIRECTORY);
		return 0;
	}

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		filler.add("hello");
		return 0;
	}
}
