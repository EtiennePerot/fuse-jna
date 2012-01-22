package net.fusejna;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.fusejna.StructStat.StatSetter;

final class LoggedFuseFilesystem extends FuseFilesystem
{
	private interface LoggedMethod<T>
	{
		T invoke();
	}

	private interface LoggedVoidMethod
	{
		void invoke();
	}

	private final String className;
	private final Logger logger;
	private final FuseFilesystem filesystem;
	private static final String methodSuccess = "Method succeeded.";
	private static final String methodFailure = "Exception thrown: ";
	private static final String methodResult = " Result: ";

	LoggedFuseFilesystem(final FuseFilesystem filesystem, final Logger logger)
	{
		this.filesystem = filesystem;
		this.logger = logger;
		className = filesystem.getClass().getName();
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
		}, mountPoint);
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
		}, mountPoint);
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
	public int getattr(final String path, final StatSetter stat)
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

	private void log(final String methodName, final LoggedVoidMethod method)
	{
		log(methodName, method, (Object[]) null);
	}

	private void log(final String methodName, final LoggedVoidMethod method, final Object... args)
	{
		try {
			logger.entering(className, methodName, args);
			method.invoke();
			logger.logp(Level.INFO, className, methodName, methodSuccess, args);
			logger.exiting(className, methodName, args);
		}
		catch (final Throwable e) {
			logException(e, methodName, null, args);
		}
	}

	private <T> T log(final String methodName, final T defaultValue, final LoggedMethod<T> method)
	{
		return log(methodName, defaultValue, method, (Object[]) null);
	}

	private <T> T log(final String methodName, final T defaultValue, final LoggedMethod<T> method, final Object... args)
	{
		try {
			logger.entering(className, methodName, args);
			final T result = method.invoke();
			logger.logp(Level.INFO, className, methodName, methodSuccess + methodResult + result, args);
			logger.exiting(className, methodName, args);
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
		logger.logp(Level.SEVERE, className, methodName, methodFailure + e + builder.toString(), args);
		return defaultValue;
	}

	@Override
	public void onMount(final File mountPoint)
	{
		log("onMouse", new LoggedVoidMethod()
		{
			@Override
			public void invoke()
			{
				filesystem.onMount(mountPoint);
			}
		}, mountPoint);
	}

	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		return log("readdir", 0, new LoggedMethod<Integer>()
		{
			public Integer invoke()
			{
				return filesystem.readdir(path, filler);
			}
		}, path, filler);
	}

	@Override
	void setFinalMountPoint(final File mountPoint)
	{
		super.setFinalMountPoint(mountPoint);
		filesystem.setFinalMountPoint(mountPoint);
	}
}
