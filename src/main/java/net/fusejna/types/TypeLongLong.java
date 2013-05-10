package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeLongLong extends IntegerType
{
	private static final int size = 8;

	public TypeLongLong()
	{
		super(size);
	}

	public TypeLongLong(final long value)
	{
		super(size, value);
	}
}
