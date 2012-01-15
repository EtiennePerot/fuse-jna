package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeMode extends IntegerType
{
	private static final int size = 4;

	public TypeMode()
	{
		super(size);
	}

	public TypeMode(final long value)
	{
		super(size, value);
	}
}
