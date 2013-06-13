package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeUInt64 extends IntegerType
{
	private static final int size = 8;

	public TypeUInt64()
	{
		super(size);
	}

	public TypeUInt64(final long value)
	{
		super(size, value);
	}
}
