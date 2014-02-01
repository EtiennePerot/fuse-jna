package net.fusejna.examples;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.fusejna.ErrorCodes;
import net.fusejna.FuseException;
import net.fusejna.XattrFiller;
import net.fusejna.XattrListFiller;

public final class XattrExampleFS extends HelloFS
{
	public static void main(final String... args) throws FuseException
	{
		if (args.length != 1) {
			System.err.println("Usage: XattrExampleFS <mountpoint>");
			System.exit(1);
		}
		new XattrExampleFS().log(true).mount(args[0]);
	}

	private final Map<String, byte[]> helloTxtAttrs = new HashMap<String, byte[]>();

	@Override
	public int getxattr(final String path, final String xattr, final XattrFiller filler, final long size, final long position)
	{
		if (!path.equals(filename)) {
			return -ErrorCodes.firstNonNull(ErrorCodes.ENOATTR(), ErrorCodes.ENOATTR(), ErrorCodes.ENODATA());
		}
		if (!helloTxtAttrs.containsKey(xattr)) {
			return -ErrorCodes.firstNonNull(ErrorCodes.ENOATTR(), ErrorCodes.ENOATTR(), ErrorCodes.ENODATA());
		}
		filler.set(helloTxtAttrs.get(xattr));
		return 0;
	};

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
	public int removexattr(final String path, final String xattr)
	{
		if (!path.equals(filename)) {
			return -ErrorCodes.ENOTSUP();
		}
		if (!helloTxtAttrs.containsKey(xattr)) {
			return -ErrorCodes.ENOATTR();
		}
		helloTxtAttrs.remove(xattr);
		return 0;
	}

	@Override
	public int setxattr(final String path, final String xattr, final ByteBuffer buf, final long size, final int flags,
			final int position)
	{
		if (!path.equals(filename)) {
			return -ErrorCodes.ENOTSUP();
		}
		byte[] attr;
		if (!helloTxtAttrs.containsKey(xattr)) {
			attr = new byte[(int) (size + position)];
			helloTxtAttrs.put(xattr, attr);
		}
		else {
			attr = helloTxtAttrs.get(xattr);
			if (attr.length < size + position) {
				attr = Arrays.copyOf(attr, (int) (size + position));
			}
		}
		buf.get(attr, position, (int) size);
		return 0;
	}
}
