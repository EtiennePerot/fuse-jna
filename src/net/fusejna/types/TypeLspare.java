package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeLspare extends IntegerType
{
	private static final int size = 4;

	public TypeLspare()
	{
		super(size);
	}

	public TypeLspare(final long value)
	{
		super(size, value);
	}
}
