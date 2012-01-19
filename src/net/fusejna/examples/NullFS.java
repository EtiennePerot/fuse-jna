package net.fusejna.examples;

import java.io.File;

import net.fusejna.FuseFilesystem;

public final class NullFS extends FuseFilesystem
{
	public static void main(final String... args)
	{
		try {
			new NullFS().mount(System.getProperty("user.home") + File.separator + "tempmount");
		}
		catch (final Throwable e) {
			System.err.println(e);
		}
	}

	@Override
	protected String getName()
	{
		return "NullFS";
	}

	@Override
	protected String[] getOptions()
	{
		return null;
	}
}
