package net.fusejna.types;

import net.fusejna.Platform;

import com.sun.jna.IntegerType;

@SuppressWarnings("serial")
public class TypeMode extends IntegerType
{
	public static interface IModeWrapper
	{
		public long mode();

		public IModeWrapper mode(final long bits);

		public IModeWrapper setMode(final NodeType type);

		public IModeWrapper setMode(final NodeType type, final boolean readable, final boolean writable,
				final boolean executable);

		public IModeWrapper setMode(final NodeType type, final boolean ownerReadable, final boolean ownerWritable,
				final boolean ownerExecutable, final boolean groupReadable, final boolean groupWritable,
				final boolean groupExecutable, final boolean otherReadable, final boolean otherWritable,
				final boolean otherExecutable);

		public NodeType type();
	}

	public static final class ModeWrapper implements IModeWrapper
	{
		private long bits;

		public ModeWrapper(final long bits)
		{
			this.bits = bits;
		}

		public ModeWrapper(final TypeMode mode)
		{
			this(mode.longValue());
		}

		@Override
		public final long mode()
		{
			return bits;
		}

		@Override
		public final ModeWrapper mode(final long bits)
		{
			this.bits = bits;
			return this;
		}

		@Override
		public final ModeWrapper setMode(final NodeType type)
		{
			return setMode(type, true, true, true, true, true, true, true, true, true);
		}

		@Override
		public final ModeWrapper setMode(final NodeType type, final boolean readable, final boolean writable,
				final boolean executable)
		{
			return setMode(type, readable, writable, executable, readable, writable, executable, readable, writable, executable);
		}

		@Override
		public final ModeWrapper setMode(final NodeType type, final boolean ownerReadable, final boolean ownerWritable,
				final boolean ownerExecutable, final boolean groupReadable, final boolean groupWritable,
				final boolean groupExecutable, final boolean otherReadable, final boolean otherWritable,
				final boolean otherExecutable)
		{
			long mode = (type == null ? NodeType.FILE : type).getBits();
			mode |= (ownerReadable ? S_IRUSR : 0L) | (ownerWritable ? S_IWUSR : 0L) | (ownerExecutable ? S_IXUSR : 0L);
			mode |= (groupReadable ? S_IRGRP : 0L) | (groupWritable ? S_IWGRP : 0L) | (groupExecutable ? S_IXGRP : 0L);
			mode |= (otherReadable ? S_IROTH : 0L) | (otherWritable ? S_IWOTH : 0L) | (otherExecutable ? S_IXOTH : 0L);
			return mode(mode);
		}

		@Override
		public final String toString()
		{
			return type() + String.format("(%o)", bits);
		}

		@Override
		public final NodeType type()
		{
			return NodeType.fromBits(bits);
		}
	}

	public static enum NodeType
	{
		FILE, DIRECTORY, SYMBOLIC_LINK, SOCKET, FIFO, BLOCK_DEVICE;
		public static final NodeType fromBits(final long bits)
		{
			final int intBits = (int) (bits & maskNodeType);
			switch (intBits) {
				case (int) S_IFREG:
					return FILE;
				case (int) S_IFDIR:
					return DIRECTORY;
				case (int) S_IFLNK:
					return SYMBOLIC_LINK;
				case (int) S_IFSOCK:
					return SOCKET;
				case (int) S_IFIFO:
					return FIFO;
				case (int) S_IFBLK:
					return BLOCK_DEVICE;
			}
			return null;
		}

		public final long getBits()
		{
			switch (this) {
				case FILE:
					return S_IFREG;
				case DIRECTORY:
					return S_IFDIR;
				case SYMBOLIC_LINK:
					return S_IFLNK;
				case SOCKET:
					return S_IFSOCK;
				case FIFO:
					return S_IFIFO;
				case BLOCK_DEVICE:
					return S_IFBLK;
			}
			return -1L;
		}
	}

	public static final long maskNodeType = 0170000;
	public static final long S_IFSOCK = 0140000;
	public static final long S_IFLNK = 0120000;
	public static final long S_IFREG = 0100000;
	public static final long S_IFBLK = 0060000;
	public static final long S_IFDIR = 0040000;
	public static final long S_IFCHR = 0020000;
	public static final long S_IFIFO = 0010000;
	public static final long S_ISUID = 0004000;
	public static final long S_ISGID = 0002000;
	public static final long S_ISVTX = 0001000;
	public static final long S_IRUSR = 00400;
	public static final long S_IWUSR = 00200;
	public static final long S_IXUSR = 00100;
	public static final long S_IRGRP = 00040;
	public static final long S_IWGRP = 00020;
	public static final long S_IXGRP = 00010;
	public static final long S_IROTH = 00004;
	public static final long S_IWOTH = 00002;
	public static final long S_IXOTH = 00001;
	private static final int size;
	static {
		switch (Platform.platform()) {
			case MAC:
			case MAC_MACFUSE:
			case FREEBSD:
				size = 2;
				break;
			case LINUX_I686:
			case LINUX_PPC:
			case LINUX_X86_64:
				size = Platform.size(Integer.class);
				break;
			default:
				size = 0;
		}
	}

	public TypeMode()
	{
		super(size);
	}

	public TypeMode(final long value)
	{
		super(size, value);
	}
}
