package net.fusejna;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import net.fusejna.examples.NullFS;
import net.fusejna.structures.StructFuseContext;
import net.fusejna.structures.StructFuseOperations;
import net.fusejna.types.TypeSize;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

final class FuseJna
{
	private interface LibFuse extends Library
	{
		StructFuseContext fuse_get_context();

		int fuse_main_real(int argc, String[] argv, StructFuseOperations op, TypeSize size, Pointer user_data);
	}

	private static LibFuse libFuse = null;
	private static Lock libFuseLoadLock = new ReentrantLock();

	static LibFuse getFuse()
	{
		if (libFuse != null) {
			// No need to lock if everything is fine already
			return libFuse;
		}
		libFuseLoadLock.lock();
		if (libFuse == null) {
			Native.setProtected(true);
			libFuse = (LibFuse) Native.loadLibrary("fuse", LibFuse.class);
		}
		libFuseLoadLock.unlock();
		return libFuse;
	}

	public static void main(final String... args)
	{
		final LibFuse fuse = getFuse();
		final StructFuseOperations.ByReference operations = new StructFuseOperations.ByReference(new NullFS());
		final Charset utf8 = Charset.forName("UTF-8");
		final CharsetEncoder utf8encoder = utf8.newEncoder();
		final ByteBuffer[] argv = new ByteBuffer[args.length];
		try {
			for (int i = 0; i < args.length; i++) {
				utf8encoder.reset();
				argv[i] = utf8encoder.encode(CharBuffer.wrap(args[i]));
			}
		}
		catch (final CharacterCodingException e) {
			// Not gonna happen
		}
		fuse.fuse_main_real(args.length, args, operations, new TypeSize(operations.size()), null);
		System.err.println("Mounted");
		try {
			Thread.sleep(10000);
		}
		catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
