package net.fusejna.util;

import java.io.File;

import net.fusejna.FuseFilesystem;

public abstract class FuseFilesystemAdapterFull extends FuseFilesystem
{
	@Override
	public void afterUnmount(final File mountPoint)
	{
	}

	@Override
	public void beforeUnmount(final File mountPoint)
	{
	}

	@Override
	public void destroy()
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
	public void init()
	{
	}

	@Override
	public void onMount(final File mountPoint)
	{
	}
}
