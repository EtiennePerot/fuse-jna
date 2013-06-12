package net.fusejna.types;

import net.fusejna.Platform;

import com.sun.jna.IntegerType;
import com.sun.jna.Structure;

@SuppressWarnings("serial")
public class TypeSize extends IntegerType
{
	private static final int size;
	static {
		switch (Platform.platform()) {
			case MAC:
			case MAC_MACFUSE:
			case FREEBSD:
				size = 8;
				break;
			case LINUX_I686:
				size = 4;
				break;
			case LINUX_PPC:
			case LINUX_X86_64:
				size = Platform.size(TypeLongLong.class);
				break;
			default:
				size = 0;
		}
	}

	public TypeSize()
	{
		super(size);
	}

	public TypeSize(final long value)
	{
		super(size, value);
	}

	public TypeSize(final Structure struct)
	{
		this(struct.size());
	}
}
