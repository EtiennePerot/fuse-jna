package net.fusejna;

public enum FlockCommand
{
	GET_LOCK, SET_LOCK, SET_LOCK_WRITE;
	public static final int F_GETLK = 5;
	public static final int F_SETLK = 6;
	public static final int F_SETLKW = 7;

	public static FlockCommand fromBits(final long bits)
	{
		switch ((int) bits) {
			case F_GETLK:
				return GET_LOCK;
			case F_SETLK:
				return SET_LOCK;
			case F_SETLKW:
				return SET_LOCK_WRITE;
		}
		return null;
	}

	public long getBits()
	{
		switch (this) {
			case GET_LOCK:
				return F_GETLK;
			case SET_LOCK:
				return F_SETLK;
			case SET_LOCK_WRITE:
				return F_SETLKW;
		}
		return -1;
	}
}
