package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeUInt32 extends IntegerType
{
	private static final int size = 4;

	public TypeUInt32()
	{
		super(size);
	}

	public TypeUInt32(final long value)
	{
		super(size, value);
	}
}
