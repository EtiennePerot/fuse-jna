package net.fusejna;

public final class ErrorCodes
{
	private static final class ErrorCodesBSD implements IErrorCodes
	{
		@Override
		public final int E2BIG()
		{
			return 7;
		}

		@Override
		public final int EACCES()
		{
			return 13;
		}

		@Override
		public final int EADDRINUSE()
		{
			return 48;
		}

		@Override
		public final int EADDRNOTAVAIL()
		{
			return 49;
		}

		@Override
		public Integer EADV()
		{
			return null;
		}

		@Override
		public final int EAFNOSUPPORT()
		{
			return 47;
		}

		@Override
		public final int EAGAIN()
		{
			return 35;
		}

		@Override
		public final int EALREADY()
		{
			return 37;
		}

		@Override
		public final Integer EAUTH()
		{
			return 80;
		}

		@Override
		public Integer EBADE()
		{
			return null;
		}

		@Override
		public final int EBADF()
		{
			return 9;
		}

		@Override
		public Integer EBADFD()
		{
			return null;
		}

		@Override
		public final int EBADMSG()
		{
			return 89;
		}

		@Override
		public Integer EBADR()
		{
			return null;
		}

		@Override
		public final Integer EBADRPC()
		{
			return 72;
		}

		@Override
		public Integer EBADRQC()
		{
			return null;
		}

		@Override
		public Integer EBADSLT()
		{
			return null;
		}

		@Override
		public Integer EBFONT()
		{
			return null;
		}

		@Override
		public final int EBUSY()
		{
			return 16;
		}

		@Override
		public final int ECANCELED()
		{
			return 85;
		}

		@Override
		public final int ECHILD()
		{
			return 10;
		}

		@Override
		public Integer ECHRNG()
		{
			return null;
		}

		@Override
		public Integer ECOMM()
		{
			return null;
		}

		@Override
		public final int ECONNABORTED()
		{
			return 53;
		}

		@Override
		public final int ECONNREFUSED()
		{
			return 61;
		}

		@Override
		public final int ECONNRESET()
		{
			return 54;
		}

		@Override
		public final int EDEADLK()
		{
			return 11;
		}

		@Override
		public Integer EDEADLOCK()
		{
			return null;
		}

		@Override
		public final int EDESTADDRREQ()
		{
			return 39;
		}

		@Override
		public final int EDOM()
		{
			return 33;
		}

		@Override
		public final Integer EDOOFUS()
		{
			return 88;
		}

		@Override
		public Integer EDOTDOT()
		{
			return null;
		}

		@Override
		public final int EDQUOT()
		{
			return 69;
		}

		@Override
		public final int EEXIST()
		{
			return 17;
		}

		@Override
		public final int EFAULT()
		{
			return 14;
		}

		@Override
		public final int EFBIG()
		{
			return 27;
		}

		@Override
		public final Integer EFTYPE()
		{
			return 79;
		}

		@Override
		public final int EHOSTDOWN()
		{
			return 64;
		}

		@Override
		public final int EHOSTUNREACH()
		{
			return 65;
		}

		@Override
		public final int EIDRM()
		{
			return 82;
		}

		@Override
		public final int EILSEQ()
		{
			return 86;
		}

		@Override
		public final int EINPROGRESS()
		{
			return 36;
		}

		@Override
		public final int EINTR()
		{
			return 4;
		}

		@Override
		public final int EINVAL()
		{
			return 22;
		}

		@Override
		public final int EIO()
		{
			return 5;
		}

		@Override
		public final int EISCONN()
		{
			return 56;
		}

		@Override
		public final int EISDIR()
		{
			return 21;
		}

		@Override
		public Integer EISNAM()
		{
			return null;
		}

		@Override
		public Integer EKEYEXPIRED()
		{
			return null;
		}

		@Override
		public Integer EKEYREJECTED()
		{
			return null;
		}

		@Override
		public Integer EKEYREVOKED()
		{
			return null;
		}

		@Override
		public Integer EL2HLT()
		{
			return null;
		}

		@Override
		public Integer EL2NSYNC()
		{
			return null;
		}

		@Override
		public Integer EL3HLT()
		{
			return null;
		}

		@Override
		public Integer EL3RST()
		{
			return null;
		}

		@Override
		public final Integer ELAST()
		{
			return 93;
		}

		@Override
		public Integer ELIBACC()
		{
			return null;
		}

		@Override
		public Integer ELIBBAD()
		{
			return null;
		}

		@Override
		public Integer ELIBEXEC()
		{
			return null;
		}

		@Override
		public Integer ELIBMAX()
		{
			return null;
		}

		@Override
		public Integer ELIBSCN()
		{
			return null;
		}

		@Override
		public Integer ELNRNG()
		{
			return null;
		}

		@Override
		public final int ELOOP()
		{
			return 62;
		}

		@Override
		public Integer EMEDIUMTYPE()
		{
			return null;
		}

		@Override
		public final int EMFILE()
		{
			return 24;
		}

		@Override
		public final int EMLINK()
		{
			return 31;
		}

		@Override
		public final int EMSGSIZE()
		{
			return 40;
		}

		@Override
		public final int EMULTIHOP()
		{
			return 90;
		}

		@Override
		public final int ENAMETOOLONG()
		{
			return 63;
		}

		@Override
		public Integer ENAVAIL()
		{
			return null;
		}

		@Override
		public final Integer ENEEDAUTH()
		{
			return 81;
		}

		@Override
		public final int ENETDOWN()
		{
			return 50;
		}

		@Override
		public final int ENETRESET()
		{
			return 52;
		}

		@Override
		public final int ENETUNREACH()
		{
			return 51;
		}

		@Override
		public final int ENFILE()
		{
			return 23;
		}

		@Override
		public Integer ENOANO()
		{
			return null;
		}

		@Override
		public final Integer ENOATTR()
		{
			return 87;
		}

		@Override
		public final int ENOBUFS()
		{
			return 55;
		}

		@Override
		public Integer ENOCSI()
		{
			return null;
		}

		@Override
		public Integer ENODATA()
		{
			return null;
		}

