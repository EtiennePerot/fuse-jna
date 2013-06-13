package net.fusejna;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class XattrListFiller
{
	private final ByteBuffer buffer;
	private final long maxSize;
	private long currentSize = 0;
	private final Set<String> addedXattrs = new HashSet<String>();

	XattrListFiller(final ByteBuffer buffer, final long size)
	{
		this.buffer = buffer;
		maxSize = size;
	}

	public final boolean add(final Iterable<String> xattrs)
	{
		byte[] bytes;
		int size;
		boolean hasNullByte;
		for (final String xattr : xattrs) {
			if (addedXattrs.contains(xattr)) {
				continue;
			}
			if (currentSize >= maxSize) {
				return false;
			}
			bytes = xattr.getBytes();
			hasNullByte = bytes[bytes.length - 1] == 0;
			size = bytes.length + (hasNullByte ? 0 : 1);
			if (currentSize + size > maxSize) {
				return false;
			}
			addedXattrs.add(xattr);
			buffer.put(bytes);
			if (!hasNullByte) {
				buffer.put((byte) 0);
			}
			currentSize += size;
		}
		return true;
	}

	public final boolean add(final String... xattrs)
	{
		return add(Arrays.asList(xattrs));
	}

	@Override
	public String toString()
	{
		final StringBuilder output = new StringBuilder();
		int count = 0;
		for (final String xattr : addedXattrs) {
			output.append(xattr);
			if (count < addedXattrs.size() - 1) {
				output.append(", ");
			}
			count++;
		}
		return output.toString();
	}
}
