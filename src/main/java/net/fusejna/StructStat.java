package net.fusejna;

import java.util.Arrays;
import java.util.List;

import net.fusejna.types.TypeBlkCnt;
import net.fusejna.types.TypeBlkSize;
import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGen;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeIno;
import net.fusejna.types.TypeLspare;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeMode.IModeWrapper;
import net.fusejna.types.TypeMode.ModeWrapper;
import net.fusejna.types.TypeMode.NodeType;
import net.fusejna.types.TypeNLink;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeQspare;
import net.fusejna.types.TypeUInt32;
import net.fusejna.types.TypeUid;

import com.sun.jna.Structure;

public abstract class StructStat extends Structure
{
	public static class BSD extends StructStat
	{
		public static final class ByReference extends BSD implements Structure.ByReference
		{
		}

		public static final class ByValue extends BSD implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("st_dev", "st_ino", "st_mode", "st_nlink", "st_uid",
				"st_gid", "st_rdev", "st_atime", "st_mtime", "st_ctime", "st_size", "st_blocks", "st_blksize");
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
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		final long st_atime_nsec()
		{
			return st_atime.nsec();
		}

		@Override
		final long st_atime_sec()
		{
			return st_atime.sec();
		}

		@Override
		final void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		final long st_birthtime_nsec()
		{
			return -1L;
		}

		@Override
		final long st_birthtime_sec()
		{
			return -1L;
		}

		@Override
		final long st_blksize()
		{
			return st_blksize.longValue();
		}

		@Override
		final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		final long st_blocks()
		{
			return st_blocks.longValue();
		}

		@Override
		final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		final long st_ctime_nsec()
		{
			return st_ctime.nsec();
		}

		@Override
		final long st_ctime_sec()
		{
			return st_ctime.sec();
		}

		@Override
		final long st_dev()
		{
			return st_dev.longValue();
		}

		@Override
		final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		final long st_gen()
		{
			return -1L;
		}

		@Override
		final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		final long st_gid()
		{
			return st_gid.longValue();
		}

		@Override
		final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		final long st_ino()
		{
			return st_ino.longValue();
		}

		@Override
		final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		final long st_lspare()
		{
			return -1L;
		}

		@Override
		final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		final long st_mode()
		{
			return st_mode.longValue();
		}

		@Override
		final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		final long st_mtime_nsec()
		{
			return st_mtime.nsec();
		}

		@Override
		final long st_mtime_sec()
		{
			return st_mtime.sec();
		}

		@Override
		final long st_nlink()
		{
			return st_nlink.longValue();
		}

		@Override
		final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		final long st_qspare()
		{
			return -1L;
		}

		@Override
		final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		final long st_rdev()
		{
			return st_rdev.longValue();
		}

		@Override
		final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		final long st_size()
		{
			return st_size.longValue();
		}

		@Override
		final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		final long st_uid()
		{
			return st_uid.longValue();
		}

