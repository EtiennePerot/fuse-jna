package net.fusejna;

import java.io.File;

public abstract class FuseFilesystem
{
	public final void mount(final File mountPoint)
	{
		// TODO
	}

	public final void mount(final String mountPoint)
	{
		mount(new File(mountPoint));
	}
}