		@Override
		public final int ENODEV()
		{
			return 19;
		}

		@Override
		public final int ENOENT()
		{
			return 2;
		}

		@Override
		public final int ENOEXEC()
		{
			return 8;
		}

		@Override
		public Integer ENOKEY()
		{
			return null;
		}

		@Override
		public final int ENOLCK()
		{
			return 77;
		}

		@Override
		public final int ENOLINK()
		{
			return 91;
		}

		@Override
		public Integer ENOMEDIUM()
		{
			return null;
		}

		@Override
		public final int ENOMEM()
		{
			return 12;
		}

		@Override
		public final int ENOMSG()
		{
			return 83;
		}

		@Override
		public Integer ENONET()
		{
			return null;
		}

		@Override
		public Integer ENOPKG()
		{
			return null;
		}

		@Override
		public final int ENOPROTOOPT()
		{
			return 42;
		}

		@Override
		public final int ENOSPC()
		{
			return 28;
		}

		@Override
		public Integer ENOSR()
		{
			return null;
		}

		@Override
		public Integer ENOSTR()
		{
			return null;
		}

		@Override
		public final int ENOSYS()
		{
			return 78;
		}

		@Override
		public final int ENOTBLK()
		{
			return 15;
		}

		@Override
		public final Integer ENOTCAPABLE()
		{
			return 93;
		}

		@Override
		public final int ENOTCONN()
		{
			return 57;
		}

		@Override
		public final int ENOTDIR()
		{
			return 20;
		}

		@Override
		public final int ENOTEMPTY()
		{
			return 66;
		}

		@Override
		public Integer ENOTNAM()
		{
			return null;
		}

		@Override
		public Integer ENOTRECOVERABLE()
		{
			return null;
		}

		@Override
		public final int ENOTSOCK()
		{
			return 38;
		}

		@Override
		public final Integer ENOTSUP()
		{
			return EOPNOTSUPP();
		}

		@Override
		public final int ENOTTY()
		{
			return 25;
		}

		@Override
		public Integer ENOTUNIQ()
		{
			return null;
		}

		@Override
		public final int ENXIO()
		{
			return 6;
		}

		@Override
		public final int EOPNOTSUPP()
		{
			return 45;
		}

		@Override
		public final int EOVERFLOW()
		{
			return 84;
		}

		@Override
		public Integer EOWNERDEAD()
		{
			return null;
		}

		@Override
		public final int EPERM()
		{
			return 1;
		}

		@Override
		public final int EPFNOSUPPORT()
		{
			return 46;
		}

		@Override
		public final int EPIPE()
		{
			return 32;
		}

		@Override
		public final Integer EPROCLIM()
		{
			return 67;
		}

		@Override
		public final Integer EPROCUNAVAIL()
		{
			return 76;
		}

		@Override
		public final Integer EPROGMISMATCH()
		{
			return 75;
		}

		@Override
		public final Integer EPROGUNAVAIL()
		{
			return 74;
		}

		@Override
		public final int EPROTO()
		{
			return 92;
		}

		@Override
		public final int EPROTONOSUPPORT()
		{
			return 43;
		}

		@Override
		public final int EPROTOTYPE()
		{
			return 41;
		}

		@Override
		public final int ERANGE()
		{
			return 34;
		}

		@Override
		public Integer EREMCHG()
		{
			return null;
		}

		@Override
		public final int EREMOTE()
		{
			return 71;
		}

		@Override
		public Integer EREMOTEIO()
		{
			return null;
		}

		@Override
		public Integer ERESTART()
		{
			return null;
		}

		@Override
		public final int EROFS()
		{
			return 30;
		}

		@Override
		public final Integer ERPCMISMATCH()
		{
			return 73;
		}

		@Override
		public final int ESHUTDOWN()
		{
			return 58;
		}

		@Override
		public final int ESOCKTNOSUPPORT()
		{
			return 44;
		}

		@Override
		public final int ESPIPE()
		{
			return 29;
		}

		@Override
		public final int ESRCH()
		{
			return 3;
		}

		@Override
		public Integer ESRMNT()
		{
			return null;
		}

		@Override
		public final int ESTALE()
		{
			return 70;
		}

		@Override
		public Integer ESTRPIPE()
		{
			return null;
		}

		@Override
		public Integer ETIME()
		{
			return null;
		}

		@Override
		public final int ETIMEDOUT()
		{
			return 60;
		}

		@Override
		public final int ETOOMANYREFS()
		{
			return 59;
		}

		@Override
		public final int ETXTBSY()
		{
			return 26;
		}

		@Override
		public Integer EUCLEAN()
		{
			return null;
		}

		@Override
		public Integer EUNATCH()
		{
			return null;
		}

		@Override
		public final int EUSERS()
		{
			return 68;
		}

		@Override
		public final int EWOULDBLOCK()
		{
			return EAGAIN();
		}

		@Override
		public final int EXDEV()
		{
			return 18;
		}

		@Override
		public Integer EXFULL()
		{
			return null;
		}
	}

	private static final class ErrorCodesLinux implements IErrorCodes
	{
		@Override
		public final int E2BIG()
		{
			return 7;
		}

		@Override
		public final int EACCES()
		{
			return 13;
		}

		@Override
		public final int EADDRINUSE()
		{
			return 98;
		}

		@Override
		public final int EADDRNOTAVAIL()
		{
			return 99;
		}

		@Override
		public final Integer EADV()
		{
			return 68;
		}

		@Override
		public final int EAFNOSUPPORT()
		{
			return 97;
		}

		@Override
		public final int EAGAIN()
		{
			return 11;
		}

		@Override
		public final int EALREADY()
		{
			return 114;
		}

		@Override
		public Integer EAUTH()
		{
			return null;
		}

		@Override
		public final Integer EBADE()
		{
			return 52;
		}

		@Override
		public final int EBADF()
		{
			return 9;
		}

		@Override
		public final Integer EBADFD()
		{
			return 77;
		}

		@Override
		public final int EBADMSG()
		{
			return 74;
		}

