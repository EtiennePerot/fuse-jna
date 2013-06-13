package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeQspare extends IntegerType
{
	private static final int size = 8;

	public TypeQspare()
	{
		super(size);
	}

	public TypeQspare(final long value)
	{
		super(size, value);
	}
}