		@Override
		final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static class I686 extends StructStat
	{
		public static final class ByReference extends I686 implements Structure.ByReference
		{
		}

		public static final class ByValue extends I686 implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("st_dev", "__pad1", "__st_ino", "st_mode", "st_nlink",
				"st_uid", "st_gid", "st_rdev", "__pad2", "st_size", "st_blksize", "st_blocks", "st_atime", "st_mtime",
				"st_ctime", "st_ino");
		public TypeDev st_dev;
		public short __pad1;
		public TypeUInt32 __st_ino;
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
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		final long st_atime_nsec()
		{
			return st_atime.nsec();
		}

		@Override
		final long st_atime_sec()
		{
			return st_atime.sec();
		}

		@Override
		final void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		final long st_birthtime_nsec()
		{
			return -1L;
		}

		@Override
		final long st_birthtime_sec()
		{
			return -1L;
		}

		@Override
		final long st_blksize()
		{
			return st_blksize.longValue();
		}

		@Override
		final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		final long st_blocks()
		{
			return st_blocks.longValue();
		}

		@Override
		final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		final long st_ctime_nsec()
		{
			return st_ctime.nsec();
		}

		@Override
		final long st_ctime_sec()
		{
			return st_ctime.sec();
		}

		@Override
		final long st_dev()
		{
			return st_dev.longValue();
		}

		@Override
		final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		final long st_gen()
		{
			return -1L;
		}

		@Override
		final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		final long st_gid()
		{
			return st_gid.longValue();
		}

		@Override
		final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		final long st_ino()
		{
			return st_ino.longValue();
		}

		@Override
		final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		final long st_lspare()
		{
			return -1L;
		}

		@Override
		final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		final long st_mode()
		{
			return st_mode.longValue();
		}

		@Override
		final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		final long st_mtime_nsec()
		{
			return st_mtime.nsec();
		}

		@Override
		final long st_mtime_sec()
		{
			return st_mtime.sec();
		}

		@Override
		final long st_nlink()
		{
			return st_nlink.longValue();
		}

		@Override
		final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		final long st_qspare()
		{
			return -1L;
		}

		@Override
		final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		final long st_rdev()
		{
			return st_rdev.longValue();
		}

		@Override
		final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		final long st_size()
		{
			return st_size.longValue();
		}

		@Override
		final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		final long st_uid()
		{
			return st_uid.longValue();
		}

		@Override
		final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static class Mac extends StructStat
	{
		public static final class ByReference extends Mac implements Structure.ByReference
		{
		}

		public static final class ByValue extends Mac implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("st_dev", "st_mode", "st_nlink", "st_ino", "st_uid",
				"st_gid", "st_rdev", "st_atime", "st_mtime", "st_ctime", "st_birthtime", "st_size", "st_blocks", "st_blksize",
				"st_gen", "st_lspare", "st_qspare");
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
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		final long st_atime_nsec()
		{
			return st_atime.nsec();
		}

		@Override
		final long st_atime_sec()
		{
			return st_atime.sec();
		}

		@Override
		final void st_birthtime(final long sec, final long nsec)
		{
			st_birthtime.set(sec, nsec);
		}

		@Override
		final long st_birthtime_nsec()
		{
			return st_birthtime.nsec();
		}

		@Override
		final long st_birthtime_sec()
		{
			return st_birthtime.sec();
		}

		@Override
		final long st_blksize()
		{
			return st_blksize.longValue();
		}

		@Override
		final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		final long st_blocks()
		{
			return st_blocks.longValue();
		}

		@Override
		final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		final long st_ctime_nsec()
		{
			return st_ctime.nsec();
		}

		@Override
		final long st_ctime_sec()
		{
			return st_ctime.sec();
		}

		@Override
		final long st_dev()
		{
			return st_dev.longValue();
		}

		@Override
		final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		final long st_gen()
		{
			return st_gen.longValue();
		}

		@Override
		final void st_gen(final long st_gen)
		{
			this.st_gen.setValue(st_gen);
		}

		@Override
		final long st_gid()
		{
			return st_gid.longValue();
		}

		@Override
		final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		final long st_ino()
		{
			return st_ino.longValue();
		}

		@Override
		final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		final long st_lspare()
		{
			return st_lspare.longValue();
		}

		@Override
		final void st_lspare(final long st_lspare)
		{
			this.st_lspare.setValue(st_lspare);
		}

		@Override
		final long st_mode()
		{
			return st_mode.longValue();
		}

		@Override
		final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		final long st_mtime_nsec()
		{
			return st_mtime.nsec();
		}

		@Override
		final long st_mtime_sec()
		{
			return st_mtime.sec();
		}

		@Override
		final long st_nlink()
		{
			return st_nlink.longValue();
		}

		@Override
		final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		final long st_qspare()
		{
			return st_qspare.longValue();
		}

		@Override
		final void st_qspare(final long st_qspare)
		{
			this.st_qspare.setValue(st_qspare);
		}

		@Override
		final long st_rdev()
		{
			return st_rdev.longValue();
		}

		@Override
		final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		final long st_size()
		{
			return st_size.longValue();
		}

		@Override
		final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		final long st_uid()
		{
			return st_uid.longValue();
		}

		@Override
		final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static class PowerPC extends StructStat
	{
		public static final class ByReference extends PowerPC implements Structure.ByReference
		{
		}

		public static final class ByValue extends PowerPC implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("st_dev", "st_ino", "st_mode", "st_nlink", "st_uid",
				"st_gid", "st_rdev", "__pad0", "st_size", "st_blksize", "st_blocks", "st_atime", "st_mtime", "st_ctime");
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
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		final long st_atime_nsec()
		{
			return st_atime.nsec();
		}

		@Override
		final long st_atime_sec()
		{
			return st_atime.sec();
		}

		@Override
		final void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		final long st_birthtime_nsec()
		{
			return -1L;
		}

		@Override
		final long st_birthtime_sec()
		{
			return -1L;
		}

		@Override
		final long st_blksize()
		{
			return st_blksize.longValue();
		}

		@Override
		final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		final long st_blocks()
		{
			return st_blocks.longValue();
		}

		@Override
		final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		final long st_ctime_nsec()
		{
			return st_ctime.nsec();
		}

		@Override
		final long st_ctime_sec()
		{
			return st_ctime.sec();
		}

		@Override
		final long st_dev()
		{
			return st_dev.longValue();
		}

		@Override
		final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		final long st_gen()
		{
			return -1L;
		}

		@Override
		final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		final long st_gid()
		{
			return st_gid.longValue();
		}

		@Override
		final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		final long st_ino()
		{
			return st_ino.longValue();
		}

		@Override
		final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		final long st_lspare()
		{
			return -1L;
		}

		@Override
		final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		final long st_mode()
		{
			return st_mode.longValue();
		}

		@Override
		final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		final long st_mtime_nsec()
		{
			return st_mtime.nsec();
		}

		@Override
		final long st_mtime_sec()
		{
			return st_mtime.sec();
		}

		@Override
		final long st_nlink()
		{
			return st_nlink.longValue();
		}

		@Override
		final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		final long st_qspare()
		{
			return -1L;
		}

		@Override
		final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		final long st_rdev()
		{
			return st_rdev.longValue();
		}

		@Override
		final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		final long st_size()
		{
			return st_size.longValue();
		}

		@Override
		final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		final long st_uid()
		{
			return st_uid.longValue();
		}

		@Override
		final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	public static final class StatWrapper implements IModeWrapper
	{
		private final StructStat structStat;
		private final String path;
		private final ModeWrapper modeWrapper;

		StatWrapper(final String path, final StructStat structStat)
		{
			this.path = path;
			this.structStat = structStat;
			modeWrapper = new ModeWrapper(structStat.st_mode());
		}

		StatWrapper(final StructStat structStat)
		{
			this(null, structStat);
		}

		public final StatWrapper atime(final long sec)
		{
			return atime(sec, 0);
		}

		public final StatWrapper atime(final long sec, final long nsec)
		{
			structStat.st_atime(sec, nsec);
			return this;
		}

		public final StatWrapper blksize(final long blksize)
		{
			structStat.st_blksize(blksize);
			return this;
		}

		public final StatWrapper blocks(final long blocks)
		{
			structStat.st_blocks(blocks);
			return this;
		}

		public final StatWrapper ctime(final long sec)
		{
			return ctime(sec, 0);
		}

		public final StatWrapper ctime(final long sec, final long nsec)
		{
			structStat.st_ctime(sec, nsec);
			return this;
		}

		public final StatWrapper dev(final long dev)
		{
			structStat.st_dev(dev);
			return this;
		}

		public final StatWrapper gen(final long gen)
		{
			structStat.st_gen(gen);
			return this;
		}

		public final StatWrapper gid(final long gid)
		{
			structStat.st_gid(gid);
			return this;
		}

		public final StatWrapper ino(final long ino)
		{
			structStat.st_ino(ino);
			return this;
		}

		public final StatWrapper lspare(final long lspare)
		{
			structStat.st_lspare(lspare);
			return this;
		}

		@Override
		public long mode()
		{
			return modeWrapper.mode();
		}

		@Override
		public StatWrapper mode(final long bits)
		{
			modeWrapper.mode(bits);
			return this;
		}

		public final StatWrapper mtime(final long sec)
		{
			return mtime(sec, 0);
		}

		public final StatWrapper mtime(final long sec, final long nsec)
		{
			structStat.st_mtime(sec, nsec);
			return this;
		}

		public final StatWrapper nlink(final long nlink)
		{
			structStat.st_nlink(nlink);
			return this;
		}

		public final StatWrapper qspare(final long qspare)
		{
			structStat.st_qspare(qspare);
			return this;
		}

		public final StatWrapper rdev(final long rdev)
		{
			structStat.st_rdev(rdev);
			return this;
		}

		public final StatWrapper setAllTimes(final long sec, final long nsec)
		{
			return setTimes(sec, nsec, sec, nsec, sec, nsec);
		}

		public final StatWrapper setAllTimesMillis(final long millis)
		{
			final long sec = millis / 1000L;
			final long nsec = (millis % 1000L) * 1000000L;
			return setAllTimes(sec, nsec);
		}

		public final StatWrapper setAllTimesSec(final long sec)
		{
			return setAllTimesSec(sec, sec, sec);
		}

		public final StatWrapper setAllTimesSec(final long atime, final long mtime, final long ctime)
		{
			return setAllTimesSec(atime, mtime, ctime, ctime);
		}

		public final StatWrapper setAllTimesSec(final long atime, final long mtime, final long ctime, final long birthtime)
		{
			return setTimes(atime, 0, mtime, 0, ctime, 0);
		}

		@Override
		public StatWrapper setMode(final NodeType type)
		{
			modeWrapper.setMode(type);
			return this;
		}

		@Override
		public StatWrapper setMode(final NodeType type, final boolean readable, final boolean writable, final boolean executable)
		{
			modeWrapper.setMode(type, readable, writable, executable);
			return this;
		}

		@Override
		public StatWrapper setMode(final NodeType type, final boolean ownerReadable, final boolean ownerWritable,
				final boolean ownerExecutable, final boolean groupReadable, final boolean groupWritable,
				final boolean groupExecutable, final boolean otherReadable, final boolean otherWritable,
				final boolean otherExecutable)
		{
			modeWrapper.setMode(type, ownerReadable, ownerWritable, ownerExecutable, groupReadable, groupWritable,
					groupExecutable, otherReadable, otherWritable, otherExecutable);
			return this;
		}

		public final StatWrapper setTimes(final long atime_sec, final long atime_nsec, final long mtime_sec,
				final long mtime_nsec, final long ctime_sec, final long ctime_nsec)
		{
			return setTimes(atime_sec, atime_nsec, mtime_sec, mtime_nsec, ctime_sec, ctime_nsec, ctime_sec, ctime_nsec);
		}

		public final StatWrapper setTimes(final long atime_sec, final long atime_nsec, final long mtime_sec,
				final long mtime_nsec, final long ctime_sec, final long ctime_nsec, final long birthtime_sec,
				final long birthtime_nsec)
		{
			structStat.st_atime(atime_sec, atime_nsec);
			structStat.st_mtime(mtime_sec, mtime_nsec);
			structStat.st_ctime(ctime_sec, ctime_nsec);
			structStat.st_birthtime(birthtime_sec, birthtime_nsec);
			return this;
		}

		public final StatWrapper size(final long size)
		{
			structStat.st_size(size);
			return this;
		}

		@Override
		public final String toString()
		{
			// Sync mode wrapper with struct before printing it
			structStat.st_mode(modeWrapper.mode());
			if (path != null) {
				return path + "\n" + structStat;
			}
			return structStat.toString();
		}

		@Override
		public NodeType type()
		{
			return modeWrapper.type();
		}

		public final StatWrapper uid(final long uid)
		{
			structStat.st_uid(uid);
			return this;
		}

		final void write()
		{
			structStat.st_mode(modeWrapper.mode());
			structStat.write();
		}
	}

	public static class X86_64 extends StructStat
	{
		public static final class ByReference extends X86_64 implements Structure.ByReference
		{
		}

		public static final class ByValue extends X86_64 implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("st_dev", "st_ino", "st_nlink", "st_mode", "st_uid",
				"st_gid", "__pad0", "st_rdev", "st_size", "st_blksize", "st_blocks", "st_atime", "st_mtime", "st_ctime");
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
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}

		@Override
		final void st_atime(final long sec, final long nsec)
		{
			st_atime.set(sec, nsec);
		}

		@Override
		final long st_atime_nsec()
		{
			return st_atime.nsec();
		}

		@Override
		final long st_atime_sec()
		{
			return st_atime.sec();
		}

		@Override
		final void st_birthtime(final long sec, final long nsec)
		{
			// Not implemented
		}

		@Override
		final long st_birthtime_nsec()
		{
			return -1L;
		}

		@Override
		final long st_birthtime_sec()
		{
			return -1L;
		}

		@Override
		final long st_blksize()
		{
			return st_blksize.longValue();
		}

		@Override
		final void st_blksize(final long st_blksize)
		{
			this.st_blksize.setValue(st_blksize);
		}

		@Override
		final long st_blocks()
		{
			return st_blocks.longValue();
		}

		@Override
		final void st_blocks(final long st_blocks)
		{
			this.st_blocks.setValue(st_blocks);
		}

		@Override
		final void st_ctime(final long sec, final long nsec)
		{
			st_ctime.set(sec, nsec);
		}

		@Override
		final long st_ctime_nsec()
		{
			return st_ctime.nsec();
		}

		@Override
		final long st_ctime_sec()
		{
			return st_ctime.sec();
		}

		@Override
		final long st_dev()
		{
			return st_dev.longValue();
		}

		@Override
		final void st_dev(final long st_dev)
		{
			this.st_dev.setValue(st_dev);
		}

		@Override
		final long st_gen()
		{
			return -1L;
		}

		@Override
		final void st_gen(final long st_gen)
		{
			// Not implemented
		}

		@Override
		final long st_gid()
		{
			return st_gid.longValue();
		}

		@Override
		final void st_gid(final long st_gid)
		{
			this.st_gid.setValue(st_gid);
		}

		@Override
		final long st_ino()
		{
			return st_ino.longValue();
		}

		@Override
		final void st_ino(final long st_ino)
		{
			this.st_ino.setValue(st_ino);
		}

		@Override
		final long st_lspare()
		{
			return -1L;
		}

		@Override
		final void st_lspare(final long st_lspare)
		{
			// Not implemented
		}

		@Override
		final long st_mode()
		{
			return st_mode.longValue();
		}

		@Override
		final void st_mode(final long st_mode)
		{
			this.st_mode.setValue(st_mode);
		}

		@Override
		final void st_mtime(final long sec, final long nsec)
		{
			st_mtime.set(sec, nsec);
		}

		@Override
		final long st_mtime_nsec()
		{
			return st_mtime.nsec();
		}

		@Override
		final long st_mtime_sec()
		{
			return st_mtime.sec();
		}

		@Override
		final long st_nlink()
		{
			return st_nlink.longValue();
		}

		@Override
		final void st_nlink(final long st_nlink)
		{
			this.st_nlink.setValue(st_nlink);
		}

		@Override
		final long st_qspare()
		{
			return -1L;
		}

		@Override
		final void st_qspare(final long st_qspare)
		{
			// Not implemented
		}

		@Override
		final long st_rdev()
		{
			return st_rdev.longValue();
		}

		@Override
		final void st_rdev(final long st_rdev)
		{
			this.st_rdev.setValue(st_rdev);
		}

		@Override
		final long st_size()
		{
			return st_size.longValue();
		}

		@Override
		final void st_size(final long st_size)
		{
			this.st_size.setValue(st_size);
		}

		@Override
		final long st_uid()
		{
			return st_uid.longValue();
		}

		@Override
		final void st_uid(final long st_uid)
		{
			this.st_uid.setValue(st_uid);
		}
	}

	abstract void st_atime(long sec, long nsec);

	abstract long st_atime_nsec();

	abstract long st_atime_sec();

	abstract void st_birthtime(long sec, long nsec);

	abstract long st_birthtime_nsec();

	abstract long st_birthtime_sec();

	abstract long st_blksize();

	abstract void st_blksize(long st_blksize);

	abstract long st_blocks();

	abstract void st_blocks(long st_blocks);

	abstract void st_ctime(long sec, long nsec);

	abstract long st_ctime_nsec();

	abstract long st_ctime_sec();

	abstract long st_dev();

	abstract void st_dev(long st_dev);

	abstract long st_gen();

	abstract void st_gen(final long st_gen);

	abstract long st_gid();

	abstract void st_gid(long st_gid);

	abstract long st_ino();

	abstract void st_ino(long st_ino);

	abstract long st_lspare();

	abstract void st_lspare(final long st_lspare);

	abstract long st_mode();

	abstract void st_mode(long st_mode);

	abstract void st_mtime(long sec, long nsec);

	abstract long st_mtime_nsec();

	abstract long st_mtime_sec();

	abstract long st_nlink();

	abstract void st_nlink(long st_nlink);

	abstract long st_qspare();

	abstract void st_qspare(final long st_qspare);

	abstract long st_rdev();

	abstract void st_rdev(long st_rdev);

	abstract long st_size();

	abstract void st_size(long st_size);

	abstract long st_uid();

	abstract void st_uid(long st_uid);
}
