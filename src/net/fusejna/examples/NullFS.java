package net.fusejna.examples;

import java.io.File;

import net.fusejna.structures.StructStat.NodeType;
import net.fusejna.structures.StructStat.StatSetter;
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
		stat.setMode(NodeType.FILE);
		return 0;
	}
}
