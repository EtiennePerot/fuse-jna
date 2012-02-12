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
					return;
				case com.sun.jna.Platform.MAC:
					// First, need to load iconv
					final LibDl dl = (LibDl) Native.loadLibrary("iconv", LibDl.class);
					dl.dlopen("iconv", LibDl.RTLD_LAZY | LibDl.RTLD_GLOBAL);
					LibFuseProbe probe = null;
					try {
						probe = (LibMacFuseProbe) Native.loadLibrary("fuse4x", LibMacFuseProbe.class);
						((LibMacFuseProbe) probe).macfuse_version();
						// MacFUSE-compatible fuse4x
						platform = PlatformEnum.MAC_MACFUSE;
						libFuse = (LibFuse) Native.loadLibrary("fuse4x", LibFuse.class);
						return;
					}
					catch (final Throwable e) {
						e.printStackTrace();
					}
					try {
						probe = (LibFuseProbe) Native.loadLibrary("fuse4x", LibFuseProbe.class);
						// FUSE-compatible fuse4x
						platform = PlatformEnum.MAC;
						libFuse = (LibFuse) Native.loadLibrary("fuse4x", LibFuse.class);
						return;
					}
					catch (final Throwable e) {
						e.printStackTrace();
					}
					try {
						probe = (LibFuseProbe) Native.loadLibrary("osxfuse", LibMacFuseProbe.class);
						((LibMacFuseProbe) probe).macfuse_version();
						// MacFUSE
						platform = PlatformEnum.MAC_MACFUSE;
						libFuse = (LibFuse) Native.loadLibrary("osxfuse", LibFuse.class);
						return;
					}
					catch (final Throwable e) {
						e.printStackTrace();
					}
					try {
						probe = (LibFuseProbe) Native.loadLibrary("osxfuse", LibFuseProbe.class);
						// FUSE-compatible osx-fuse
						platform = PlatformEnum.MAC;
						libFuse = (LibFuse) Native.loadLibrary("osxfuse", LibFuse.class);
						return;
					}
					catch (final Throwable e) {
						e.printStackTrace();
					}
					try {
						probe = (LibMacFuseProbe) Native.loadLibrary("fuse", LibMacFuseProbe.class);
						((LibMacFuseProbe) probe).macfuse_version();
						// MacFUSE
						platform = PlatformEnum.MAC_MACFUSE;
						libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
						return;
					}
					catch (final Throwable e) {
						e.printStackTrace();
					}
					probe = (LibFuseProbe) Native.loadLibrary("fuse", LibFuseProbe.class);
					// Some other FUSE-compatible library
					platform = PlatformEnum.MAC;
					libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
					return;
				default:
					if (com.sun.jna.Platform.isIntel()) {
						platform = com.sun.jna.Platform.is64Bit() ? PlatformEnum.LINUX_X86_64 : PlatformEnum.LINUX_I686;
					}
					else {
						platform = PlatformEnum.LINUX_PPC;
					}
					libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
					return;
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
