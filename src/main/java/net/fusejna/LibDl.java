package net.fusejna;

import com.sun.jna.Library;

public interface LibDl extends Library
{
	int RTLD_LAZY = 0x1;
	int RTLD_NOW = 0x2;
	int RTLD_GLOBAL = 0x100;

	void dlopen(String file, int mode);
}
