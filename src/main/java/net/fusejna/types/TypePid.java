package net.fusejna.types;

import net.fusejna.Platform;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypePid extends IntegerType
{
	private static final int size;
	static {
		switch (Platform.platform()) {
			case MAC:
			case MAC_MACFUSE:
			case FREEBSD:
				size = 4;
				break;
			case LINUX_I686:
			case LINUX_PPC:
			case LINUX_X86_64:
				size = Platform.size(Integer.class);
				break;
			default:
				size = 0;
		}
	}

	public TypePid()
	{
		super(size);
	}

	public TypePid(final long value)
	{
		super(size, value);
	}
}
