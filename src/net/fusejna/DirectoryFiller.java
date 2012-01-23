package net.fusejna;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.jna.Function;
import com.sun.jna.Pointer;

public final class DirectoryFiller
{
	private static final String currentDirectory = ".";
	private static final String parentDirectory = "..";
	private final Pointer buf;
	private final Function nativeFunction;
	private final Set<String> addedFiles = new HashSet<String>();

	DirectoryFiller(final Pointer buf, final Function nativeFunction)
	{
		this.buf = buf;
		this.nativeFunction = nativeFunction;
		add(currentDirectory, parentDirectory);
	}

	public final boolean add(final Iterable<String> files)
	{
		int result;
		for (final String file : files) {
			if (addedFiles.add(file)) {
				final Object[] args = { buf, file, null, 0 };
				result = nativeFunction.invokeInt(args);
				if (result != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public final boolean add(final String... files)
	{
		return add(Arrays.asList(files));
	}
}
