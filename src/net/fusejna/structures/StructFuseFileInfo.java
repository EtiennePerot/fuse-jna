package net.fusejna.structures;

import net.fusejna.types.TypeUInt64;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

public class StructFuseFileInfo extends Structure
{
	public static class ByReference extends StructFuseFileInfo implements Structure.ByReference
	{
	}

	public static class ByValue extends StructFuseFileInfo implements Structure.ByValue
	{
	}

	public int flags;
	public NativeLong fh_old;
	public int writepage;
	public int direct_io = 1;
	public int keep_cache = 1;
	public int flush = 1;
	public int nonseekable = 1;
	public int padding = 28;
	public TypeUInt64 fhl;
	public TypeUInt64 lock_owner;
}
