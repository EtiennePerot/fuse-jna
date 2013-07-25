package net.fusejna;

import java.util.Arrays;
import java.util.List;

import net.fusejna.types.TypeUInt64;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

public class StructFuseFileInfo extends Structure
{
	public static final class ByReference extends StructFuseFileInfo implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructFuseFileInfo implements Structure.ByValue
	{
	}

	public static final class FileInfoWrapper
	{
		public static enum OpenMode
		{
			READONLY, WRITEONLY, READWRITE;
			public final static OpenMode fromBits(int bits)
			{
				bits = bits & openMask;
				switch (bits) {
					case O_RDONLY:
						return READONLY;
					case O_WRONLY:
						return WRITEONLY;
					case O_RDWR:
						return READWRITE;
					default:
						return null;
				}
			}

			public final int getBits()
			{
				switch (this) {
					case READONLY:
						return O_RDONLY;
					case WRITEONLY:
						return O_WRONLY;
					case READWRITE:
						return O_RDWR;
					default:
						return 0;
				}
			}
		}

		private int flags;
		private boolean modified = false;
		private final StructFuseFileInfo fileinfo;
		private final String path;

		FileInfoWrapper(final String path, final StructFuseFileInfo fileinfo)
		{
			this.path = path;
			this.fileinfo = fileinfo;
			flags = fileinfo.flags;
		}

		FileInfoWrapper(final StructFuseFileInfo fileinfo)
		{
			this(null, fileinfo);
		}

		public final boolean append()
		{
			return (flags & O_APPEND) != 0;
		}

		public final FileInfoWrapper append(final boolean append)
		{
			modified = true;
			flags = (flags & ~O_APPEND) | (append ? O_APPEND : 0);
			return this;
		}

		public final boolean create()
		{
			return (flags & O_CREAT) != 0;
		}

		public final FileInfoWrapper create(final boolean create)
		{
			modified = true;
			flags = (flags & ~O_CREAT) | (create ? O_CREAT : 0);
			return this;
		}

		public final boolean direct_io()
		{
			return (fileinfo.flags_bitfield & BIT_DIRECT_IO) != 0;
		}

		public final FileInfoWrapper direct_io(final boolean direct_io)
		{
			modified = true;

			if (direct_io) {
				fileinfo.flags_bitfield |= BIT_DIRECT_IO;
			} else {
				fileinfo.flags_bitfield &= ~BIT_DIRECT_IO;
			}

			return this;
		}

		public final long fh()
		{
			return fileinfo.fh.longValue();
		}

		public final FileInfoWrapper fh(final long fh)
		{
			modified = true;
			fileinfo.fh.setValue(fh);
			return this;
		}

		public final long fh_old()
		{
			return fileinfo.fh_old.longValue();
		}

		public final FileInfoWrapper fh_old(final long fh_old)
		{
			modified = true;
			fileinfo.fh_old.setValue(fh_old);
			return this;
		}

		public final int flags()
		{
			return flags;
		}

		public final FileInfoWrapper flags(final int flags)
		{
			modified = true;
			this.flags = flags;
			return this;
		}

		public final boolean flockrelease()
		{
			return (fileinfo.flags_bitfield & BIT_FLOCKRELEASE) != 0;
		}

		public final FileInfoWrapper flockrelease(final boolean flockrelease)
		{
			modified = true;

			if (flockrelease) {
				fileinfo.flags_bitfield |= BIT_FLOCKRELEASE;
			} else {
				fileinfo.flags_bitfield &= ~BIT_FLOCKRELEASE;
			}
			return this;
		}

		public final boolean flush()
		{
			return (fileinfo.flags_bitfield & BIT_FLUSH) != 0;
		}

		public final FileInfoWrapper flush(final boolean flush)
		{
			modified = true;

			if (flush) {
				fileinfo.flags_bitfield |= BIT_FLUSH;
			} else {
				fileinfo.flags_bitfield &= ~BIT_FLUSH;
			}

			return this;
		}

