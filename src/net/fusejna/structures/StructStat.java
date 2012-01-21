package net.fusejna.structures;

import net.fusejna.types.TypeBlkCnt;
import net.fusejna.types.TypeBlkSize;
import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeIno;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeNLink;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeTime;
import net.fusejna.types.TypeUid;

import com.sun.jna.Structure;

public class StructStat extends Structure
{
	public static final class ByReference extends StructStat implements Structure.ByReference
	{
	}

	public static final class ByValue extends StructStat implements Structure.ByValue
	{
	}

	public static enum NodeType
	{
		FILE, DIRECTORY, SYMBOLIC_LINK, SOCKET, FIFO, BLOCK_DEVICE;
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

	public static final class StatSetter
	{
		private final StructStat structStat;

		StatSetter(final StructStat structStat)
		{
			this.structStat = structStat;
		}

		public final StatSetter atime(final long atime)
		{
			structStat.st_atime.setValue(atime);
			return this;
		}

		public final StatSetter blksize(final long blksize)
		{
			structStat.st_blksize.setValue(blksize);
			return this;
		}

		public final StatSetter blocks(final long blocks)
		{
			structStat.st_blocks.setValue(blocks);
			return this;
		}

		public final StatSetter ctime(final long ctime)
		{
			structStat.st_atime.setValue(ctime);
			return this;
		}

		public final StatSetter dev(final long dev)
		{
			structStat.st_dev.setValue(dev);
			return this;
		}

		public final StatSetter gid(final long gid)
		{
			structStat.st_gid.setValue(gid);
			return this;
		}

		public final StatSetter ino(final long ino)
		{
			structStat.st_ino.setValue(ino);
			return this;
		}

		public final StatSetter mode(final long mode)
		{
			structStat.st_mode.setValue(mode);
			return this;
		}

		public final StatSetter mtime(final long mtime)
		{
			structStat.st_atime.setValue(mtime);
			return this;
		}

		public final StatSetter nlink(final long nlink)
		{
			structStat.st_nlink.setValue(nlink);
			return this;
		}

		public final StatSetter rdev(final long rdev)
		{
			structStat.st_rdev.setValue(rdev);
			return this;
		}

		public final StatSetter setAllTimes(final long time)
		{
			return setAllTimes(time, time, time);
		}

		public final StatSetter setAllTimes(final long atime, final long mtime, final long ctime)
		{
			structStat.st_atime.setValue(atime);
			structStat.st_mtime.setValue(mtime);
			structStat.st_ctime.setValue(ctime);
			return this;
		}

		public final StatSetter setMode(final NodeType type)
		{
			return setMode(type, true, true, true, true, true, true, true, true, true);
		}

		public final StatSetter setMode(final NodeType type, final boolean readable, final boolean writable,
				final boolean executable)
		{
			return setMode(type, readable, writable, executable, readable, writable, executable, readable, writable, executable);
		}

		public final StatSetter setMode(final NodeType type, final boolean ownerReadable, final boolean ownerWritable,
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

		public final StatSetter size(final long size)
		{
			structStat.st_size.setValue(size);
			return this;
		}

		@Override
		public final String toString()
		{
			return structStat.toString();
		}

		public final StatSetter uid(final long uid)
		{
			structStat.st_uid.setValue(uid);
			return this;
		}
	}

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
	public TypeDev st_dev;
	public TypeIno st_ino;
	public TypeMode st_mode;
	public TypeNLink st_nlink;
	public TypeUid st_uid;
	public TypeGid st_gid;
	public TypeDev st_rdev;
	public TypeOff st_size;
	public TypeBlkSize st_blksize;
	public TypeBlkCnt st_blocks;
	public TypeTime st_atime;
	public TypeTime st_mtime;
	public TypeTime st_ctime;
}
