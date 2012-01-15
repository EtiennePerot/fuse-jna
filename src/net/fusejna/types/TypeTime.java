package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeTime extends IntegerType
{
	private static final int size = 8;

	public TypeTime()
	{
		super(size);
	}

	public TypeTime(final long value)
	{
		super(size, value);
	}
}
