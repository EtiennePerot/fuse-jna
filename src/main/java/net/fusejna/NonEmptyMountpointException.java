package net.fusejna;

import java.io.File;

public final class NonEmptyMountpointException extends InvalidMountpointException
{
	private static final long serialVersionUID = 6555882159072215811L;
	private static final String errorString = "Mountpoint is not empty";

	NonEmptyMountpointException(final File mountpoint)
	{
		super(errorString, mountpoint);
	}
}
