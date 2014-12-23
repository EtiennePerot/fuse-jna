package net.fusejna.examples


import java.util.Map
import java.util.Arrays
import java.util.HashMap
import java.nio.ByteBuffer
import net.fusejna.DirectoryFiller
import net.fusejna.ErrorCodes
import net.fusejna.FuseException
import net.fusejna.StructFuseFileInfo.FileInfoWrapper
import net.fusejna.StructStat.StatWrapper
import net.fusejna.types.TypeMode.NodeType
import net.fusejna.util.FuseFilesystemAdapterFull
import net.fusejna.XattrFiller
import net.fusejna.XattrListFiller

public class GroovyFS extends FuseFilesystemAdapterFull
{
	public static void main(final String... args) throws FuseException
	{
		if (args.length != 1) {
			System.err.println("Usage: GroovyFS <mountpoint>");
			System.exit(1);
		}
		new GroovyFS().log(true).mount(args[0]);
	}

	def slurper = new groovy.json.JsonSlurper()
	def helloTxtAttrs = slurper.parseText '''
	{
		"user.attr1" : "xattr 1 value",
		"user.attr2" : "xattr 2 value",
		"user.attr3" : "xattr 3 value"
	}'''
	final String filename = "/psaux.txt"
	String contents = "ps aux".execute().text

	@Override
	public int getattr(final String path, final StatWrapper stat)
	{
		if (path.equals(File.separator)) { // Root directory
			stat.setMode(NodeType.DIRECTORY);
			return 0;
		}
		if (path.equals(filename)) { // psaux.txt
			stat.setMode(NodeType.FILE).size(contents.length());
			return 0;
		}
		return -ErrorCodes.ENOENT();
	}
	@Override
	public int read(final String path, final ByteBuffer buffer, final long size, final long offset, final FileInfoWrapper info)
	{
		// Compute substring that we are being asked to read
		final String s = contents.substring((int) offset,
			(int) Math.max(offset, Math.min(contents.length() - offset, offset + size)));
		buffer.put(s.getBytes());
		return s.getBytes().length;
	}
	@Override
	public int readdir(final String path, final DirectoryFiller filler)
	{
		filler.add(filename);
		return 0;
	}
	@Override
	public int listxattr(final String path, final XattrListFiller filler)
	{
		if (!path.equals(filename)) {
			return -ErrorCodes.ENOTSUP();
		}
		filler.add(helloTxtAttrs.keySet());
		return 0;
	}
	@Override
	public int getxattr(final String path, final String xattr, final XattrFiller filler,  final long size, final long position)
	{
		if (!path.equals(filename)) {
			return -ErrorCodes.firstNonNull(ErrorCodes.ENOATTR(), ErrorCodes.ENOATTR(), ErrorCodes.ENODATA());
		}
		if (!helloTxtAttrs.containsKey(xattr)) {
			return -ErrorCodes.firstNonNull(ErrorCodes.ENOATTR(), ErrorCodes.ENOATTR(), ErrorCodes.ENODATA());
		}
		filler.set(helloTxtAttrs.get(xattr).getBytes());
		return 0;
	};
}

