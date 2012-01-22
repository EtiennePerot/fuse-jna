package net.fusejna;

import net.fusejna.types.TypeSize;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

interface LibFuse extends Library
{
	static interface LibMacFuse extends LibFuse
	{
		String macfuse_version();
	}

	StructFuseContext.ByReference fuse_get_context();

	int fuse_main_real(int argc, String[] argv, StructFuseOperations op, TypeSize size, Pointer user_data);
}
