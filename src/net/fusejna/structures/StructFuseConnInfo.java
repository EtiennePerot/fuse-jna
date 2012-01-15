package net.fusejna.structures;

import com.sun.jna.Structure;

public class StructFuseConnInfo extends Structure
{
	public static class ByReference extends StructFuseConnInfo implements Structure.ByReference
	{
	}

	public static class ByValue extends StructFuseConnInfo implements Structure.ByValue
	{
	}

	public int proto_major;
	public int proto_minor;
	public int async_read;
	public int max_write;
	public int max_readahead;
	public int enable;
	public int want;
	public int[] reserved = new int[25];

	public void setOptions(final boolean setVolumeName, final boolean caseInsensitive)
	{
		want = (setVolumeName ? 0x2 : 0x0) | (caseInsensitive ? 0x1 : 0x0);
		write();
	}
}
