package net.fusejna;

import java.util.Arrays;
import java.util.List;

import net.fusejna.types.TypeBlkCnt;
import net.fusejna.types.TypeFsFilCnt;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

public abstract class StructStatvfs extends Structure
{
	public static class FreeBSD extends StructStatvfs
	{
		public static final class ByReference extends FreeBSD implements Structure.ByReference
		{
		}

		public static final class ByValue extends FreeBSD implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("f_bavail", "f_bfree", "f_blocks", "f_ffree", "f_favail",
				"f_files", "f_bsize", "__pad0", "f_frsize");
		public TypeBlkCnt f_bavail;
		public TypeBlkCnt f_bfree;
		public TypeBlkCnt f_blocks;
		public TypeFsFilCnt f_ffree;
		public TypeFsFilCnt f_favail;
		public TypeFsFilCnt f_files;
		public NativeLong f_bsize;
		public NativeLong __pad0;
		public NativeLong f_frsize;

		@Override
		final long f_bavail()
		{
			return f_bavail.longValue();
		}

		@Override
		final void f_bavail(final long f_bavail)
		{
			this.f_bavail.setValue(f_bavail);
		}

		@Override
		final long f_bfree()
		{
			return f_bfree.longValue();
		}

		@Override
		final void f_bfree(final long f_bfree)
		{
			this.f_bfree.setValue(f_bfree);
		}

		@Override
		final long f_blocks()
		{
			return f_blocks.longValue();
		}

		@Override
		final void f_blocks(final long f_blocks)
		{
			this.f_blocks.setValue(f_blocks);
		}

		@Override
		final long f_bsize()
		{
			return f_bsize.longValue();
		}

		@Override
		final void f_bsize(final long f_bsize)
		{
			this.f_bsize.setValue(f_bsize);
		}

		@Override
		final long f_favail()
		{
			return f_favail.longValue();
		}

		@Override
		final void f_favail(final long f_favail)
		{
			this.f_favail.setValue(f_favail);
		}

		@Override
		final long f_ffree()
		{
			return f_ffree.longValue();
		}

		@Override
		final void f_ffree(final long f_ffree)
		{
			this.f_ffree.setValue(f_ffree);
		}

		@Override
		final long f_files()
		{
			return f_files.longValue();
		}

		@Override
		final void f_files(final long f_files)
		{
			this.f_files.setValue(f_files);
		}

		@Override
		final long f_frsize()
		{
			return f_frsize.longValue();
		}

		@Override
		final void f_frsize(final long f_frsize)
		{
			this.f_frsize.setValue(f_frsize);
		}