		public final boolean keep_cache()
		{
			return (fileinfo.flags_bitfield & BIT_KEEP_CACHE) != 0;
		}

		public final FileInfoWrapper keep_cache(final boolean keep_cache)
		{
			modified = true;

			if (keep_cache) {
				fileinfo.flags_bitfield |= BIT_KEEP_CACHE;
			} else {
				fileinfo.flags_bitfield &= ~BIT_KEEP_CACHE;
			}

			return this;
		}

		public final long lock_owner()
		{
			return fileinfo.lock_owner.longValue();
		}

		public final FileInfoWrapper lock_owner(final long lock_owner)
		{
			modified = true;
			fileinfo.lock_owner.setValue(lock_owner);
			return this;
		}

		public final boolean nonseekable()
		{
			return (fileinfo.flags_bitfield & BIT_NONSEEKABLE) != 0;
		}

		public final FileInfoWrapper nonseekable(final boolean nonseekable)
		{
			modified = true;

			if (nonseekable) {
				fileinfo.flags_bitfield |= BIT_NONSEEKABLE;
			} else {
				fileinfo.flags_bitfield &= ~BIT_NONSEEKABLE;
			}
			return this;
		}

		public final OpenMode openMode()
		{
			return OpenMode.fromBits(flags);
		}

		public final FileInfoWrapper openMode(final OpenMode openMode)
		{
			modified = true;
			flags = (flags & ~openMask) | openMode.getBits();
			return this;
		}

		@Override
		public final String toString()
		{
			if (path != null) {
				return path + "\n" + fileinfo;
			}
			return fileinfo.toString();
		}

		public final boolean truncate()
		{
			return (flags & O_TRUNC) != 0;
		}

		public final FileInfoWrapper truncate(final boolean truncate)
		{
			modified = true;
			flags = (flags & ~O_TRUNC) | (truncate ? O_TRUNC : 0);
			return this;
		}

		final void write()
		{
			if (modified) {
				fileinfo.flags = flags;
				fileinfo.write();
			}
			modified = false;
		}

		public final boolean writepage()
		{
			return fileinfo.writepage != 0;
		}

		public final FileInfoWrapper writepage(final boolean writepage)
		{
			modified = true;
			fileinfo.writepage = writepage ? 1 : 0;
			return this;
		}
	}

	public static final List<String> FIELD_ORDER = Arrays.asList("flags", "fh_old", "writepage", "flags_bitfield",
					"fh", "lock_owner");
	public static final int openMask = 03;
	public static final int O_RDONLY = 00;
	public static final int O_WRONLY = 01;
	public static final int O_RDWR = 02;
	public static final int O_CREAT = 0100;
	public static final int O_EXCL = 0200;
	public static final int O_NOCTTY = 0400;
	public static final int O_TRUNC = 01000;
	public static final int O_APPEND = 02000;
	public static final int O_NONBLOCK = 04000;
	public static final int O_NDELAY = O_NONBLOCK;
	public static final int O_SYNC = 010000;
	public static final int O_ASYNC = 020000;
	public static final int O_DIRECT = 040000;
	public static final int O_DIRECTORY = 0200000;
	public static final int O_NOFOLLOW = 0400000;
	public static final int O_NOATIME = 01000000;
	public static final int O_CLOEXEC = 02000000;
	public int flags;
	public NativeLong fh_old;
	public int writepage;

	private static final int BIT_DIRECT_IO = 1 << 0;
	private static final int BIT_KEEP_CACHE = 1 << 1;
	private static final int BIT_FLUSH = 1 << 2;
	private static final int BIT_NONSEEKABLE = 1 << 3;
	private static final int BIT_FLOCKRELEASE = 1 << 4;
	public int flags_bitfield;

	public TypeUInt64 fh;
	public TypeUInt64 lock_owner;

	@Override
	protected List<String> getFieldOrder()
	{
		return FIELD_ORDER;
	}
}
