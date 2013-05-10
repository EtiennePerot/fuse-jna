package net.fusejna;

final class AutoUnmountHook extends Thread
{
	private final FuseFilesystem filesystem;

	AutoUnmountHook(final FuseFilesystem filesystem)
	{
		this.filesystem = filesystem;
	}

	@Override
	public final void run()
	{
		if (filesystem != null) {
			try {
				filesystem.unmount();
			}
			catch (final Exception e) {
				// FIXME: Never ignore an exception, at least log it somewhere
				// Can't do much here in a shutdown hook. Silently ignore.
			}
		}
	}
}
