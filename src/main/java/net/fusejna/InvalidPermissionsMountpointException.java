package net.fusejna;

import java.io.File;

public final class InvalidPermissionsMountpointException extends InvalidMountpointException
{
	private static final long serialVersionUID = -1641971209266080598L;
	private static final String errorString = "Mountpoint has insufficient permissions";

	InvalidPermissionsMountpointException(final File mountpoint)
	{
		super(errorString, mountpoint);
	}
}
