package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeNLink extends IntegerType
{
	private static final int size = 8;

	public TypeNLink()
	{
		super(size);
	}

	public TypeNLink(final long value)
	{
		super(size, value);
	}
}
