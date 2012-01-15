package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeIno extends IntegerType
{
	private static final int size = 8;

	public TypeIno()
	{
		super(size);
	}

	public TypeIno(final long value)
	{
		super(size, value);
	}
}
