package net.fusejna;

import net.fusejna.types.TypeBlkCnt;
import net.fusejna.types.TypeBlkSize;
import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGen;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeIno;
import net.fusejna.types.TypeLspare;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeNLink;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeQspare;
import net.fusejna.types.TypeUid;

import com.sun.jna.Structure;

public abstract class StructStat extends Structure
{
	public static class bsd extends StructStat
	{
		public static final class ByReference extends bsd implements Structure.ByReference
		{
		}

		public static final class ByValue extends bsd implements Structure.ByValue
		{
		}

		public TypeDev st_dev;
		public TypeIno st_ino;
		public TypeMode st_mode;
		public TypeNLink st_nlink;
		public TypeUid st_uid;
		public TypeGid st_gid;
		public TypeDev st_rdev;
		public StructTimespec.ByValue st_atime;
		public StructTimespec.ByValue st_mtime;
		public StructTimespec.ByValue st_ctime;
		public TypeOff st_size;
		public TypeBlkCnt st_blocks;
		public TypeBlkSize st_blksize;

		@Override
		public final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		public void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		public final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		public final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		public final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		public final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		public final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		public final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		public final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		public final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		public final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		public final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		public final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		public final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		public final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		public final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		public final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static class i686 extends StructStat
	{
		public static final class ByReference extends i686 implements Structure.ByReference
		{
		}

		public static final class ByValue extends i686 implements Structure.ByValue
		{
		}

		public TypeDev st_dev;
		public short __pad0;
		public TypeIno __pad1;
		public TypeMode st_mode;
		public TypeNLink st_nlink;
		public TypeUid st_uid;
		public TypeGid st_gid;
		public TypeDev st_rdev;
		public short __pad2;
		public TypeOff st_size;
		public TypeBlkSize st_blksize;
		public TypeBlkCnt st_blocks;
		public StructTimespec.ByValue st_atime;
		public StructTimespec.ByValue st_mtime;
		public StructTimespec.ByValue st_ctime;
		public TypeIno st_ino;

		@Override
		public final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		public void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		public final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		public final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		public final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		public final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		public final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		public final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		public final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		public final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		public final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		public final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		public final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		public final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		public final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		public final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		public final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static class mac extends StructStat
	{
		public static final class ByReference extends mac implements Structure.ByReference
		{
		}

		public static final class ByValue extends mac implements Structure.ByValue
		{
		}

		public TypeDev st_dev;
		public TypeMode st_mode;
		public TypeNLink st_nlink;
		public TypeIno st_ino;
		public TypeUid st_uid;
		public TypeGid st_gid;
		public TypeDev st_rdev;
		public StructTimespec.ByValue st_atime;
		public StructTimespec.ByValue st_mtime;
		public StructTimespec.ByValue st_ctime;
		public StructTimespec.ByValue st_birthtime;
		public TypeOff st_size;
		public TypeBlkCnt st_blocks;
		public TypeBlkSize st_blksize;
		public TypeGen st_gen;
		public TypeLspare st_lspare;
		public TypeQspare st_qspare;

		@Override
		public final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		public void st_birthtime(final long sec, final long nsec)
		{
			st_birthtime.set(sec, nsec);
		}

		@Override
		public final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		public final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		public final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		public final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		public final void st_gen(final long st_gen)
		{
			this.st_gen.setValue(st_gen);
		}

		@Override
		public final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		public final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		public final void st_lspare(final long st_lspare)
		{
			this.st_lspare.setValue(st_lspare);
		}

		@Override
		public final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		public final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		public final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		public final void st_qspare(final long st_qspare)
		{
			this.st_qspare.setValue(st_qspare);
		}

		@Override
		public final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		public final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		public final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
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

	public static class ppc extends StructStat
	{
		public static final class ByReference extends ppc implements Structure.ByReference
		{
		}

		public static final class ByValue extends ppc implements Structure.ByValue
		{
		}

		public TypeDev st_dev;
		public TypeIno st_ino;
		public TypeMode st_mode;
		public TypeNLink st_nlink;
		public TypeUid st_uid;
		public TypeGid st_gid;
		public TypeDev st_rdev;
		public short __pad0;
		public TypeOff st_size;
		public TypeBlkSize st_blksize;
		public TypeBlkCnt st_blocks;
		public StructTimespec.ByValue st_atime;
		public StructTimespec.ByValue st_mtime;
		public StructTimespec.ByValue st_ctime;

		@Override
		public final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		public void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		public final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		public final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		public final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		public final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		public final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		public final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		public final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		public final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		public final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		public final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		public final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		public final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		public final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		public final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		public final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static final class StatSetter
	{
		private final StructStat structStat;
		private final String path;

		StatSetter(final String path, final StructStat structStat)
		{
			this.path = path;
			this.structStat = structStat;
		}

		StatSetter(final StructStat structStat)
		{
			this(null, structStat);
		}

		public final StatSetter atime(final long sec)
		{
			return atime(sec, 0);
		}

		public final StatSetter atime(final long sec, final long nsec)
		{
			structStat.st_atime(sec, nsec);
			return this;
		}

		public final StatSetter blksize(final long blksize)
		{
			structStat.st_blksize(blksize);
			return this;
		}

		public final StatSetter blocks(final long blocks)
		{
			structStat.st_blocks(blocks);
			return this;
		}

		public final StatSetter ctime(final long sec)
		{
			return ctime(sec, 0);
		}

		public final StatSetter ctime(final long sec, final long nsec)
		{
			structStat.st_ctime(sec, nsec);
			return this;
		}

		public final StatSetter dev(final long dev)
		{
			structStat.st_dev(dev);
			return this;
		}

		public final StatSetter gen(final long gen)
		{
			structStat.st_gen(gen);
			return this;
		}

		public final StatSetter gid(final long gid)
		{
			structStat.st_gid(gid);
			return this;
		}

		public final StatSetter ino(final long ino)
		{
			structStat.st_ino(ino);
			return this;
		}

		public final StatSetter lspare(final long lspare)
		{
			structStat.st_lspare(lspare);
			return this;
		}

		public final StatSetter mode(final long mode)
		{
			structStat.st_mode(mode);
			return this;
		}

		public final StatSetter mtime(final long sec)
		{
			return mtime(sec, 0);
		}

		public final StatSetter mtime(final long sec, final long nsec)
		{
			structStat.st_atime(sec, nsec);
			return this;
		}

		public final StatSetter nlink(final long nlink)
		{
			structStat.st_nlink(nlink);
			return this;
		}

		public final StatSetter qspare(final long qspare)
		{
			structStat.st_qspare(qspare);
			return this;
		}

		public final StatSetter rdev(final long rdev)
		{
			structStat.st_rdev(rdev);
			return this;
		}

		public final StatSetter setAllTimes(final long sec, final long nsec)
		{
			return setTimes(sec, nsec, sec, nsec, sec, nsec);
		}

		public final StatSetter setAllTimesMillis(final long millis)
		{
			final long sec = millis / 1000L;
			final long nsec = (millis % 1000L) * 1000000L;
			return setAllTimes(sec, nsec);
		}

		public final StatSetter setAllTimesSec(final long sec)
		{
			return setAllTimesSec(sec, sec, sec);
		}

		public final StatSetter setAllTimesSec(final long atime, final long mtime, final long ctime)
		{
			return setAllTimesSec(atime, mtime, ctime, ctime);
		}

		public final StatSetter setAllTimesSec(final long atime, final long mtime, final long ctime, final long birthtime)
		{
			return setTimes(atime, 0, mtime, 0, ctime, 0);
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

		public final StatSetter setTimes(final long atime_sec, final long atime_nsec, final long mtime_sec,
				final long mtime_nsec, final long ctime_sec, final long ctime_nsec)
		{
			return setTimes(atime_sec, atime_nsec, mtime_sec, mtime_nsec, ctime_sec, ctime_nsec, ctime_sec, ctime_nsec);
		}

		public final StatSetter setTimes(final long atime_sec, final long atime_nsec, final long mtime_sec,
				final long mtime_nsec, final long ctime_sec, final long ctime_nsec, final long birthtime_sec,
				final long birthtime_nsec)
		{
			structStat.st_atime(atime_sec, atime_nsec);
			structStat.st_mtime(mtime_sec, atime_nsec);
			structStat.st_ctime(ctime_sec, atime_nsec);
			structStat.st_birthtime(birthtime_sec, birthtime_nsec);
			return this;
		}

		public final StatSetter size(final long size)
		{
			structStat.st_size(size);
			return this;
		}

		@Override
		public final String toString()
		{
			if (path != null) {
				return path + "\n" + structStat;
			}
			return structStat.toString();
		}

		public final StatSetter uid(final long uid)
		{
			structStat.st_uid(uid);
			return this;
		}
	}

	public static class x86_64 extends StructStat
	{
		public static final class ByReference extends x86_64 implements Structure.ByReference
		{
		}

		public static final class ByValue extends x86_64 implements Structure.ByValue
		{
		}

		public TypeDev st_dev;
		public TypeIno st_ino;
		public TypeNLink st_nlink;
		public TypeMode st_mode;
		public TypeUid st_uid;
		public TypeGid st_gid;
		public int __pad0;
		public TypeDev st_rdev;
		public TypeOff st_size;
		public TypeBlkSize st_blksize;
		public TypeBlkCnt st_blocks;
		public StructTimespec.ByValue st_atime;
		public StructTimespec.ByValue st_mtime;
		public StructTimespec.ByValue st_ctime;

		@Override
		public final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		public void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		public final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		public final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		public final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		public final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		public final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		public final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		public final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		public final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		public final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		public final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		public final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		public final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		public final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		public final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		public final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
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

	public abstract void st_atime(long sec, long nsec);

	public abstract void st_birthtime(long sec, long nsec);

	public abstract void st_blksize(long st_blksize);

	public abstract void st_blocks(long st_blocks);

	public abstract void st_ctime(long sec, long nsec);

	public abstract void st_dev(long st_dev);

	public abstract void st_gen(final long st_gen);

	public abstract void st_gid(long st_gid);

	public abstract void st_ino(long st_ino);

	public abstract void st_lspare(final long st_lspare);

	public abstract void st_mode(long st_mode);

	public abstract void st_mtime(long sec, long nsec);

	public abstract void st_nlink(long st_nlink);

	public abstract void st_qspare(final long st_qspare);

	public abstract void st_rdev(long st_rdev);

	public abstract void st_size(long st_size);

	public abstract void st_uid(long st_uid);
}
