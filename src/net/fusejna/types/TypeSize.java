package net.fusejna.types;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@SuppressWarnings("serial")
public class TypeSize extends NativeLong
{
	public TypeSize()
	{
	}

	public TypeSize(final long value)
	{
		super(value);
	}

	public TypeSize(final Structure struct)
	{
		this(struct.size());
	}
}
