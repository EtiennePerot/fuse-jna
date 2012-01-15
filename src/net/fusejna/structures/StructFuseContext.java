package net.fusejna.structures;

import net.fusejna.types.TypeGid;
import net.fusejna.types.TypePid;
import net.fusejna.types.TypeUid;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class StructFuseContext extends Structure
{
	public static class ByReference extends StructFuseContext implements Structure.ByReference
	{
	}

	public static class ByValue extends StructFuseContext implements Structure.ByValue
	{
	}

	public Pointer fuse;
	public TypeUid uid;
	public TypeGid gid;
	public TypePid pid;
	public Pointer private_data;
}