		@Override
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}
	}

	public static class NotFreeBSD extends StructStatvfs
	{
		public static final class ByReference extends NotFreeBSD implements Structure.ByReference
		{
		}

		public static final class ByValue extends NotFreeBSD implements Structure.ByValue
		{
		}

		public static final List<String> FIELD_ORDER = Arrays.asList("f_bsize", "f_frsize", "f_blocks", "f_bfree", "f_bavail",
				"f_files", "f_ffree", "f_favail");
		public NativeLong f_bsize;
		public NativeLong f_frsize;
		public TypeBlkCnt f_blocks;
		public TypeBlkCnt f_bfree;
		public TypeBlkCnt f_bavail;
		public TypeFsFilCnt f_files;
		public TypeFsFilCnt f_ffree;
		public TypeFsFilCnt f_favail;

		@Override
		final long f_bavail()
		{
			return f_bavail.longValue();
		}

		@Override
		final void f_bavail(final long f_bavail)
		{
			this.f_bavail.setValue(f_bavail);
		}

		@Override
		final long f_bfree()
		{
			return f_bfree.longValue();
		}

		@Override
		final void f_bfree(final long f_bfree)
		{
			this.f_bfree.setValue(f_bfree);
		}

		@Override
		final long f_blocks()
		{
			return f_blocks.longValue();
		}

		@Override
		final void f_blocks(final long f_blocks)
		{
			this.f_blocks.setValue(f_blocks);
		}

		@Override
		final long f_bsize()
		{
			return f_bsize.longValue();
		}

		@Override
		final void f_bsize(final long f_bsize)
		{
			this.f_bsize.setValue(f_bsize);
		}

		@Override
		final long f_favail()
		{
			return f_favail.longValue();
		}

		@Override
		final void f_favail(final long f_favail)
		{
			this.f_favail.setValue(f_favail);
		}

		@Override
		final long f_ffree()
		{
			return f_ffree.longValue();
		}

		@Override
		final void f_ffree(final long f_ffree)
		{
			this.f_ffree.setValue(f_ffree);
		}

		@Override
		final long f_files()
		{
			return f_files.longValue();
		}

		@Override
		final void f_files(final long f_files)
		{
			this.f_files.setValue(f_files);
		}

		@Override
		final long f_frsize()
		{
			return f_frsize.longValue();
		}

		@Override
		final void f_frsize(final long f_frsize)
		{
			this.f_frsize.setValue(f_frsize);
		}

		@Override
		protected List<String> getFieldOrder()
		{
			return FIELD_ORDER;
		}
	}

	public static final class StatvfsWrapper
	{
		private final StructStatvfs structStatvfs;
		private final String path;

		StatvfsWrapper(final String path, final StructStatvfs structStatvfs)
		{
			this.path = path;
			this.structStatvfs = structStatvfs;
		}

		StatvfsWrapper(final StructStatvfs structStatvfs)
		{
			this(null, structStatvfs);
		}

		public final long bavail()
		{
			return structStatvfs.f_bavail();
		}

		public final StatvfsWrapper bavail(final long f_bavail)
		{
			structStatvfs.f_bavail(f_bavail);
			return this;
		}

		public final long bfree()
		{
			return structStatvfs.f_bfree();
		}

		public final StatvfsWrapper bfree(final long f_bfree)
		{
			structStatvfs.f_bfree(f_bfree);
			return this;
		}

		public final long blocks()
		{
			return structStatvfs.f_blocks();
		}

		public final StatvfsWrapper blocks(final long f_blocks)
		{
			structStatvfs.f_blocks(f_blocks);
			return this;
		}

		public final long bsize()
		{
			return structStatvfs.f_bsize();
		}

		public final StatvfsWrapper bsize(final long f_bsize)
		{
			structStatvfs.f_bsize(f_bsize);
			return this;
		}

		public final long favail()
		{
			return structStatvfs.f_favail();
		}

		public final StatvfsWrapper favail(final long f_favail)
		{
			structStatvfs.f_favail(f_favail);
			return this;
		}

		public final long ffree()
		{
			return structStatvfs.f_ffree();
		}

		public final StatvfsWrapper ffree(final long f_ffree)
		{
			structStatvfs.f_ffree(f_ffree);
			return this;
		}

		public final long files()
		{
			return structStatvfs.f_files();
		}

		public final StatvfsWrapper files(final long f_files)
		{
			structStatvfs.f_files(f_files);
			return this;
		}

		public final long frsize()
		{
			return structStatvfs.f_frsize();
		}

		public final StatvfsWrapper frsize(final long f_frsize)
		{
			structStatvfs.f_frsize(f_frsize);
			return this;
		}

		public final StatvfsWrapper set(final long blockSize, final long fragmentSize, final long freeBlocks,
				final long availBlocks, final long totalBlocks, final long freeFiles, final long availFiles,
				final long totalFiles)
		{
			return setSizes(blockSize, fragmentSize).setBlockInfo(freeBlocks, availBlocks, totalBlocks).setFileInfo(freeFiles,
					availFiles, totalFiles);
		}

		public final StatvfsWrapper setBlockInfo(final long freeBlocks, final long availBlocks, final long totalBlocks)
		{
			return bfree(freeBlocks).bavail(availBlocks).blocks(totalBlocks);
		}

		public final StatvfsWrapper setFileInfo(final long freeFiles, final long availFiles, final long totalFiles)
		{
			return ffree(freeFiles).favail(availFiles).files(totalFiles);
		}

		public final StatvfsWrapper setSizes(final long blockSize, final long fragmentSize)
		{
			return bsize(blockSize).frsize(fragmentSize);
		}

		@Override
		public final String toString()
		{
			if (path != null) {
				return path + "\n" + structStatvfs;
			}
			return structStatvfs.toString();
		}

		final void write()
		{
			structStatvfs.write();
		}
	}

	abstract long f_bavail();

	abstract void f_bavail(long f_bavail);

	abstract long f_bfree();

	abstract void f_bfree(long f_bfree);

	abstract long f_blocks();

	abstract void f_blocks(long f_blocks);

	abstract long f_bsize();

	abstract void f_bsize(long f_bsize);

	abstract long f_favail();

	abstract void f_favail(long f_favail);

	abstract long f_ffree();

	abstract void f_ffree(long f_ffree);

	abstract long f_files();

	abstract void f_files(long f_files);

	abstract long f_frsize();

	abstract void f_frsize(long f_frsize);
}
