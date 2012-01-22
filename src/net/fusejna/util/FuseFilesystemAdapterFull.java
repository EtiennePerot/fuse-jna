package net.fusejna.util;

import java.io.File;

import net.fusejna.DirectoryFiller;
import net.fusejna.FuseFilesystem;
import net.fusejna.StructStat.StatSetter;

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
	public int getattr(final String path, final StatSetter stat)
	{
		return 0;
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

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		return 0;
	}
}
