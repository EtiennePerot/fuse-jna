package net.fusejna;

final class AutoUnmountHook extends Thread
{
	private FuseFilesystem filesystem = null;

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
				// Can't do much here in a shutdown hook. Silently ignore.
			}
		}
	}
}
