package net.fusejna;

import net.fusejna.LibFuse.LibMacFuse;

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
				LibFuse libFuse = null;
				try {
					libFuse = (LibMacFuse) Native.loadLibrary("fuse4x", LibMacFuse.class);
					((LibMacFuse) libFuse).macfuse_version();
					return libFuse;
				}
				catch (final Throwable e) {
					try {
						return (LibFuse) Native.loadLibrary("fuse4x", LibFuse.class);
					}
					catch (final Throwable e2) {
						try {
							libFuse = (LibMacFuse) Native.loadLibrary("fuse", LibMacFuse.class);
							((LibMacFuse) libFuse).macfuse_version();
							return libFuse;
						}
						catch (final Throwable e3) {
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
