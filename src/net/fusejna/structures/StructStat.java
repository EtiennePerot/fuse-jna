package net.fusejna.structures;

import net.fusejna.types.TypeBlkCnt;
import net.fusejna.types.TypeBlkSize;
import net.fusejna.types.TypeDev;
import net.fusejna.types.TypeGid;
import net.fusejna.types.TypeIno;
import net.fusejna.types.TypeMode;
import net.fusejna.types.TypeNLink;
import net.fusejna.types.TypeOff;
import net.fusejna.types.TypeTime;
import net.fusejna.types.TypeUid;

import com.sun.jna.Structure;

public class StructStat extends Structure
{
	public static class ByReference extends StructStat implements Structure.ByReference
	{
	}

	public static class ByValue extends StructStat implements Structure.ByValue
	{
	}

	public TypeDev st_dev;
	public TypeIno st_ino;
	public TypeMode st_mode;
	public TypeNLink st_nlink;
	public TypeUid st_uid;
	public TypeGid st_gid;
	public TypeDev st_rdev;
	public TypeOff st_size;
	public TypeBlkSize st_blksize;
	public TypeBlkCnt st_blocks;
	public TypeTime st_atime;
	public TypeTime st_mtime;
	public TypeTime st_ctime;
}
