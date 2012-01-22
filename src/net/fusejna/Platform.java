package net.fusejna;

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

	static LibFuse init()
	{
		Native.setProtected(true);
		switch (com.sun.jna.Platform.getOSType()) {
			case com.sun.jna.Platform.FREEBSD:
				platform = PlatformEnum.FREEBSD;
				return (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
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
					return (LibFuse) Native.loadLibrary("fuse4x", LibFuse.class);
				}
				catch (final Throwable e) {
					try {
						probe = (LibFuseProbe) Native.loadLibrary("fuse4x", LibFuseProbe.class);
						// FUSE-compatible fuse4x
						platform = PlatformEnum.MAC;
						return (LibFuse) Native.loadLibrary("fuse4x", LibFuse.class);
					}
					catch (final Throwable e2) {
						try {
							probe = (LibMacFuseProbe) Native.loadLibrary("fuse", LibMacFuseProbe.class);
							((LibMacFuseProbe) probe).macfuse_version();
							// MacFUSE
							platform = PlatformEnum.MAC_MACFUSE;
							return (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
						}
						catch (final Throwable e3) {
							probe = (LibFuseProbe) Native.loadLibrary("fuse", LibFuseProbe.class);
							// Some other FUSE-compatible library
							platform = PlatformEnum.MAC;
							return (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
						}
					}
				}
			default:
				if (com.sun.jna.Platform.isIntel()) {
					platform = com.sun.jna.Platform.is64Bit() ? PlatformEnum.LINUX_X86_64 : PlatformEnum.LINUX_I686;
				}
				else {
					platform = PlatformEnum.LINUX_PPC;
				}
				return (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
		}
	}

	public static final PlatformEnum platform()
	{
		return platform;
	}

	public static final int size(@SuppressWarnings("rawtypes") final Class cls)
	{
		return Native.getNativeSize(cls);
	}
}
