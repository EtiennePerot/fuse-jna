package net.fusejna;

import java.util.Arrays;
import java.util.List;

import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeSize;
import net.fusejna.types.TypeUInt32;
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

	public static final List<String> FIELD_ORDER = Arrays
			.asList("getattr", "readlink", "getdir", "mknod", "mkdir", "unlink", "rmdir", "symlink", "rename", "link", "chmod",
					"chown", "truncate", "utime", "open", "read", "write", "statfs", "flush", "release", "fsync", "setxattr",
					"getxattr", "listxattr", "removexattr", "opendir", "readdir", "releasedir", "fsyncdir", "init", "destroy",
					"access", "create", "ftruncate", "fgetattr", "lock", "utimens", "bmap");
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
					public final int callback(final String path, final StructStat.X86_64.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.X86_64.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case LINUX_I686:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.I686.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.I686.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case LINUX_PPC:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.PowerPC.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.PowerPC.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
			case MAC:
				getattr = new Callback()
				{
					public final int callback(final String path, final StructStat.Mac.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.Mac.ByReference stat,
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
					public final int callback(final String path, final StructStat.BSD.ByReference stat)
					{
						return filesystem._getattr(path, stat);
					}
				};
				fgetattr = new Callback()
				{
					public final int callback(final String path, final StructStat.BSD.ByReference stat,
							final StructFuseFileInfo.ByReference info)
					{
						return filesystem._fgetattr(path, stat, info);
					}
				};
				break;
		}
		readlink = new Callback()
		{
			public final int callback(final String path, final Pointer buffer, final TypeSize size)
			{
				return filesystem._readlink(path, buffer, size);
			}
		};
		mknod = new Callback()
		{
			public final int callback(final String path, final TypeMode mode, final TypeDev dev)
			{
				return filesystem._mknod(path, mode, dev);
			}
		};
		mkdir = new Callback()
		{
			public final int callback(final String path, final TypeMode mode)
			{
				return filesystem._mkdir(path, mode);
			}
		};
		unlink = new Callback()
		{
			public final int callback(final String path)
			{
				return filesystem._unlink(path);
			}
		};
		rmdir = new Callback()
		{
			public final int callback(final String path)
			{
				return filesystem._rmdir(path);
			}
		};
		symlink = new Callback()
		{
			public final int callback(final String path, final String target)
			{
				return filesystem._symlink(path, target);
			}
		};
		rename = new Callback()
		{
			public final int callback(final String path, final String newName)
			{
				return filesystem._rename(path, newName);
			}
		};
		link = new Callback()
		{
			public final int callback(final String path, final String target)
			{
				return filesystem._link(path, target);
			}
		};
		chmod = new Callback()
		{
			public final int callback(final String path, final TypeMode mode)
			{
				return filesystem._chmod(path, mode);
			}
		};
		chown = new Callback()
		{
			public final int callback(final String path, final TypeUid uid, final TypeGid gid)
			{
				return filesystem._chown(path, uid, gid);
			}
		};
		truncate = new Callback()
		{
			public final int callback(final String path, final TypeOff offset)
			{
				return filesystem._truncate(path, offset);
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
			public final int callback(final String path, final Pointer buffer, final TypeSize size, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				return filesystem._write(path, buffer, size, offset, info);
			}
		};
		switch (Platform.platform()) {
			case FREEBSD:
				statfs = new Callback()
				{
					public final int callback(final String path, final StructStatvfs.FreeBSD.ByReference statsvfs)
					{
						return filesystem._statfs(path, statsvfs);
					}
				};
				break;
			default:
				statfs = new Callback()
				{
					public final int callback(final String path, final StructStatvfs.NotFreeBSD.ByReference statsvfs)
					{
						return filesystem._statfs(path, statsvfs);
					}
				};
				break;
		}
		flush = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._flush(path, info);
			}
		};
		release = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._release(path, info);
			}
		};
		fsync = new Callback()
		{
			public final int callback(final String path, final int datasync, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._fsync(path, datasync, info);
			}
		};
		switch (Platform.platform()) {
			case MAC:
			case MAC_MACFUSE:
				setxattr = new Callback()
				{
					public final int callback(final String path, final String xattr, final Pointer buffer, final TypeSize size,
							final int flags, final TypeUInt32 position)
					{
						return filesystem._setxattr(path, buffer, size, flags, position);
					}
				};
				getxattr = new Callback()
				{
					public final int callback(final String path, final String xattr, final Pointer buffer, final TypeSize size,
							final TypeUInt32 position)
					{
						return filesystem._getxattr(path, xattr, buffer, size, position);
					}
				};
				break;
			default:
				setxattr = new Callback()
				{
					public final int callback(final String path, final String xattr, final Pointer buffer, final TypeSize size,
							final int flags)
					{
						return filesystem._setxattr(path, buffer, size, flags, null);
					}
				};
				getxattr = new Callback()
				{
					public final int callback(final String path, final String xattr, final Pointer buffer, final TypeSize size)
					{
						return filesystem._getxattr(path, xattr, buffer, size, null);
					}
				};
		}
		listxattr = new Callback()
		{
			public final int callback(final String path, final Pointer buffer, final TypeSize size)
			{
				return filesystem._listxattr(path, buffer, size);
			}
		};
		removexattr = new Callback()
		{
			public final int callback(final String path, final String xattr)
			{
				return filesystem._removexattr(path, xattr);
			}
		};
		opendir = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._opendir(path, info);
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
				return filesystem._releasedir(path, info);
			}
		};
		fsyncdir = new Callback()
		{
			public final int callback(final String path, final int datasync, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._fsyncdir(path, datasync, info);
			}
		};
		init = new Callback()
		{
			public final Pointer callback(final StructFuseConnInfo.ByReference conn)
			{
				filesystem._init(conn);
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
				return filesystem._access(path, access);
			}
		};
		create = new Callback()
		{
			public final int callback(final String path, final TypeMode mode, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._create(path, mode, info);
			}
		};
		ftruncate = new Callback()
		{
			public final int callback(final String path, final TypeOff offset, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._ftruncate(path, offset, info);
			}
		};
		switch (Platform.platform()) {
			case FREEBSD:
			case MAC:
			case MAC_MACFUSE:
				lock = new Callback()
				{
					public final int callback(final String path, final StructFuseFileInfo.ByReference info, final int cmd,
							final StructFlock.FreeBSD.ByReference flock)
					{
						return filesystem._lock(path, info, cmd, flock);
					}
				};
				break;
			default:
				lock = new Callback()
				{
					public final int callback(final String path, final StructFuseFileInfo.ByReference info, final int cmd,
							final StructFlock.NotFreeBSD.ByReference flock)
					{
						return filesystem._lock(path, info, cmd, flock);
					}
				};
		}
		utimens = new Callback()
		{
			public final int callback(final String path, final StructTimeBuffer.ByReference timebuffer)
			{
				return filesystem._utimens(path, timebuffer);
			}
		};
		bmap = new Callback()
		{
			public final int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				return filesystem._bmap(path, info);
			}
		};
	}

	@Override
	protected List<String> getFieldOrder()
	{
		return FIELD_ORDER;
	}
}
