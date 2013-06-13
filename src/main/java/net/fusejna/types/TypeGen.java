package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeGen extends IntegerType
{
	private static final int size = 4;

	public TypeGen()
	{
		super(size);
	}

	public TypeGen(final long value)
	{
		super(size, value);
	}
}