		@Override
		public final Integer EBADR()
		{
			return 53;
		}

		@Override
		public Integer EBADRPC()
		{
			return null;
		}

		@Override
		public final Integer EBADRQC()
		{
			return 56;
		}

		@Override
		public final Integer EBADSLT()
		{
			return 57;
		}

		@Override
		public final Integer EBFONT()
		{
			return 59;
		}

		@Override
		public final int EBUSY()
		{
			return 16;
		}

		@Override
		public final int ECANCELED()
		{
			return 125;
		}

		@Override
		public final int ECHILD()
		{
			return 10;
		}

		@Override
		public final Integer ECHRNG()
		{
			return 44;
		}

		@Override
		public final Integer ECOMM()
		{
			return 70;
		}

		@Override
		public final int ECONNABORTED()
		{
			return 103;
		}

		@Override
		public final int ECONNREFUSED()
		{
			return 111;
		}

		@Override
		public final int ECONNRESET()
		{
			return 104;
		}

		@Override
		public final int EDEADLK()
		{
			return 35;
		}

		@Override
		public final Integer EDEADLOCK()
		{
			return EDEADLK();
		}

		@Override
		public final int EDESTADDRREQ()
		{
			return 89;
		}

		@Override
		public final int EDOM()
		{
			return 33;
		}

		@Override
		public Integer EDOOFUS()
		{
			return null;
		}

		@Override
		public final Integer EDOTDOT()
		{
			return 73;
		}

		@Override
		public final int EDQUOT()
		{
			return 122;
		}

		@Override
		public final int EEXIST()
		{
			return 17;
		}

		@Override
		public final int EFAULT()
		{
			return 14;
		}

		@Override
		public final int EFBIG()
		{
			return 27;
		}

		@Override
		public Integer EFTYPE()
		{
			return null;
		}

		@Override
		public final int EHOSTDOWN()
		{
			return 112;
		}

		@Override
		public final int EHOSTUNREACH()
		{
			return 113;
		}

		@Override
		public final int EIDRM()
		{
			return 43;
		}

		@Override
		public final int EILSEQ()
		{
			return 84;
		}

		@Override
		public final int EINPROGRESS()
		{
			return 115;
		}

		@Override
		public final int EINTR()
		{
			return 4;
		}

		@Override
		public final int EINVAL()
		{
			return 22;
		}

		@Override
		public final int EIO()
		{
			return 5;
		}

		@Override
		public final int EISCONN()
		{
			return 106;
		}

		@Override
		public final int EISDIR()
		{
			return 21;
		}

		@Override
		public final Integer EISNAM()
		{
			return 120;
		}

		@Override
		public final Integer EKEYEXPIRED()
		{
			return 127;
		}

		@Override
		public final Integer EKEYREJECTED()
		{
			return 129;
		}

		@Override
		public final Integer EKEYREVOKED()
		{
			return 128;
		}

		@Override
		public final Integer EL2HLT()
		{
			return 51;
		}

		@Override
		public final Integer EL2NSYNC()
		{
			return 45;
		}

		@Override
		public final Integer EL3HLT()
		{
			return 46;
		}

		@Override
		public final Integer EL3RST()
		{
			return 47;
		}

		@Override
		public Integer ELAST()
		{
			return null;
		}

		@Override
		public final Integer ELIBACC()
		{
			return 79;
		}

		@Override
		public final Integer ELIBBAD()
		{
			return 80;
		}

		@Override
		public final Integer ELIBEXEC()
		{
			return 83;
		}

		@Override
		public final Integer ELIBMAX()
		{
			return 82;
		}

		@Override
		public final Integer ELIBSCN()
		{
			return 81;
		}

		@Override
		public final Integer ELNRNG()
		{
			return 48;
		}

		@Override
		public final int ELOOP()
		{
			return 40;
		}

		@Override
		public final Integer EMEDIUMTYPE()
		{
			return 124;
		}

		@Override
		public final int EMFILE()
		{
			return 24;
		}

		@Override
		public final int EMLINK()
		{
			return 31;
		}

		@Override
		public final int EMSGSIZE()
		{
			return 90;
		}

		@Override
		public final int EMULTIHOP()
		{
			return 72;
		}

		@Override
		public final int ENAMETOOLONG()
		{
			return 36;
		}

		@Override
		public final Integer ENAVAIL()
		{
			return 119;
		}

		@Override
		public Integer ENEEDAUTH()
		{
			return null;
		}

		@Override
		public final int ENETDOWN()
		{
			return 100;
		}

		@Override
		public final int ENETRESET()
		{
			return 102;
		}

		@Override
		public final int ENETUNREACH()
		{
			return 101;
		}

		@Override
		public final int ENFILE()
		{
			return 23;
		}

		@Override
		public final Integer ENOANO()
		{
			return 55;
		}

		@Override
		public Integer ENOATTR()
		{
			return null;
		}

		@Override
		public final int ENOBUFS()
		{
			return 105;
		}

		@Override
		public final Integer ENOCSI()
		{
			return 50;
		}

		@Override
		public final Integer ENODATA()
		{
			return 61;
		}

		@Override
		public final int ENODEV()
		{
			return 19;
		}

		@Override
		public final int ENOENT()
		{
			return 2;
		}

		@Override
		public final int ENOEXEC()
		{
			return 8;
		}

		@Override
		public final Integer ENOKEY()
		{
			return 126;
		}

		@Override
		public final int ENOLCK()
		{
			return 37;
		}

		@Override
		public final int ENOLINK()
		{
			return 67;
		}

		@Override
		public final Integer ENOMEDIUM()
		{
			return 123;
		}

		@Override
		public final int ENOMEM()
		{
			return 12;
		}

		@Override
		public final int ENOMSG()
		{
			return 42;
		}

		@Override
		public final Integer ENONET()
		{
			return 64;
		}

		@Override
		public final Integer ENOPKG()
		{
			return 65;
		}

		@Override
		public final int ENOPROTOOPT()
		{
			return 92;
		}

		@Override
		public final int ENOSPC()
		{
			return 28;
		}

