package net.fusejna;

import java.io.File;

public abstract class InvalidMountpointException extends IllegalArgumentException
{
	private static final long serialVersionUID = -4067651016257829200L;
	private final File mountpoint;

	InvalidMountpointException(final String error, final File mountpoint)
	{
		super(error + ": " + mountpoint);
		this.mountpoint = mountpoint;
	}

	public final File getMountpoint()
	{
		return mountpoint;
	}
}
