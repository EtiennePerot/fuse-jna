package net.fusejna;

public interface ErrorCodes
{
	// error codes are different on BSD and Linux, therefore we try to detect BSD and handle the difference correctly here
	// Note: this code is "borrowed" from Apache Commons Lang class SystemUtils...
	public static final String OS_NAME = System.getProperty("os.name");
	public static final boolean IS_OS_FREE_BSD = OS_NAME != null && OS_NAME.startsWith("FreeBSD");
	public static final boolean IS_OS_OPEN_BSD = OS_NAME != null && OS_NAME.startsWith("OpenBSD");
	public static final boolean IS_OS_NET_BSD = OS_NAME != null && OS_NAME.startsWith("NetBSD");
	public static final boolean IS_OS_MAC_OSX = OS_NAME != null && OS_NAME.startsWith("Mac OS X");
	public static final boolean IS_OS_BSD_DERIVATIVE = IS_OS_FREE_BSD || IS_OS_NET_BSD || IS_OS_OPEN_BSD || IS_OS_MAC_OSX;
	/**
	 * Operation not permitted
	 */
	public static final int EPERM = 1;
	/**
	 * No such file or directory
	 */
	public static final int ENOENT = 2;
	/**
	 * No such process
	 */
	public static final int ESRCH = 3;
	/**
	 * Interrupted system call
	 */
	public static final int EINTR = 4;
	/**
	 * Input/output error
	 */
	public static final int EIO = 5;
	/**
	 * Device not configured
	 */
	public static final int ENXIO = 6;
	/**
	 * Argument list too long
	 */
	public static final int E2BIG = 7;
	/**
	 * Exec format error
	 */
	public static final int ENOEXEC = 8;
	/**
	 * Bad file descriptor
	 */
	public static final int EBADF = 9;
	/**
	 * No child processes
	 */
	public static final int ECHILD = 10;
	/**
	 * Resource deadlock avoided
	 */
	public static final int EDEADLK = IS_OS_BSD_DERIVATIVE ? 11 : 35;
	/**
	 * Cannot allocate memory
	 */
	public static final int ENOMEM = 12;
	/**
	 * Permission denied
	 */
	public static final int EACCES = 13;
	/**
	 * Bad address
	 */
	public static final int EFAULT = 14;
	/**
	 * Block device required
	 */
	public static final int ENOTBLK = 15;
	/**
	 * Device busy
	 */
	public static final int EBUSY = 16;
	/**
	 * File exists
	 */
	public static final int EEXIST = 17;
	/**
	 * Cross-device link
	 */
	public static final int EXDEV = 18;
	/**
	 * Operation not supported by device
	 */
	public static final int ENODEV = 19;
	/**
	 * Not a directory
	 */
	public static final int ENOTDIR = 20;
	/**
	 * Is a directory
	 */
	public static final int EISDIR = 21;
	/**
	 * Invalid argument
	 */
	public static final int EINVAL = 22;
	/**
	 * Too many open files in system
	 */
	public static final int ENFILE = 23;
	/**
	 * Too many open files
	 */
	public static final int EMFILE = 24;
	/**
	 * Inappropriate ioctl for device
	 */
	public static final int ENOTTY = 25;
	/**
	 * Text file busy
	 */
	public static final int ETXTBSY = 26;
	/**
	 * File too large
	 */
	public static final int EFBIG = 27;
	/**
	 * No space left on device
	 */
	public static final int ENOSPC = 28;
	/**
	 * Illegal seek
	 */
	public static final int ESPIPE = 29;
	/**
	 * Read-only file system
	 */
	public static final int EROFS = 30;
	/**
	 * Too many links
	 */
	public static final int EMLINK = 31;
	/**
	 * Broken pipe
	 */
	public static final int EPIPE = 32;
	/**
	 * Numerical argument out of domain
	 */
	public static final int EDOM = 33;
	/**
	 * Result too large
	 */
	public static final int ERANGE = 34;
	/**
	 * Resource temporarily unavailable
	 */
	public static final int EAGAIN = IS_OS_BSD_DERIVATIVE ? 35 : 11;
	/**
	 * Operation would block
	 */
	public static final int EWOULDBLOCK = EAGAIN;
	/**
	 * Operation now in progress
	 */
	public static final int EINPROGRESS = 36;
	/**
	 * Operation already in progress
	 */
	public static final int EALREADY = 37;
	/**
	 * Socket operation on non-socket
	 */
	public static final int ENOTSOCK = 38;
	/**
	 * Destination address required
	 */
	public static final int EDESTADDRREQ = 39;
	/**
	 * Message too long
	 */
	public static final int EMSGSIZE = 40;
	/**
	 * Protocol wrong type for socket
	 */
	public static final int EPROTOTYPE = 41;
	/**
	 * Protocol not available
	 */
	public static final int ENOPROTOOPT = 42;
	/**
	 * Protocol not supported
	 */
	public static final int EPROTONOSUPPORT = 43;
	/**
	 * Socket type not supported
	 */
	public static final int ESOCKTNOSUPPORT = 44;
	/**
	 * Operation not supported
	 */
	public static final int EOPNOTSUPP = 45;
	/**
	 * Protocol family not supported
	 */
	public static final int EPFNOSUPPORT = 46;
	/**
	 * Address family not supported by protocol family
	 */
	public static final int EAFNOSUPPORT = 47;
	/**
	 * Address already in use
	 */
	public static final int EADDRINUSE = 48;
	/**
	 * Can't assign requested address
	 */
	public static final int EADDRNOTAVAIL = 49;
	/**
	 * Network is down
	 */
	public static final int ENETDOWN = 50;
	/**
	 * Network is unreachable
	 */
	public static final int ENETUNREACH = 51;
	/**
	 * Network dropped connection on reset
	 */
	public static final int ENETRESET = 52;
	/**
	 * Software caused connection abort
	 */
	public static final int ECONNABORTED = 53;
	/**
	 * Connection reset by peer
	 */
	public static final int ECONNRESET = 54;
	/**
	 * No buffer space available
	 */
	public static final int ENOBUFS = 55;
	/**
	 * Socket is already connected
	 */
	public static final int EISCONN = 56;
	/**
	 * Socket is not connected
	 */
	public static final int ENOTCONN = 57;
	/**
	 * Can't send after socket shutdown
	 */
	public static final int ESHUTDOWN = 58;
	/**
	 * Too many references: can't splice
	 */
	public static final int ETOOMANYREFS = 59;
	/**
	 * Operation timed out
	 */
	public static final int ETIMEDOUT = 60;
	/**
	 * Connection refused
	 */
	public static final int ECONNREFUSED = 61;
	/**
	 * Too many levels of symbolic links
	 */
	public static final int ELOOP = IS_OS_BSD_DERIVATIVE ? 62 : 40;
	/**
	 * File name too long
	 */
	public static final int ENAMETOOLONG = IS_OS_BSD_DERIVATIVE ? 63 : 36;
	/**
	 * Host is down
	 */
	public static final int EHOSTDOWN = 64;
	/**
	 * No route to host
	 */
	public static final int EHOSTUNREACH = 65;
	/**
	 * Directory not empty
	 */
	public static final int ENOTEMPTY = IS_OS_BSD_DERIVATIVE ? 66 : 39;
	/**
	 * Too many processes
	 */
	public static final int EPROCLIM = 67;
	/**
	 * Too many users
	 */
	public static final int EUSERS = 68;
	/**
	 * Disc quota exceeded
	 */
	public static final int EDQUOT = 69;
	/**
	 * Stale NFS file handle
	 */
	public static final int ESTALE = 70;
	/**
	 * Too many levels of remote in path
	 */
	public static final int EREMOTE = 71;
	/**
	 * RPC struct is bad
	 */
	public static final int EBADRPC = 72;
	/**
	 * RPC version wrong
	 */
	public static final int ERPCMISMATCH = 73;
	/**
	 * RPC prog. not avail
	 */
	public static final int EPROGUNAVAIL = 74;
	/**
	 * Program version wrong
	 */
	public static final int EPROGMISMATCH = 75;
	/**
	 * Bad procedure for program
	 */
	public static final int EPROCUNAVAIL = 76;
	/**
	 * No locks available
	 */
	public static final int ENOLCK = IS_OS_BSD_DERIVATIVE ? 77 : 37;
	/**
	 * Function not implemented
	 */
	public static final int ENOSYS = IS_OS_BSD_DERIVATIVE ? 78 : 38;
	/**
	 * Inappropriate file type or format
	 */
	public static final int EFTYPE = 79;
	/**
	 * Authentication error
	 */
	public static final int EAUTH = 80;
	/**
	 * Need authenticator
	 */
	public static final int ENEEDAUTH = 81;
	/**
	 * Identifier removed
	 */
	public static final int EIDRM = IS_OS_BSD_DERIVATIVE ? 82 : 43;
	/**
	 * No message of desired type
	 */
	public static final int ENOMSG = IS_OS_BSD_DERIVATIVE ? 83 : 42;
	/**
	 * Value too large to be stored in data type
	 */
	public static final int EOVERFLOW = 84;
	/**
	 * Operation canceled
	 */
	public static final int ECANCELED = 85;
	/**
	 * Illegal byte sequence
	 */
	public static final int EILSEQ = 86;
	/**
	 * Must be equal largest errno
	 */
	public static final int ELAST = 86;
}