		@Override
		public final Integer ENOSR()
		{
			return 63;
		}

		@Override
		public final Integer ENOSTR()
		{
			return 60;
		}

		@Override
		public final int ENOSYS()
		{
			return 38;
		}

		@Override
		public final int ENOTBLK()
		{
			return 15;
		}

		@Override
		public Integer ENOTCAPABLE()
		{
			return null;
		}

		@Override
		public final int ENOTCONN()
		{
			return 107;
		}

		@Override
		public final int ENOTDIR()
		{
			return 20;
		}

		@Override
		public final int ENOTEMPTY()
		{
			return 39;
		}

		@Override
		public final Integer ENOTNAM()
		{
			return 118;
		}

		@Override
		public final Integer ENOTRECOVERABLE()
		{
			return 131;
		}

		@Override
		public final int ENOTSOCK()
		{
			return 88;
		}

		@Override
		public Integer ENOTSUP()
		{
			return null;
		}

		@Override
		public final int ENOTTY()
		{
			return 25;
		}

		@Override
		public final Integer ENOTUNIQ()
		{
			return 76;
		}

		@Override
		public final int ENXIO()
		{
			return 6;
		}

		@Override
		public final int EOPNOTSUPP()
		{
			return 95;
		}

		@Override
		public final int EOVERFLOW()
		{
			return 75;
		}

		@Override
		public final Integer EOWNERDEAD()
		{
			return 130;
		}

		@Override
		public final int EPERM()
		{
			return 1;
		}

		@Override
		public final int EPFNOSUPPORT()
		{
			return 96;
		}

		@Override
		public final int EPIPE()
		{
			return 32;
		}

		@Override
		public Integer EPROCLIM()
		{
			return null;
		}

		@Override
		public Integer EPROCUNAVAIL()
		{
			return null;
		}

		@Override
		public Integer EPROGMISMATCH()
		{
			return null;
		}

		@Override
		public Integer EPROGUNAVAIL()
		{
			return null;
		}

		@Override
		public final int EPROTO()
		{
			return 71;
		}

		@Override
		public final int EPROTONOSUPPORT()
		{
			return 93;
		}

		@Override
		public final int EPROTOTYPE()
		{
			return 91;
		}

		@Override
		public final int ERANGE()
		{
			return 34;
		}

		@Override
		public final Integer EREMCHG()
		{
			return 78;
		}

		@Override
		public final int EREMOTE()
		{
			return 66;
		}

		@Override
		public final Integer EREMOTEIO()
		{
			return 121;
		}

		@Override
		public final Integer ERESTART()
		{
			return 85;
		}

		@Override
		public final int EROFS()
		{
			return 30;
		}

		@Override
		public Integer ERPCMISMATCH()
		{
			return null;
		}

		@Override
		public final int ESHUTDOWN()
		{
			return 108;
		}

		@Override
		public final int ESOCKTNOSUPPORT()
		{
			return 94;
		}

		@Override
		public final int ESPIPE()
		{
			return 29;
		}

		@Override
		public final int ESRCH()
		{
			return 3;
		}

		@Override
		public final Integer ESRMNT()
		{
			return 69;
		}

		@Override
		public final int ESTALE()
		{
			return 116;
		}

		@Override
		public final Integer ESTRPIPE()
		{
			return 86;
		}

		@Override
		public final Integer ETIME()
		{
			return 62;
		}

		@Override
		public final int ETIMEDOUT()
		{
			return 110;
		}

		@Override
		public final int ETOOMANYREFS()
		{
			return 109;
		}

		@Override
		public final int ETXTBSY()
		{
			return 26;
		}

		@Override
		public final Integer EUCLEAN()
		{
			return 117;
		}

		@Override
		public final Integer EUNATCH()
		{
			return 49;
		}

		@Override
		public final int EUSERS()
		{
			return 87;
		}

		@Override
		public final int EWOULDBLOCK()
		{
			return EAGAIN();
		}

		@Override
		public final int EXDEV()
		{
			return 18;
		}

		@Override
		public final Integer EXFULL()
		{
			return 54;
		}
	}

	private static interface IErrorCodes
	{
		public int E2BIG();

		public int EACCES();

		public int EADDRINUSE();

		public int EADDRNOTAVAIL();

		public Integer EADV();

		public int EAFNOSUPPORT();

		public int EAGAIN();

		public int EALREADY();

		public Integer EAUTH();

		public Integer EBADE();

		public int EBADF();

		public Integer EBADFD();

		public int EBADMSG();

		public Integer EBADR();

		public Integer EBADRPC();

		public Integer EBADRQC();

		public Integer EBADSLT();

		public Integer EBFONT();

		public int EBUSY();

		public int ECANCELED();

		public int ECHILD();

		public Integer ECHRNG();

		public Integer ECOMM();

		public int ECONNABORTED();

		public int ECONNREFUSED();

		public int ECONNRESET();

		public int EDEADLK();

		public Integer EDEADLOCK();

		public int EDESTADDRREQ();

		public int EDOM();

		public Integer EDOOFUS();

		public Integer EDOTDOT();

		public int EDQUOT();

		public int EEXIST();

		public int EFAULT();

		public int EFBIG();

		public Integer EFTYPE();

		public int EHOSTDOWN();

		public int EHOSTUNREACH();

		public int EIDRM();

		public int EILSEQ();

		public int EINPROGRESS();

		public int EINTR();

		public int EINVAL();

		public int EIO();

		public int EISCONN();

		public int EISDIR();

		public Integer EISNAM();

		public Integer EKEYEXPIRED();

		public Integer EKEYREJECTED();

		public Integer EKEYREVOKED();

		public Integer EL2HLT();

		public Integer EL2NSYNC();

		public Integer EL3HLT();

		public Integer EL3RST();

		public Integer ELAST();

		public Integer ELIBACC();

		public Integer ELIBBAD();

		public Integer ELIBEXEC();

		public Integer ELIBMAX();

		public Integer ELIBSCN();

		public Integer ELNRNG();

		public int ELOOP();

		public Integer EMEDIUMTYPE();

