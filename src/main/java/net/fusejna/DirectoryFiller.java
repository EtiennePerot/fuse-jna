package net.fusejna;

/**
 * Base interface for the transfer-object for the readdir() call.
 * 
 * @author dominik.stadler
 */
public interface DirectoryFiller
{
	public boolean add(Iterable<String> files);

	public boolean add(String... files);
}
