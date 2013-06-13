package net.fusejna;

import net.fusejna.types.TypeGid;
import net.fusejna.types.TypePid;
import net.fusejna.types.TypeUid;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public abstract class StructFuseContext extends Structure
{
	public static final List<String> FIELD_ORDER = Arrays.asList(
			"fuse", "uid", "gid", "pid", "private_data");

	public static final class ByReference extends StructFuseContext implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructFuseContext implements Structure.ByValue
	{
	}

	public Pointer fuse;
	public TypeUid uid;
	public TypeGid gid;
	public TypePid pid;
	public Pointer private_data;

	@Override
	protected List getFieldOrder()
	{
		return FIELD_ORDER;
	}
}
