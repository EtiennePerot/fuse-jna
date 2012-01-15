package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeUid extends IntegerType
{
	private static final int size = 4;

	public TypeUid()
	{
		super(size);
	}

	public TypeUid(final long value)
	{
		super(size, value);
	}
}
