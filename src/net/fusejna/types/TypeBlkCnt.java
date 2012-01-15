package net.fusejna.types;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeBlkCnt extends IntegerType
{
	private static final int size = 8;

	public TypeBlkCnt()
	{
		super(size);
	}

	public TypeBlkCnt(final long value)
	{
		super(size, value);
	}
}
