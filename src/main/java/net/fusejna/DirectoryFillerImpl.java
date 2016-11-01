package net.fusejna;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.jna.Function;
import com.sun.jna.Pointer;

import net.fusejna.Platform.PlatformEnum;
import net.fusejna.types.TypeOff;

/**
 * A class which provides functionality to pass filenames back to FUSE as part of a readdir() call.
 */
public final class DirectoryFillerImpl implements DirectoryFiller
{
	private static final int maxMacOSXFilenameLength = 255;
	private static final String currentDirectory = ".";
	private static final String parentDirectory = "..";
	private final Pointer buf;
	private final Function nativeFunction;
	private final Set<String> addedFiles = new HashSet<String>();

	DirectoryFillerImpl(final Pointer buf, final Function nativeFunction)
	{
		this.buf = buf;
		this.nativeFunction = nativeFunction;
		add(currentDirectory, parentDirectory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean add(final Iterable<String> files)
	{
		int result;
		for (String file : files) {
			if (file == null) {
				continue;
			}
			if (file.contains(File.separator)) {
				file = new File(file).getName(); // Keep only the name component
			}
			if ((Platform.platform().equals(PlatformEnum.MAC) || Platform.platform().equals(PlatformEnum.MAC_MACFUSE))
					&& file.length() > maxMacOSXFilenameLength) {
				return false;
			}
			if (addedFiles.add(file)) {
				final Object[] args = { buf, file, null, new TypeOff(0L) };
				result = nativeFunction.invokeInt(args);
				if (result != 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean add(final String... files)
	{
		return add(Arrays.asList(files));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		final StringBuilder output = new StringBuilder();
		int count = 0;
		for (final String file : addedFiles) {
			output.append(file);
			if (count < addedFiles.size() - 1) {
				output.append(", ");
			}
			count++;
		}
		return output.toString();
	}
}
