package net.fusejna;

/**
 * Base interface for the transfer-object for the readdir() call.
 */
public interface DirectoryFiller
{
	/**
	 * Pass the given files to the FUSE interfaces.
	 * 
	 * @param files
	 *            A list of filenames without directory.
	 * @return true if the operation succeeds, false if a problem happens when passing any of the files to FUSE.
	 */
	public boolean add(Iterable<String> files);

	/**
	 * Pass the given files to the FUSE interfaces.
	 * 
	 * @param files
	 *            A vararg-array of filenames without directory.
	 * @return true if the operation succeeds, false if a problem happens when passing any of the files to FUSE.
	 */
	public boolean add(String... files);
}
