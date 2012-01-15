package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypePid extends IntegerType
{
	private static final int size = 4;

	public TypePid()
	{
		super(size);
	}

	public TypePid(final long value)
	{
		super(size, value);
	}
}
