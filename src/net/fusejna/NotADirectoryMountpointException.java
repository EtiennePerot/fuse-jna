package net.fusejna;

import java.io.File;

public final class NotADirectoryMountpointException extends InvalidMountpointException
{
	private static final long serialVersionUID = -4570986376552747630L;
	private static final String errorString = "Not a directory";

	NotADirectoryMountpointException(final File mountpoint)
	{
		super(errorString, mountpoint);
	}
}
