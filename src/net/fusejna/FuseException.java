package net.fusejna;

public final class FuseException extends Exception
{
	private static final long serialVersionUID = -3323428017667312747L;

	FuseException(final int returnCode)
	{
		super("fuse returned error code " + returnCode);
	}
}
