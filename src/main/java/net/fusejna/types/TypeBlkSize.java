package net.fusejna.types;

import net.fusejna.Platform;

import com.sun.jna.IntegerType;
import com.sun.jna.NativeLong;

@SuppressWarnings("serial")
public class TypeBlkSize extends IntegerType
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
				size = Platform.size(NativeLong.class);
				break;
			default:
				size = 0;
		}
	}

	public TypeBlkSize()
	{
		super(size);
	}

	public TypeBlkSize(final long value)
	{
		super(size, value);
	}
}
