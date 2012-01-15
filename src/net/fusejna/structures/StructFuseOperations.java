package net.fusejna.structures;

import net.fusejna.FuseFilesystem;
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
	public static class ByReference extends StructFuseOperations implements Structure.ByReference
	{
		public ByReference(final FuseFilesystem filesystem)
		{
			super(filesystem);
		}
	}

	public static class ByValue extends StructFuseOperations implements Structure.ByValue
	{
		public ByValue(final FuseFilesystem filesystem)
		{
			super(filesystem);
		}
	}

	public Callback getattr = null;
	public Callback readlink = null;
	public Callback mknod = null;
	public Callback mkdir = null;
	public Callback unlink = null;
	public Callback rmdir = null;
	public Callback symlink = null;
	public Callback rename = null;
	public Callback link = null;
	public Callback chmod = null;
	public Callback chown = null;
	public Callback truncate = null;
	public Callback utime = null;
	public Callback open = null;
	public Callback read = null;
	public Callback write = null;
	public Callback statfs = null;
	public Callback flush = null;
	public Callback release = null;
	public Callback fsync = null;
	public Callback setxattr = null;
	public Callback getxattr = null;
	public Callback listxattr = null;
	public Callback removexattr = null;
	public Callback opendir = null;
	public Callback readdir = null;
	public Callback releasedir = null;
	public Callback fsyncdir = null;
	public Callback init = null;
	public Callback destroy = null;
	public Callback access = null;
	public Callback create = null;
	public Callback ftruncate = null;
	public Callback fgetattr = null;
	public Callback lock = null;
	public Callback utimens = null;
	public Callback bmap = null;
	public int flag_nullpath_ok = 0;
	public int flag_reserved = 31;
	public Callback ioctl = null;
	public Callback poll = null;

	@SuppressWarnings("unused")
	public StructFuseOperations(final FuseFilesystem filesystem)
	{
		getattr = new Callback()
		{
			public int callback(final String path, final StructStat.ByReference stat)
			{
				System.out.println("getattr " + stat);
				sleep();
				return 0;
			}
		};
		readlink = new Callback()
		{
			public int callback(final String path, final String target, final TypeSize size)
			{
				System.out.println("readlink");
				sleep();
				return 0;
			}
		};
		mknod = new Callback()
		{
			public int callback(final String path, final TypeMode mode, final TypeDev dev)
			{
				System.out.println("mknod");
				sleep();
				return 0;
			}
		};
		mkdir = new Callback()
		{
			public int callback(final String path, final TypeMode mode)
			{
				System.out.println("mkdir");
				sleep();
				return 0;
			}
		};
		unlink = new Callback()
		{
			public int callback(final String path)
			{
				System.out.println("unlink");
				sleep();
				return 0;
			}
		};
		rmdir = new Callback()
		{
			public int callback(final String path)
			{
				System.out.println("rmdir");
				sleep();
				return 0;
			}
		};
		symlink = new Callback()
		{
			public int callback(final String path, final String target)
			{
				System.out.println("symlink");
				sleep();
				return 0;
			}
		};
		rename = new Callback()
		{
			public int callback(final String path, final String newName)
			{
				System.out.println("rename");
				sleep();
				return 0;
			}
		};
		link = new Callback()
		{
			public int callback(final String path, final String target)
			{
				System.out.println("link");
				sleep();
				return 0;
			}
		};
		chmod = new Callback()
		{
			public int callback(final String path, final TypeMode mode)
			{
				System.out.println("chmod");
				sleep();
				return 0;
			}
		};
		chown = new Callback()
		{
			public int callback(final String path, final TypeUid uid, final TypeGid gid)
			{
				System.out.println("chown");
				sleep();
				return 0;
			}
		};
		truncate = new Callback()
		{
			public int callback(final String path, final TypeOff offset)
			{
				System.out.println("truncate");
				sleep();
				return 0;
			}
		};
		utime = null; // Deprecated
		open = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("open");
				sleep();
				return 0;
			}
		};
		read = new Callback()
		{
			public int callback(final String path, final Pointer buffer, final TypeSize size, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				System.out.println("read");
				sleep();
				return 0;
			}
		};
		write = new Callback()
		{
			public int callback(final String path, final String buffer, final TypeSize size, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				System.out.println("write");
				sleep();
				return 0;
			}
		};
		statfs = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference statsvfs)
			{
				System.out.println("statfs");
				sleep();
				return 0;
			}
		};
		flush = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("flush");
				sleep();
				return 0;
			}
		};
		release = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("info");
				sleep();
				return 0;
			}
		};
		fsync = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("fsync");
				sleep();
				return 0;
			}
		};
		setxattr = new Callback()
		{
			public int callback(final String path, final String xattr, final String value, final TypeSize size, final int flags)
			{ // xattr stuff has extra stuff on OS X
				System.out.println("setxattr");
				sleep();
				return 0;
			}
		};
		getxattr = new Callback()
		{
			public int callback(final String path, final String xattr, final Pointer target, final TypeSize size)
			{
				System.out.println("getxattr");
				sleep();
				return 0;
			}
		};
		listxattr = new Callback()
		{
			public int callback(final String path, final Pointer target, final TypeSize size)
			{
				System.out.println("listxattr");
				sleep();
				return 0;
			}
		};
		removexattr = new Callback()
		{
			public int callback(final String path, final String xattr)
			{
				System.out.println("removexattr");
				sleep();
				return 0;
			}
		};
		opendir = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("opendir");
				sleep();
				return 0;
			}
		};
		readdir = new Callback()
		{
			public int callback(final String path, final Callback fillFunction, final TypeOff offset,
					final StructFuseFileInfo.ByReference info)
			{
				System.out.println("readdir");
				sleep();
				return 0;
			}
		};
		releasedir = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("releasedir");
				sleep();
				return 0;
			}
		};
		fsyncdir = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("fsyncdir");
				sleep();
				return 0;
			}
		};
		init = new Callback()
		{
			public Pointer callback(final StructFuseConnInfo.ByReference conn)
			{
				System.out.println("init");
				sleep();
				return null;
			}
		};
		destroy = new Callback()
		{
			public void callback(final Pointer user_data)
			{
				System.out.println("destroy");
				sleep();
			}
		};
		access = new Callback()
		{
			public int callback(final String path, final int access)
			{
				System.out.println("access");
				sleep();
				return 0;
			}
		};
		create = new Callback()
		{
			public int callback(final String path, final TypeMode mode, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("create");
				sleep();
				return 0;
			}
		};
		ftruncate = new Callback()
		{
			public int callback(final String path, final TypeOff offset, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("ftruncate");
				sleep();
				return 0;
			}
		};
		fgetattr = new Callback()
		{
			public int callback(final String path, final Pointer attr, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("fgetattr");
				sleep();
				return 0;
			}
		};
		lock = new Callback()
		{
			public int callback(final String path, final Pointer info, final int cmd, final Pointer flock)
			{
				System.out.println("lock");
				sleep();
				return 0;
			}
		};
		utimens = new Callback()
		{
			public int callback(final String path, final Pointer timespec)
			{ // Has two timespecs
				System.out.println("utimens");
				sleep();
				return 0;
			}
		};
		bmap = new Callback()
		{
			public int callback(final String path, final StructFuseFileInfo.ByReference info)
			{
				System.out.println("bmap");
				sleep();
				return 0;
			}
		};
		ioctl = new Callback()
		{
			public int callback(final String path, final TypeSize blockSize, final Pointer idx)
			{
				System.out.println("ioctl");
				sleep();
				return 0;
			}
		};
		poll = new Callback()
		{
			public int callback(final String path, final TypeSize blockSize, final Pointer fuse_pollhandle,
					final Pointer reventsp)
			{
				System.out.println("poll");
				sleep();
				return 0;
			}
		};
	}

	private void sleep()
	{
		try {
			Thread.sleep(5000);
		}
		catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
