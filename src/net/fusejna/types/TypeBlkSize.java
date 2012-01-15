package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeBlkSize extends IntegerType
{
	private static final int size = 8;

	public TypeBlkSize()
	{
		super(size);
	}

	public TypeBlkSize(final long value)
	{
		super(size, value);
	}
}
