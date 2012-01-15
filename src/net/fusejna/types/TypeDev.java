package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeDev extends IntegerType
{
	private static final int size = 8;

	public TypeDev()
	{
		super(size);
	}

	public TypeDev(final long value)
	{
		super(size, value);
	}
}
