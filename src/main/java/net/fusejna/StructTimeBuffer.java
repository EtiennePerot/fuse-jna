package net.fusejna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class StructTimeBuffer extends Structure
{
	public static final class ByReference extends StructTimeBuffer implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructTimeBuffer implements Structure.ByValue
	{
	}

	public static final class TimeBufferWrapper
	{
		private final StructTimeBuffer timeBuffer;

		TimeBufferWrapper(final StructTimeBuffer timeBuffer)
		{
			this.timeBuffer = timeBuffer;
		}

		public final long ac_nsec()
		{
			return timeBuffer.actime.nsec();
		}

		public final long ac_sec()
		{
			return timeBuffer.actime.sec();
		}

		public final TimeBufferWrapper ac_set(final double time)
		{
			timeBuffer.actime.set(time);
			return this;
		}

		public final TimeBufferWrapper ac_set(final long sec, final long nsec)
		{
			timeBuffer.actime.set(sec, nsec);
			return this;
		}

		public final TimeBufferWrapper ac_setMillis(final long millis)
		{
			timeBuffer.actime.setMillis(millis);
			return this;
		}

		public final TimeBufferWrapper ac_setSeconds(final long seconds)
		{
			timeBuffer.actime.setSeconds(seconds);
			return this;
		}

		public final TimeBufferWrapper both_set(final double time)
		{
			ac_set(time);
			mod_set(time);
			return this;
		}

		public final TimeBufferWrapper both_set(final long sec, final long nsec)
		{
			ac_set(sec, nsec);
			mod_set(sec, nsec);
			return this;
		}

		public final TimeBufferWrapper both_setMillis(final long millis)
		{
			ac_setMillis(millis);
			mod_setMillis(millis);
			return this;
		}

		public final TimeBufferWrapper both_setSeconds(final long seconds)
		{
			ac_setSeconds(seconds);
			mod_setSeconds(seconds);
			return this;
		}

		public final long mod_nsec()
		{
			return timeBuffer.modtime.nsec();
		}

		public final long mod_sec()
		{
			return timeBuffer.modtime.sec();
		}

		public final TimeBufferWrapper mod_set(final double time)
		{
			timeBuffer.modtime.set(time);
			return this;
		}

		public final TimeBufferWrapper mod_set(final long sec, final long nsec)
		{
			timeBuffer.modtime.set(sec, nsec);
			return this;
		}

		public final TimeBufferWrapper mod_setMillis(final long millis)
		{
			timeBuffer.modtime.setMillis(millis);
			return this;
		}

		public final TimeBufferWrapper mod_setSeconds(final long seconds)
		{
			timeBuffer.modtime.setSeconds(seconds);
			return this;
		}

		@Override
		public final String toString()
		{
			return timeBuffer.toString();
		}

		final void write()
		{
			timeBuffer.write();
		}
	}

	public static final List<String> FIELD_ORDER = Arrays.asList("actime", "modtime");
	public StructTimespec.ByValue actime;
	public StructTimespec.ByValue modtime;

	@Override
	protected List<String> getFieldOrder()
	{
		return FIELD_ORDER;
	}
}
