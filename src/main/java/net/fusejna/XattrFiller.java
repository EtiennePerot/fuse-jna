package net.fusejna;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class XattrFiller
{
	private final ByteBuffer buffer;
	private final long maxSize;
	private final int position;
	private byte[] value = null;
	private boolean isSet = false;

	XattrFiller(final ByteBuffer buffer, final long size, final int position)
	{
		this.buffer = buffer;
		maxSize = size;
		this.position = position;
	}

	long getSize()
	{
		return value == null ? 0 : value.length;
	}

	public final void set(byte[] value)
	{
		if (buffer != null && value != null) {
			if (isSet) {
				throw new IllegalStateException("Cannot set the xattr twice.");
			}
			isSet = true;
			if (value.length > position + maxSize) {
				value = Arrays.copyOf(value, position + (int) maxSize);
			}
			buffer.put(value, position, value.length);
		}
		this.value = value;
	}
}