		public int EMFILE();

		public int EMLINK();

		public int EMSGSIZE();

		public int EMULTIHOP();

		public int ENAMETOOLONG();

		public Integer ENAVAIL();

		public Integer ENEEDAUTH();

		public int ENETDOWN();

		public int ENETRESET();

		public int ENETUNREACH();

		public int ENFILE();

		public Integer ENOANO();

		public Integer ENOATTR();

		public int ENOBUFS();

		public Integer ENOCSI();

		public Integer ENODATA();

		public int ENODEV();

		public int ENOENT();

		public int ENOEXEC();

		public Integer ENOKEY();

		public int ENOLCK();

		public int ENOLINK();

		public Integer ENOMEDIUM();

		public int ENOMEM();

		public int ENOMSG();

		public Integer ENONET();

		public Integer ENOPKG();

		public int ENOPROTOOPT();

		public int ENOSPC();

		public Integer ENOSR();

		public Integer ENOSTR();

		public int ENOSYS();

		public int ENOTBLK();

		public Integer ENOTCAPABLE();

		public int ENOTCONN();

		public int ENOTDIR();

		public int ENOTEMPTY();

		public Integer ENOTNAM();

		public Integer ENOTRECOVERABLE();

		public int ENOTSOCK();

		public Integer ENOTSUP();

		public int ENOTTY();

		public Integer ENOTUNIQ();

		public int ENXIO();

		public int EOPNOTSUPP();

		public int EOVERFLOW();

		public Integer EOWNERDEAD();

		public int EPERM();

		public int EPFNOSUPPORT();

		public int EPIPE();

		public Integer EPROCLIM();

		public Integer EPROCUNAVAIL();

		public Integer EPROGMISMATCH();

		public Integer EPROGUNAVAIL();

		public int EPROTO();

		public int EPROTONOSUPPORT();

		public int EPROTOTYPE();

		public int ERANGE();

		public Integer EREMCHG();

		public int EREMOTE();

		public Integer EREMOTEIO();

		public Integer ERESTART();

		public int EROFS();

		public Integer ERPCMISMATCH();

		public int ESHUTDOWN();

		public int ESOCKTNOSUPPORT();

		public int ESPIPE();

		public int ESRCH();

		public Integer ESRMNT();

		public int ESTALE();

		public Integer ESTRPIPE();

		public Integer ETIME();

		public int ETIMEDOUT();

		public int ETOOMANYREFS();

		public int ETXTBSY();

		public Integer EUCLEAN();

		public Integer EUNATCH();

		public int EUSERS();

		public int EWOULDBLOCK();

		public int EXDEV();

		public Integer EXFULL();
	}

	private static IErrorCodes platformErrorCodes = null;

	/**
	 * Argument list too long
	 */
	public static final int E2BIG()
	{
		return getPlatformErrorCodes().E2BIG();
	}

	/**
	 * Permission denied
	 */
	public static final int EACCES()
	{
		return getPlatformErrorCodes().EACCES();
	}

	/**
	 * Address already in use
	 */
	public static final int EADDRINUSE()
	{
		return getPlatformErrorCodes().EADDRINUSE();
	}

	/**
	 * Can't assign requested address
	 */
	public static final int EADDRNOTAVAIL()
	{
		return getPlatformErrorCodes().EADDRNOTAVAIL();
	}

	/**
	 * Advertise error
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EADV()
	{
		return getPlatformErrorCodes().EADV();
	}

	/**
	 * Address family not supported by protocol family
	 */
	public static final int EAFNOSUPPORT()
	{
		return getPlatformErrorCodes().EAFNOSUPPORT();
	}

	/**
	 * Resource temporarily unavailable
	 */
	public static final int EAGAIN()
	{
		return getPlatformErrorCodes().EAGAIN();
	}

	/**
	 * Operation already in progress
	 */
	public static final int EALREADY()
	{
		return getPlatformErrorCodes().EALREADY();
	}

	/**
	 * Authentication error
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EAUTH()
	{
		return getPlatformErrorCodes().EAUTH();
	}

	/**
	 * Invalid exchange
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBADE()
	{
		return getPlatformErrorCodes().EBADE();
	}

	/**
	 * Bad file descriptor
	 */
	public static final int EBADF()
	{
		return getPlatformErrorCodes().EBADF();
	}

	/**
	 * File descriptor in bad state
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBADFD()
	{
		return getPlatformErrorCodes().EBADFD();
	}

	/**
	 * Bad message
	 */
	public static final int EBADMSG()
	{
		return getPlatformErrorCodes().EBADMSG();
	}

	/**
	 * Invalid request descriptor
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBADR()
	{
		return getPlatformErrorCodes().EBADR();
	}

	/**
	 * RPC struct is bad
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EBADRPC()
	{
		return getPlatformErrorCodes().EBADRPC();
	}

	/**
	 * Invalid request code
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBADRQC()
	{
		return getPlatformErrorCodes().EBADRQC();
	}

	/**
	 * Invalid slot
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBADSLT()
	{
		return getPlatformErrorCodes().EBADSLT();
	}

	/**
	 * Bad font file format
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EBFONT()
	{
		return getPlatformErrorCodes().EBFONT();
	}

	/**
	 * Device busy
	 */
	public static final int EBUSY()
	{
		return getPlatformErrorCodes().EBUSY();
	}

	/**
	 * Operation canceled
	 */
	public static final int ECANCELED()
	{
		return getPlatformErrorCodes().ECANCELED();
	}

	/**
	 * No child processes
	 */
	public static final int ECHILD()
	{
		return getPlatformErrorCodes().ECHILD();
	}

	/**
	 * Channel number out of range
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ECHRNG()
	{
		return getPlatformErrorCodes().ECHRNG();
	}

	/**
	 * Communication error on send
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ECOMM()
	{
		return getPlatformErrorCodes().ECOMM();
	}

	/**
	 * Software caused connection abort
	 */
	public static final int ECONNABORTED()
	{
		return getPlatformErrorCodes().ECONNABORTED();
	}

