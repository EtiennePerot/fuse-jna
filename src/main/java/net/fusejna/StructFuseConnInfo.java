package net.fusejna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public abstract class StructFuseConnInfo extends Structure
{
	public static final class ByReference extends StructFuseConnInfo implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructFuseConnInfo implements Structure.ByValue
	{
	}

	public static final List<String> FIELD_ORDER = Arrays.asList("proto_major", "proto_minor", "async_read", "max_write",
			"max_readahead", "enable", "want", "reserved");
	public int proto_major;
	public int proto_minor;
	public int async_read;
	public int max_write;
	public int max_readahead;
	public int enable;
	public int want;
	public int[] reserved = new int[25];

	@Override
	protected List<String> getFieldOrder()
	{
		return FIELD_ORDER;
	}

	public final void setOptions(final boolean setVolumeName, final boolean caseInsensitive)
	{
		want = (setVolumeName ? 0x2 : 0x0) | (caseInsensitive ? 0x1 : 0x0);
		write();
	}
}
