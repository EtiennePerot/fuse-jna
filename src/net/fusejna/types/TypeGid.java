package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeGid extends IntegerType
{
	private static final int size = 4;

	public TypeGid()
	{
		super(size);
	}

	public TypeGid(final long value)
	{
		super(size, value);
	}
}