	/**
	 * Connection refused
	 */
	public static final int ECONNREFUSED()
	{
		return getPlatformErrorCodes().ECONNREFUSED();
	}

	/**
	 * Connection reset by peer
	 */
	public static final int ECONNRESET()
	{
		return getPlatformErrorCodes().ECONNRESET();
	}

	/**
	 * Resource deadlock avoided
	 */
	public static final int EDEADLK()
	{
		return getPlatformErrorCodes().EDEADLK();
	}

	/**
	 * Resource deadlock avoided
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EDEADLOCK()
	{
		return getPlatformErrorCodes().EDEADLOCK();
	}

	/**
	 * Destination address required
	 */
	public static final int EDESTADDRREQ()
	{
		return getPlatformErrorCodes().EDESTADDRREQ();
	}

	/**
	 * Numerical argument out of domain
	 */
	public static final int EDOM()
	{
		return getPlatformErrorCodes().EDOM();
	}

	/**
	 * Programming error
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EDOOFUS()
	{
		return getPlatformErrorCodes().EDOOFUS();
	}

	/**
	 * RFS specific error
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EDOTDOT()
	{
		return getPlatformErrorCodes().EDOTDOT();
	}

	/**
	 * Disc quota exceeded
	 */
	public static final int EDQUOT()
	{
		return getPlatformErrorCodes().EDQUOT();
	}

	/**
	 * File exists
	 */
	public static final int EEXIST()
	{
		return getPlatformErrorCodes().EEXIST();
	}

	/**
	 * Bad address
	 */
	public static final int EFAULT()
	{
		return getPlatformErrorCodes().EFAULT();
	}

	/**
	 * File too large
	 */
	public static final int EFBIG()
	{
		return getPlatformErrorCodes().EFBIG();
	}

	/**
	 * Inappropriate file type or format
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EFTYPE()
	{
		return getPlatformErrorCodes().EFTYPE();
	}

	/**
	 * Host is down
	 */
	public static final int EHOSTDOWN()
	{
		return getPlatformErrorCodes().EHOSTDOWN();
	}

	/**
	 * No route to host
	 */
	public static final int EHOSTUNREACH()
	{
		return getPlatformErrorCodes().EHOSTUNREACH();
	}

	/**
	 * Identifier removed
	 */
	public static final int EIDRM()
	{
		return getPlatformErrorCodes().EIDRM();
	}

	/**
	 * Illegal byte sequence
	 */
	public static final int EILSEQ()
	{
		return getPlatformErrorCodes().EILSEQ();
	}

	/**
	 * Operation now in progress
	 */
	public static final int EINPROGRESS()
	{
		return getPlatformErrorCodes().EINPROGRESS();
	}

	/**
	 * Interrupted system call
	 */
	public static final int EINTR()
	{
		return getPlatformErrorCodes().EINTR();
	}

	/**
	 * Invalid argument
	 */
	public static final int EINVAL()
	{
		return getPlatformErrorCodes().EINVAL();
	}

	/**
	 * Input/output error
	 */
	public static final int EIO()
	{
		return getPlatformErrorCodes().EIO();
	}

	/**
	 * Socket is already connected
	 */
	public static final int EISCONN()
	{
		return getPlatformErrorCodes().EISCONN();
	}

	/**
	 * Is a directory
	 */
	public static final int EISDIR()
	{
		return getPlatformErrorCodes().EISDIR();
	}

	/**
	 * Is a named type file
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EISNAM()
	{
		return getPlatformErrorCodes().EISNAM();
	}

	/**
	 * Key has expired
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EKEYEXPIRED()
	{
		return getPlatformErrorCodes().EKEYEXPIRED();
	}

	/**
	 * Key was rejected by service
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EKEYREJECTED()
	{
		return getPlatformErrorCodes().EKEYREJECTED();
	}

	/**
	 * Key has been revoked
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EKEYREVOKED()
	{
		return getPlatformErrorCodes().EKEYREVOKED();
	}

	/**
	 * Level 2 halted
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EL2HLT()
	{
		return getPlatformErrorCodes().EL2HLT();
	}

	/**
	 * Level 2 not synchronized
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EL2NSYNC()
	{
		return getPlatformErrorCodes().EL2NSYNC();
	}

	/**
	 * Level 3 halted
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EL3HLT()
	{
		return getPlatformErrorCodes().EL3HLT();
	}

	/**
	 * Level 3 reset
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EL3RST()
	{
		return getPlatformErrorCodes().EL3RST();
	}

	/**
	 * Must be equal largest errno
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ELAST()
	{
		return getPlatformErrorCodes().ELAST();
	}

	/**
	 * Can not access a needed shared library
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELIBACC()
	{
		return getPlatformErrorCodes().ELIBACC();
	}

	/**
	 * Accessing a corrupted shared library
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELIBBAD()
	{
		return getPlatformErrorCodes().ELIBBAD();
	}

	/**
	 * Cannot exec a shared library directly
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELIBEXEC()
	{
		return getPlatformErrorCodes().ELIBEXEC();
	}

	/**
	 * Attempting to link in too many shared libraries
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELIBMAX()
	{
		return getPlatformErrorCodes().ELIBMAX();
	}

	/**
	 * .lib section in a.out corrupted
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELIBSCN()
	{
		return getPlatformErrorCodes().ELIBSCN();
	}

	/**
	 * Link number out of range
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ELNRNG()
	{
		return getPlatformErrorCodes().ELNRNG();
	}

	/**
	 * Too many levels of symbolic links
	 */
	public static final int ELOOP()
	{
		return getPlatformErrorCodes().ELOOP();
	}

	/**
	 * Wrong medium type
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EMEDIUMTYPE()
	{
		return getPlatformErrorCodes().EMEDIUMTYPE();
	}

	/**
	 * Too many open files
	 */
	public static final int EMFILE()
	{
		return getPlatformErrorCodes().EMFILE();
	}

	/**
	 * Too many links
	 */
	public static final int EMLINK()
	{
		return getPlatformErrorCodes().EMLINK();
	}

