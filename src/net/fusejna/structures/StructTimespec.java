package net.fusejna.structures;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

public class StructTimespec extends Structure
{
	public static class ByReference extends StructFuseContext implements Structure.ByReference
	{
	}

	public static class ByValue extends StructTimespec implements Structure.ByValue
	{
	}

	public NativeLong tv_sec;
	public NativeLong tv_nsec;
}
