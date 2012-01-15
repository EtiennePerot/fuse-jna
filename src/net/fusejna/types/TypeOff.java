package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeOff extends IntegerType
{
	private static final int size = 8;

	public TypeOff()
	{
		super(size);
	}

	public TypeOff(final long value)
	{
		super(size, value);
	}
}
