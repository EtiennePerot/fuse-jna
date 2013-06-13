package net.fusejna;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import net.fusejna.LibFuse.LibFuseProbe;
import net.fusejna.LibFuse.LibMacFuseProbe;

import com.sun.jna.Native;

public final class Platform
{
	public static enum PlatformEnum
	{
		LINUX_X86_64, LINUX_I686, LINUX_PPC, MAC, MAC_MACFUSE, FREEBSD
	}

	private static final String[] osxFuseLibraries = { "fuse4x", "osxfuse", "macfuse", "fuse" };
	private static PlatformEnum platform = null;
	private static LibFuse libFuse = null;
	private static Lock initLock = new ReentrantLock();

	static final LibFuse fuse()
	{
		if (libFuse == null) {
			init();
		}
		return libFuse;
	}

	private static final void init()
	{
		if (libFuse != null) {
			return;
		}
		initLock.lock();
		// Need to recheck
		if (libFuse == null) {
			switch (com.sun.jna.Platform.getOSType()) {
				case com.sun.jna.Platform.FREEBSD:
					platform = PlatformEnum.FREEBSD;
					libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
					break;
				case com.sun.jna.Platform.MAC:
					// First, need to load iconv
					final LibDl dl = (LibDl) Native.loadLibrary("iconv", LibDl.class);
					dl.dlopen("iconv", LibDl.RTLD_LAZY | LibDl.RTLD_GLOBAL);
					libFuse = null;
					LibFuseProbe probe;
					for (final String library : osxFuseLibraries) {
						try {
							probe = (LibMacFuseProbe) Native.loadLibrary(library, LibMacFuseProbe.class);
							((LibMacFuseProbe) probe).macfuse_version();
							// MacFUSE-compatible fuse library
							platform = PlatformEnum.MAC_MACFUSE;
							libFuse = (LibFuse) Native.loadLibrary(library, LibFuse.class);
							break;
						}
						catch (final Throwable e) {
							// Carry on
						}
						try {
							probe = (LibFuseProbe) Native.loadLibrary(library, LibFuseProbe.class);
							// Regular FUSE-compatible fuse library
							platform = PlatformEnum.MAC;
							libFuse = (LibFuse) Native.loadLibrary(library, LibFuse.class);
							break;
						}
						catch (final Throwable e) {
							// Carry on
						}
					}
					if (libFuse == null) {
						// Everything failed. Do a last-ditch attempt.
						// Worst-case scenario, this causes an exception
						// which will be more meaningful to the user than a NullPointerException on libFuse.
						libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
					}
					break;
				default:
					if (com.sun.jna.Platform.isIntel()) {
						platform = com.sun.jna.Platform.is64Bit() ? PlatformEnum.LINUX_X86_64 : PlatformEnum.LINUX_I686;
					}
					else {
						platform = PlatformEnum.LINUX_PPC;
					}
					libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
					break;
			}
		}
		initLock.unlock();
	}

	public static final PlatformEnum platform()
	{
		if (platform == null) {
			init();
		}
		return platform;
	}

	public static final int size(@SuppressWarnings("rawtypes") final Class cls)
	{
		return Native.getNativeSize(cls);
	}
}
