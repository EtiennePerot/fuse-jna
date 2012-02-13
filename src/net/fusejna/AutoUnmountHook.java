package net.fusejna;

final class AutoUnmountHook extends Thread
{
	private FuseFilesystem filesystem = null;

	AutoUnmountHook(final FuseFilesystem filesystem)
	{
		this.filesystem = filesystem;
	}

	/**
	 * Used when the filesystem is unmounted by the user without our help. Clean up reference so that the filesystem object may
	 * be garbage-collected.
	 */
	final void invalidate()
	{
		filesystem = null;
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