	/**
	 * Message too long
	 */
	public static final int EMSGSIZE()
	{
		return getPlatformErrorCodes().EMSGSIZE();
	}

	/**
	 * Multihop attempted
	 */
	public static final int EMULTIHOP()
	{
		return getPlatformErrorCodes().EMULTIHOP();
	}

	/**
	 * File name too long
	 */
	public static final int ENAMETOOLONG()
	{
		return getPlatformErrorCodes().ENAMETOOLONG();
	}

	/**
	 * No XENIX semaphores available
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENAVAIL()
	{
		return getPlatformErrorCodes().ENAVAIL();
	}

	/**
	 * Need authenticator
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ENEEDAUTH()
	{
		return getPlatformErrorCodes().ENEEDAUTH();
	}

	/**
	 * Network is down
	 */
	public static final int ENETDOWN()
	{
		return getPlatformErrorCodes().ENETDOWN();
	}

	/**
	 * Network dropped connection on reset
	 */
	public static final int ENETRESET()
	{
		return getPlatformErrorCodes().ENETRESET();
	}

	/**
	 * Network is unreachable
	 */
	public static final int ENETUNREACH()
	{
		return getPlatformErrorCodes().ENETUNREACH();
	}

	/**
	 * Too many open files in system
	 */
	public static final int ENFILE()
	{
		return getPlatformErrorCodes().ENFILE();
	}

	/**
	 * No anode
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOANO()
	{
		return getPlatformErrorCodes().ENOANO();
	}

	/**
	 * Attribute not found
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ENOATTR()
	{
		return getPlatformErrorCodes().ENOATTR();
	}

	/**
	 * No buffer space available
	 */
	public static final int ENOBUFS()
	{
		return getPlatformErrorCodes().ENOBUFS();
	}

	/**
	 * No CSI structure available
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOCSI()
	{
		return getPlatformErrorCodes().ENOCSI();
	}

	/**
	 * No data available
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENODATA()
	{
		return getPlatformErrorCodes().ENODATA();
	}

	/**
	 * Operation not supported by device
	 */
	public static final int ENODEV()
	{
		return getPlatformErrorCodes().ENODEV();
	}

	/**
	 * No such file or directory
	 */
	public static final int ENOENT()
	{
		return getPlatformErrorCodes().ENOENT();
	}

	/**
	 * Exec format error
	 */
	public static final int ENOEXEC()
	{
		return getPlatformErrorCodes().ENOEXEC();
	}

	/**
	 * Required key not available
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOKEY()
	{
		return getPlatformErrorCodes().ENOKEY();
	}

	/**
	 * No locks available
	 */
	public static final int ENOLCK()
	{
		return getPlatformErrorCodes().ENOLCK();
	}

	/**
	 * Link has been severed
	 */
	public static final int ENOLINK()
	{
		return getPlatformErrorCodes().ENOLINK();
	}

	/**
	 * No medium found
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOMEDIUM()
	{
		return getPlatformErrorCodes().ENOMEDIUM();
	}

	/**
	 * Cannot allocate memory
	 */
	public static final int ENOMEM()
	{
		return getPlatformErrorCodes().ENOMEM();
	}

	/**
	 * No message of desired type
	 */
	public static final int ENOMSG()
	{
		return getPlatformErrorCodes().ENOMSG();
	}

	/**
	 * Machine is not on the network
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENONET()
	{
		return getPlatformErrorCodes().ENONET();
	}

	/**
	 * Package not installed
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOPKG()
	{
		return getPlatformErrorCodes().ENOPKG();
	}

	/**
	 * Protocol not available
	 */
	public static final int ENOPROTOOPT()
	{
		return getPlatformErrorCodes().ENOPROTOOPT();
	}

	/**
	 * No space left on device
	 */
	public static final int ENOSPC()
	{
		return getPlatformErrorCodes().ENOSPC();
	}

	/**
	 * Out of streams resources
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOSR()
	{
		return getPlatformErrorCodes().ENOSR();
	}

	/**
	 * Device not a stream
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOSTR()
	{
		return getPlatformErrorCodes().ENOSTR();
	}

	/**
	 * Function not implemented
	 */
	public static final int ENOSYS()
	{
		return getPlatformErrorCodes().ENOSYS();
	}

	/**
	 * Block device required
	 */
	public static final int ENOTBLK()
	{
		return getPlatformErrorCodes().ENOTBLK();
	}

	/**
	 * Capabilities insufficient
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ENOTCAPABLE()
	{
		return getPlatformErrorCodes().ENOTCAPABLE();
	}

	/**
	 * Socket is not connected
	 */
	public static final int ENOTCONN()
	{
		return getPlatformErrorCodes().ENOTCONN();
	}

	/**
	 * Not a directory
	 */
	public static final int ENOTDIR()
	{
		return getPlatformErrorCodes().ENOTDIR();
	}

	/**
	 * Directory not empty
	 */
	public static final int ENOTEMPTY()
	{
		return getPlatformErrorCodes().ENOTEMPTY();
	}

	/**
	 * Not a XENIX named type file
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOTNAM()
	{
		return getPlatformErrorCodes().ENOTNAM();
	}

	/**
	 * State not recoverable
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOTRECOVERABLE()
	{
		return getPlatformErrorCodes().ENOTRECOVERABLE();
	}

	/**
	 * Socket operation on non-socket
	 */
	public static final int ENOTSOCK()
	{
		return getPlatformErrorCodes().ENOTSOCK();
	}

	/**
	 * Operation not supported
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ENOTSUP()
	{
		return getPlatformErrorCodes().ENOTSUP();
	}

	/**
	 * Inappropriate ioctl for device
	 */
	public static final int ENOTTY()
	{
		return getPlatformErrorCodes().ENOTTY();
	}

	/**
	 * Name not unique on network
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ENOTUNIQ()
	{
		return getPlatformErrorCodes().ENOTUNIQ();
	}

	/**
	 * Device not configured
	 */
	public static final int ENXIO()
	{
		return getPlatformErrorCodes().ENXIO();
	}

