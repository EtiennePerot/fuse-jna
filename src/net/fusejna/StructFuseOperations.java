package net.fusejna;

import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeSize;
import net.fusejna.types.TypeUid;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class StructFuseOperations extends Structure
{
	public static final class ByReference extends StructFuseOperations implements Structure.ByReference
	{
		public ByReference(final FuseFilesystem filesystem)
		{
			super(filesystem);
		}
	}

	public static final class ByValue extends StructFuseOperations implements Structure.ByValue
	{
		public ByValue(final FuseFilesystem filesystem)
		{
			super(filesystem);
		}
	}

	public Callback getattr;
	public Callback readlink;
	public Pointer getdir = null;
	public Callback mknod;
	public Callback mkdir;
	public Callback unlink;
	public Callback rmdir;
	public Callback symlink;
	public Callback rename;
	public Callback link;
	public Callback chmod;
	public Callback chown;
	public Callback truncate;
	public Pointer utime = null;
	public Callback open;
	public Callback read;
	public Callback write;
	public Callback statfs;
	public Callback flush;
	public Callback release;
	public Callback fsync;
	public Callback setxattr;
	public Callback getxattr;
	public Callback listxattr;
	public Callback removexattr;
	public Callback opendir;
	public Callback readdir;
	public Callback releasedir;
	public Callback fsyncdir;
	public Callback init;
	public Callback destroy;
	public Callback access;
	public Callback create;
	public Callback ftruncate;
	public Callback fgetattr;
	public Callback lock;
	public Callback utimens;
	public Callback bmap;

	@SuppressWarnings("unused")
	public StructFuseOperations(final FuseFilesystem filesystem)
	{
		switch (Platform.platform()) {
			case LINUX_X86_64:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.x86_64.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.x86_64.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case LINUX_I686:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.i686.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.i686.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case LINUX_PPC:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.ppc.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.ppc.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case MAC:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.mac.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.mac.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case FREEBSD:
			case MAC_MACFUSE:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.bsd.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.bsd.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
		}
		readlink = new Callback()
		{
			public final int callback(final String path, final String target, final TypeSize size)
			{
				System.out.println("readlink");
				return 0;
			}
		};
		mknod = new Callback()
		{
			public final int callback(final String path, final TypeMode mode, final TypeDev dev)
			{
				System.out.println("mknod");
				return 0;
			}
		};
		mkdir = new Callback()
		{
			public final int callback(final String path, final TypeMode mode)
			{
				System.out.println("mkdir");
				return 0;
			}
		};
		unlink = new Callback()
		{
			public final int callback(final String path)
			{
				System.out.println("unlink");
				return 0;
			}
		};
		rmdir = new Callback()
		{
			public final int callback(final String path)
			{
				System.out.println("rmdir");
				return 0;
			}
		};
		symlink = new Callback()
		{
			public final int callback(final String path, final String target)
			{
				System.out.println("symlink");
				return 0;
			}
		};
		rename = new Callback()
		{
			public final int callback(final String path, final String newName)
			{
				System.out.println("rename");
				return 0;
			}
		};
		link = new Callback()
		{
			public final int callback(final String path, final String target)
			{
				System.out.println("link");
				return 0;
			}
		};
		chmod = new Callback()
		{
			public final int callback(final String path, final TypeMode mode)
			{
				System.out.println("chmod");
				return 0;
			}
		};
		chown = new Callback()
		{
			public final int callback(final String path, final TypeUid uid, final TypeGid gid)
			{
				System.out.println("chown");
				return 0;
			}
		};
		truncate = new Callback()
		{
			public final int callback(final String path, final TypeOff offset)
			{
				System.out.println("truncate");
				return 0;
			}
		};
		open = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._open(path, info);
			}
		};
		read = new Callback()
		{
			public final int callback(final String path, final Pointer buffer, final TypeSize size, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				return filesystem._read(path, buffer, size, offset, info);
			}
		};
		write = new Callback()
		{
			public final int callback(final String path, final String buffer, final TypeSize size, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				System.out.println("write");
				return 0;
			}
		};
		statfs = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference statsvfs)
			{
				System.out.println("statfs");
				return 0;
			}
		};
		flush = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("flush");
				return 0;
			}
		};
		release = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("release");
				return 0;
			}
		};
		fsync = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("fsync");
				return 0;
			}
		};
		setxattr = new Callback()
		{
			public final int callback(final String path, final String xattr, final String value, final TypeSize size,
					final int flags)
			{ // xattr stuff has extra stuff on OS X
				System.out.println("setxattr");
				return 0;
			}
		};
		getxattr = new Callback()
		{
			public final int callback(final String path, final String xattr, final Pointer target, final TypeSize size)
			{
				System.out.println("getxattr");
				return 0;
			}
		};
		listxattr = new Callback()
		{
			public final int callback(final String path, final Pointer target, final TypeSize size)
			{
				System.out.println("listxattr");
				return 0;
			}
		};
		removexattr = new Callback()
		{
			public final int callback(final String path, final String xattr)
			{
				System.out.println("removexattr");
				return 0;
			}
		};
		opendir = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("opendir");
				return 0;
			}
		};
		readdir = new Callback()
		{
			public final int callback(final String path, final Pointer buf, final Pointer fillFunction, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				return filesystem._readdir(path, buf, fillFunction, offset, info);
			}
		};
		releasedir = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("releasedir");
				return 0;
			}
		};
		fsyncdir = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("fsyncdir");
				return 0;
			}
		};
		init = new Callback()
		{
			public final Pointer callback(final StructFuseConnInfo.ByReference conn)
			{
				filesystem._init();
				return null;
			}
		};
		destroy = new Callback()
		{
			public final void callback(final Pointer user_data)
			{
				filesystem._destroy();
			}
		};
		access = new Callback()
		{
			public final int callback(final String path, final int access)
			{
				System.out.println("access");
				return 0;
			}
		};
		create = new Callback()
		{
			public final int callback(final String path, final TypeMode mode, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("create");
				return 0;
			}
		};
		ftruncate = new Callback()
		{
			public final int callback(final String path, final TypeOff offset, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("ftruncate");
				return 0;
			}
		};
		lock = new Callback()
		{
			public final int callback(final String path, final Pointer info, final int cmd, final Pointer flock)
			{
				System.out.println("lock");
				return 0;
			}
		};
		utimens = new Callback()
		{
			public final int callback(final String path, final Pointer timespec)
			{ // Has two timespecs
				System.out.println("utimens");
				return 0;
			}
		};
		bmap = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("bmap");
				return 0;
			}
		};
	}
}
