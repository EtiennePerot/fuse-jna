package net.fusejna;

import java.io.File;
import java.util.regex.Pattern;

public abstract class FuseFilesystem
{
	private static final String defaultFilesystemName = "userfs";
	private static final Pattern regexNormalizeFilesystemName = Pattern.compile("[a-zA-Z]");

	final String getFuseName()
	{
		String name = getName();
		if (name == null) {
			return defaultFilesystemName;
		}
		name = regexNormalizeFilesystemName.matcher(name).replaceAll("");
		if (name.isEmpty()) {
			return defaultFilesystemName;
		}
		return name.toLowerCase();
	}

	protected abstract String getName();

	protected abstract String[] getOptions();

	public final void mount(final File mountPoint) throws InvalidMountpointException, UnsatisfiedLinkError, FuseException
	{
		FuseJna.mount(this, mountPoint);
	}

	public final void mount(final String mountPoint) throws InvalidMountpointException, UnsatisfiedLinkError, FuseException
	{
		mount(new File(mountPoint));
	}
}