	/**
	 * Operation not supported
	 */
	public static final int EOPNOTSUPP()
	{
		return getPlatformErrorCodes().EOPNOTSUPP();
	}

	/**
	 * Value too large to be stored in data type
	 */
	public static final int EOVERFLOW()
	{
		return getPlatformErrorCodes().EOVERFLOW();
	}

	/**
	 * Owner died
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EOWNERDEAD()
	{
		return getPlatformErrorCodes().EOWNERDEAD();
	}

	/**
	 * Operation not permitted
	 */
	public static final int EPERM()
	{
		return getPlatformErrorCodes().EPERM();
	}

	/**
	 * Protocol family not supported
	 */
	public static final int EPFNOSUPPORT()
	{
		return getPlatformErrorCodes().EPFNOSUPPORT();
	}

	/**
	 * Broken pipe
	 */
	public static final int EPIPE()
	{
		return getPlatformErrorCodes().EPIPE();
	}

	/**
	 * Too many processes
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EPROCLIM()
	{
		return getPlatformErrorCodes().EPROCLIM();
	}

	/**
	 * Bad procedure for program
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EPROCUNAVAIL()
	{
		return getPlatformErrorCodes().EPROCUNAVAIL();
	}

	/**
	 * Program version wrong
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EPROGMISMATCH()
	{
		return getPlatformErrorCodes().EPROGMISMATCH();
	}

	/**
	 * RPC prog. not avail
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer EPROGUNAVAIL()
	{
		return getPlatformErrorCodes().EPROGUNAVAIL();
	}

	/**
	 * Protocol error
	 */
	public static final int EPROTO()
	{
		return getPlatformErrorCodes().EPROTO();
	}

	/**
	 * Protocol not supported
	 */
	public static final int EPROTONOSUPPORT()
	{
		return getPlatformErrorCodes().EPROTONOSUPPORT();
	}

	/**
	 * Protocol wrong type for socket
	 */
	public static final int EPROTOTYPE()
	{
		return getPlatformErrorCodes().EPROTOTYPE();
	}

	/**
	 * Result too large
	 */
	public static final int ERANGE()
	{
		return getPlatformErrorCodes().ERANGE();
	}

	/**
	 * Remote address changed
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EREMCHG()
	{
		return getPlatformErrorCodes().EREMCHG();
	}

	/**
	 * Too many levels of remote in path
	 */
	public static final int EREMOTE()
	{
		return getPlatformErrorCodes().EREMOTE();
	}

	/**
	 * Remote I/O error
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EREMOTEIO()
	{
		return getPlatformErrorCodes().EREMOTEIO();
	}

	/**
	 * Interrupted system call should be restarted
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ERESTART()
	{
		return getPlatformErrorCodes().ERESTART();
	}

	/**
	 * Read-only file system
	 */
	public static final int EROFS()
	{
		return getPlatformErrorCodes().EROFS();
	}

	/**
	 * RPC version wrong
	 * 
	 * @return null on Linux (not defined)
	 */
	public static final Integer ERPCMISMATCH()
	{
		return getPlatformErrorCodes().ERPCMISMATCH();
	}

	/**
	 * Can't send after socket shutdown
	 */
	public static final int ESHUTDOWN()
	{
		return getPlatformErrorCodes().ESHUTDOWN();
	}

	/**
	 * Socket type not supported
	 */
	public static final int ESOCKTNOSUPPORT()
	{
		return getPlatformErrorCodes().ESOCKTNOSUPPORT();
	}

	/**
	 * Illegal seek
	 */
	public static final int ESPIPE()
	{
		return getPlatformErrorCodes().ESPIPE();
	}

	/**
	 * No such process
	 */
	public static final int ESRCH()
	{
		return getPlatformErrorCodes().ESRCH();
	}

	/**
	 * Srmount error
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ESRMNT()
	{
		return getPlatformErrorCodes().ESRMNT();
	}

	/**
	 * Stale NFS file handle
	 */
	public static final int ESTALE()
	{
		return getPlatformErrorCodes().ESTALE();
	}

	/**
	 * Streams pipe error
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ESTRPIPE()
	{
		return getPlatformErrorCodes().ESTRPIPE();
	}

	/**
	 * Timer expired
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer ETIME()
	{
		return getPlatformErrorCodes().ETIME();
	}

	/**
	 * Operation timed out
	 */
	public static final int ETIMEDOUT()
	{
		return getPlatformErrorCodes().ETIMEDOUT();
	}

	/**
	 * Too many references: can't splice
	 */
	public static final int ETOOMANYREFS()
	{
		return getPlatformErrorCodes().ETOOMANYREFS();
	}

	/**
	 * Text file busy
	 */
	public static final int ETXTBSY()
	{
		return getPlatformErrorCodes().ETXTBSY();
	}

	/**
	 * Structure needs cleaning
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EUCLEAN()
	{
		return getPlatformErrorCodes().EUCLEAN();
	}

	/**
	 * Protocol driver not attached
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EUNATCH()
	{
		return getPlatformErrorCodes().EUNATCH();
	}

	/**
	 * Too many users
	 */
	public static final int EUSERS()
	{
		return getPlatformErrorCodes().EUSERS();
	}

	/**
	 * Operation would block
	 */
	public static final int EWOULDBLOCK()
	{
		return getPlatformErrorCodes().EWOULDBLOCK();
	}

	/**
	 * Cross-device link
	 */
	public static final int EXDEV()
	{
		return getPlatformErrorCodes().EXDEV();
	}

	/**
	 * Exchange full
	 * 
	 * @return null on BSD (not defined)
	 */
	public static final Integer EXFULL()
	{
		return getPlatformErrorCodes().EXFULL();
	}

	private static final IErrorCodes getPlatformErrorCodes()
	{
		if (platformErrorCodes == null) {
			switch (Platform.platform()) {
				case FREEBSD:
				case MAC:
				case MAC_MACFUSE:
					platformErrorCodes = new ErrorCodes.ErrorCodesBSD();
					break;
				default:
					platformErrorCodes = new ErrorCodes.ErrorCodesLinux();
			}
		}
		return platformErrorCodes;
	}
}
