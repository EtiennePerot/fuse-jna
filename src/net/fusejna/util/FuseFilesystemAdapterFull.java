package net.fusejna.util;

import java.io.File;

import net.fusejna.FuseFilesystem;

public abstract class FuseFilesystemAdapterFull extends FuseFilesystem
{
	@Override
	protected void afterUnmount(final File mountPoint)
	{
	}

	@Override
	protected void beforeUnmount(final File mountPoint)
	{
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
	protected void onMount(final File mountPoint)
	{
	}
}
