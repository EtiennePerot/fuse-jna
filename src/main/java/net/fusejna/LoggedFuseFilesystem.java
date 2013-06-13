package net.fusejna;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.fusejna.StructFlock.FlockWrapper;
import net.fusejna.StructFuseFileInfo.FileInfoWrapper;
import net.fusejna.StructStat.StatWrapper;
import net.fusejna.StructStatvfs.StatvfsWrapper;
import net.fusejna.StructTimeBuffer.TimeBufferWrapper;
import net.fusejna.types.TypeMode.ModeWrapper;

final class LoggedFuseFilesystem extends FuseFilesystem
{
	private static interface LoggedMethod<T>
	{
		public T invoke();
	}

	private static interface LoggedVoidMethod
	{
		public void invoke();
	}

	private static final String methodSuccess = "Method succeeded.";
	private static final String methodFailure = "Exception thrown: ";
	private static final String methodResult = " Result: ";
	private final String className;
	private final Logger actualLogger;
	private final FuseFilesystem filesystem;

	LoggedFuseFilesystem(final FuseFilesystem filesystem, final Logger logger)
	{
		this.filesystem = filesystem;
		actualLogger = logger;
		className = filesystem.getClass().getName();
	}

	@Override
	public int access(final String path, final int access)
	{
		return log("access", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.access(path, access);
			}
		}, path, access);
	}

	@Override
	public void afterUnmount(final File mountPoint)
	{
		log("afterUnmount", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.afterUnmount(mountPoint);
			}
		}, mountPoint.toString());
	}

	@Override
	public void beforeUnmount(final File mountPoint)
	{
		log("beforeUnmount", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.beforeUnmount(mountPoint);
			}
		}, mountPoint.toString());
	}

	@Override
	public int bmap(final String path, final FileInfoWrapper info)
	{
		return log("bmap", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.bmap(path, info);
			}
		}, path, info);
	}

	@Override
	public int chmod(final String path, final ModeWrapper mode)
	{
		return log("chmod", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.chmod(path, mode);
			}
		}, path, mode);
	}

	@Override
	public int chown(final String path, final long uid, final long gid)
	{
		return log("chown", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.chown(path, uid, gid);
			}
		}, path, uid, gid);
	}

	@Override
	public int create(final String path, final ModeWrapper mode, final FileInfoWrapper info)
	{
		return log("create", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.create(path, mode, info);
			}
		}, path, mode, info);
	}

	@Override
	public void destroy()
	{
		log("destroy", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.destroy();
			}
		});
	}

	@Override
	public int fgetattr(final String path, final StatWrapper stat, final FileInfoWrapper info)
	{
		return log("fgetattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.fgetattr(path, stat, info);
			}
		}, path, stat);
	}

	@Override
	public int flush(final String path, final FileInfoWrapper info)
	{
		return log("flush", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.flush(path, info);
			}
		}, path, info);
	}

	@Override
	public int fsync(final String path, final int datasync, final FileInfoWrapper info)
	{
		return log("flush", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.fsync(path, datasync, info);
			}
		}, path, info);
	}

	@Override
	public int fsyncdir(final String path, final int datasync, final FileInfoWrapper info)
	{
		return log("fsyncdir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.fsyncdir(path, datasync, info);
			}
		}, path, info);
	}

	@Override
	public int ftruncate(final String path, final long offset, final FileInfoWrapper info)
	{
		return log("getattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.ftruncate(path, offset, info);
			}
		}, path, offset, info);
	}

	@Override
	public int getattr(final String path, final StatWrapper stat)
	{
		return log("getattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.getattr(path, stat);
			}
		}, path, stat);
	}

	@Override
	protected String getName()
	{
		return log("getName", (String) null, new LoggedMethod<String>()
		{
			@Override
			public String invoke()
			{
				return filesystem.getName();
			}
		});
	}

	@Override
	protected String[] getOptions()
	{
		return log("getOptions", (String[]) null, new LoggedMethod<String[]>()
		{
			@Override
			public String[] invoke()
			{
				return filesystem.getOptions();
			}
		});
	}

	@Override
	public int getxattr(final String path, final String xattr, final ByteBuffer buf, final long size, final long position)
	{
		return log("getxattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.getxattr(path, xattr, buf, size, position);
			}
		}, path, xattr, buf, size, position);
	}

	@Override
	public void init()
	{
		log("init", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.init();
			}
		});
	}

	@Override
	public int link(final String path, final String target)
	{
		return log("link", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.link(path, target);
			}
		}, path, target);
	}

	@Override
	public int listxattr(final String path, final XattrListFiller filler)
	{
		return log("listxattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.listxattr(path, filler);
			}
		}, path, filler);
	}

	@Override
	public int lock(final String path, final FileInfoWrapper info, final FlockCommand command, final FlockWrapper flock)
	{
		return log("lock", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.lock(path, info, command, flock);
			}
		}, path, info, command, flock);
	}

	private void log(final String methodName, final LoggedVoidMethod method)
	{
		log(methodName, method, null, (Object[]) null);
	}

	private void log(final String methodName, final LoggedVoidMethod method, final String path, final Object... args)
	{
		try {
			actualLogger.entering(className, methodName, args);
			method.invoke();
			actualLogger.logp(Level.INFO, className, methodName, (path == null ? "" : "[" + path + "] ") + methodSuccess, args);
			actualLogger.exiting(className, methodName, args);
		}
		catch (final Throwable e) {
			logException(e, methodName, null, args);
		}
	}

	private <T> T log(final String methodName, final T defaultValue, final LoggedMethod<T> method)
	{
		return log(methodName, defaultValue, method, null, (Object[]) null);
	}

	private <T> T log(final String methodName, final T defaultValue, final LoggedMethod<T> method, final String path,
			final Object... args)
	{
		try {
			actualLogger.entering(className, methodName, args);
			final T result = method.invoke();
			actualLogger.logp(Level.INFO, className, methodName, (path == null ? "" : "[" + path + "] ") + methodSuccess
					+ methodResult + result, args);
			actualLogger.exiting(className, methodName, args);
			return result;
		}
		catch (final Throwable e) {
			return logException(e, methodName, defaultValue, args);
		}
	}

	private <T> T logException(final Throwable e, final String methodName, final T defaultValue, final Object... args)
	{
		final StackTraceElement[] stack = e.getStackTrace();
		final StringBuilder builder = new StringBuilder();
		for (final StackTraceElement element : stack) {
			builder.append("\n" + element);
		}
		actualLogger.logp(Level.SEVERE, className, methodName, methodFailure + e + builder.toString(), args);
		return defaultValue;
	}

	@Override
	public int mkdir(final String path, final ModeWrapper mode)
	{
		return log("mkdir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.mkdir(path, mode);
			}
		}, path, mode);
	}

	@Override
	public int mknod(final String path, final ModeWrapper mode, final long dev)
	{
		return log("mknod", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.mknod(path, mode, dev);
			}
		}, path, mode, dev);
	}

	@Override
	public void onMount(final File mountPoint)
	{
		log("onMount", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.onMount(mountPoint);
			}
		}, mountPoint.toString());
	}

	@Override
	public int open(final String path, final FileInfoWrapper info)
	{
		return log("open", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.open(path, info);
			}
		}, path, info);
	}

	@Override
	public int opendir(final String path, final FileInfoWrapper info)
	{
		return log("opendir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.opendir(path, info);
			}
		}, path, info);
	}

	@Override
	public int read(final String path, final ByteBuffer buffer, final long size, final long offset, final FileInfoWrapper info)
	{
		return log("read", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.read(path, buffer, size, offset, info);
			}
		}, path, buffer, size, offset, info);
	}

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		return log("readdir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.readdir(path, filler);
			}
		}, path, filler);
	}

	@Override
	public int readlink(final String path, final ByteBuffer buffer, final long size)
	{
		return log("readlink", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.readlink(path, buffer, size);
			}
		}, path, buffer, size);
	}

	@Override
	public int release(final String path, final FileInfoWrapper info)
	{
		return log("release", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.release(path, info);
			}
		}, path, info);
	}

	@Override
	public int releasedir(final String path, final FileInfoWrapper info)
	{
		return log("releasedir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.releasedir(path, info);
			}
		}, path, info);
	}

	@Override
	public int removexattr(final String path, final String xattr)
	{
		return log("remtoexattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.removexattr(path, xattr);
			}
		}, path, xattr);
	}

	@Override
	public int rename(final String path, final String newName)
	{
		return log("rename", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.rename(path, newName);
			}
		});
	}

	@Override
	public int rmdir(final String path)
	{
		return log("rmdir", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.rmdir(path);
			}
		}, path);
	}

	@Override
	void setFinalMountPoint(final File mountPoint)
	{
		super.setFinalMountPoint(mountPoint);
		filesystem.setFinalMountPoint(mountPoint);
	}

	@Override
	public int setxattr(final String path, final ByteBuffer buf, final long size, final int flags, final long position)
	{
		return log("setxattr", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.setxattr(path, buf, size, flags, position);
			}
		}, path, buf, size, flags, position);
	}

	@Override
	public int statfs(final String path, final StatvfsWrapper wrapper)
	{
		return log("statfs", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.statfs(path, wrapper);
			}
		}, path, wrapper);
	}

	@Override
	public int symlink(final String path, final String target)
	{
		return log("symlink", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.symlink(path, target);
			}
		}, path, target);
	}

	@Override
	public int truncate(final String path, final long offset)
	{
		return log("truncate", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.truncate(path, offset);
			}
		}, path, offset);
	}

	@Override
	public int unlink(final String path)
	{
		return log("unlink", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.unlink(path);
			}
		}, path);
	}

	@Override
	public int utimens(final String path, final TimeBufferWrapper wrapper)
	{
		return log("utimens", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.utimens(path, wrapper);
			}
		}, path, wrapper);
	}

	@Override
	public int write(final String path, final ByteBuffer buf, final long bufSize, final long writeOffset,
			final FileInfoWrapper wrapper)
	{
		return log("write", 0, new LoggedMethod<Integer>()
		{
			@Override
			public Integer invoke()
			{
				return filesystem.write(path, buf, bufSize, writeOffset, wrapper);
			}
		}, path, buf, bufSize, writeOffset, wrapper);
	}
}
