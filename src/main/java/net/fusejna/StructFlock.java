package net.fusejna;

import java.util.Arrays;
import java.util.List;

import net.fusejna.types.TypeOff;
import net.fusejna.types.TypePid;

import com.sun.jna.Structure;

public abstract class StructFlock extends Structure
{
	public static enum FlockType
	{
		READ_LOCK, WRITE_LOCK, NO_LOCK;
		public static FlockType fromBits(final long bits)
		{
			switch ((int) bits) {
				case F_RDLCK:
					return READ_LOCK;
				case F_WRLCK:
					return WRITE_LOCK;
				case F_UNLCK:
					return NO_LOCK;
			}
			return null;
		}

		public long getBits()
		{
			switch (this) {
				case READ_LOCK:
					return F_RDLCK;
				case WRITE_LOCK:
					return F_WRLCK;
				case NO_LOCK:
					return F_UNLCK;
			}
			return -1;
		}
	}

	public static final class FlockWrapper
	{
		private final StructFlock structFlock;
		private final String path;

		FlockWrapper(final String path, final StructFlock structFlock)
		{
			this.path = path;
			this.structFlock = structFlock;
		}

		FlockWrapper(final StructFlock structFlock)
		{
			this(null, structFlock);
		}

		public final FlockType flockType()
		{
			return FlockType.fromBits(type());
		}

		public final FlockWrapper flockType(final FlockType type)
		{
			return type(type.getBits());
		}

		public final long len()
		{
			return structFlock.l_len();
		}

		public final FlockWrapper len(final long l_len)
		{
			structFlock.l_len(l_len);
			return this;
		}

		public final long pid()
		{
			return structFlock.l_pid();
		}

		public final FlockWrapper pid(final long l_pid)
		{
			structFlock.l_pid(l_pid);
			return this;
		}

		public final long start()
		{
			return structFlock.l_start();
		}

		public final FlockWrapper start(final long l_start)
		{
			structFlock.l_start(l_start);
			return this;
		}

		public final long sysid()
		{
			return structFlock.l_sysid();
		}

		public final FlockWrapper sysid(final long l_sysid)
		{
			structFlock.l_sysid(l_sysid);
			return this;
		}

		@Override
		public final String toString()
		{
			if (path != null) {
				return path + "\n" + structFlock;
			}
			return structFlock.toString();
		}

		public final long type()
		{
			return structFlock.l_type();
		}

		public final FlockWrapper type(final long l_type)
		{
			structFlock.l_type(l_type);
			return this;
		}

		public final long whence()
		{
			return structFlock.l_whence();
		}

		public final FlockWrapper whence(final long l_whence)
		{
			structFlock.l_whence(l_whence);
			return this;
		}

		final void write()
		{
			structFlock.write();
		}
	}

	public static class FreeBSD extends StructFlock
	{
		public static final class ByReference extends FreeBSD implements Structure.ByReference
		{
		}

		public static final class ByValue extends FreeBSD implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("l_start", "l_len", "l_pid", "l_type", "l_whence",
				"l_sysid");
		public TypeOff l_start;
		public TypeOff l_len;
		public TypePid l_pid;
		public short l_type;
		public short l_whence;
		public int l_sysid;

		@Override
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final long l_len()
		{
			return l_len.longValue();
		}

		@Override
		final void l_len(final long l_len)
		{
			this.l_len.setValue(l_len);
		}

		@Override
		final long l_pid()
		{
			return l_pid.longValue();
		}

		@Override
		final void l_pid(final long l_pid)
		{
			this.l_pid.setValue(l_pid);
		}

		@Override
		final long l_start()
		{
			return l_start.longValue();
		}

		@Override
		final void l_start(final long l_start)
		{
			this.l_start.setValue(l_start);
		}

		@Override
		final long l_sysid()
		{
			return l_sysid;
		}

		@Override
		final void l_sysid(final long l_sysid)
		{
			this.l_sysid = (int) l_sysid;
		}

		@Override
		final long l_type()
		{
			return l_type;
		}

		@Override
		final void l_type(final long l_type)
		{
			this.l_type = (short) l_type;
		}

		@Override
		final long l_whence()
		{
			return l_whence;
		}

		@Override
		final void l_whence(final long l_whence)
		{
			this.l_whence = (short) l_whence;
		}
	}

	public static class NotFreeBSD extends StructFlock
	{
		public static final class ByReference extends FreeBSD implements Structure.ByReference
		{
		}

		public static final class ByValue extends FreeBSD implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("l_type", "l_whence", "l_start", "l_len", "l_pid");
		public short l_type;
		public short l_whence;
		public TypeOff l_start;
		public TypeOff l_len;
		public TypePid l_pid;

		@Override
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final long l_len()
		{
			return l_len.longValue();
		}

		@Override
		final void l_len(final long l_len)
		{
			this.l_len.setValue(l_len);
		}

		@Override
		final long l_pid()
		{
			return l_pid.longValue();
		}

		@Override
		final void l_pid(final long l_pid)
		{
			this.l_pid.setValue(l_pid);
		}

		@Override
		final long l_start()
		{
			return l_start.longValue();
		}

		@Override
		final void l_start(final long l_start)
		{
			this.l_start.setValue(l_start);
		}

		@Override
		final long l_sysid()
		{
			return -1L;
		}

		@Override
		final void l_sysid(final long l_sysid)
		{
			// Not implemented
		}

		@Override
		final long l_type()
		{
			return l_type;
		}

		@Override
		final void l_type(final long l_type)
		{
			this.l_type = (short) l_type;
		}

		@Override
		final long l_whence()
		{
			return l_whence;
		}

		@Override
		final void l_whence(final long l_whence)
		{
			this.l_whence = (short) l_whence;
		}
	}

	public static final int F_RDLCK = 0;
	public static final int F_WRLCK = 1;
	public static final int F_UNLCK = 2;

	abstract long l_len();

	abstract void l_len(long l_len);

	abstract long l_pid();

	abstract void l_pid(long l_pid);

	abstract long l_start();

	abstract void l_start(long l_start);

	abstract long l_sysid();

	abstract void l_sysid(long l_sysid);

	abstract long l_type();

	abstract void l_type(long l_type);

	abstract long l_whence();

	abstract void l_whence(long l_whence);
}
