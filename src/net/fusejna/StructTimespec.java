package net.fusejna;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

public class StructTimespec extends Structure
{
	public static final class ByReference extends StructTimespec implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructTimespec implements Structure.ByValue
	{
	}

	public NativeLong tv_sec;
	public NativeLong tv_nsec;

	public long nsec()
	{
		return tv_nsec.longValue();
	}

	public long sec()
	{
		return tv_sec.longValue();
	}

	public final void set(final double time)
	{
		set((long) time, (long) (time * 1000000000d));
	}

	public final void set(final long sec, final long nsec)
	{
		tv_sec.setValue(sec);
		tv_nsec.setValue(nsec);
		write();
	}

	public final void setMillis(final long millis)
	{
		set(millis / 1000L, (millis % 1000L) * 1000000L);
	}

	public final void setSeconds(final long seconds)
	{
		set(seconds);
	}
}
