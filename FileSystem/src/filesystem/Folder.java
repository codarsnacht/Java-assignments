package filesystem;

import java.util.ArrayList;


/**
 * @author conorhayes
 *
 */
/**
 * @author conorhayes
 *
 */
public class Folder extends AbstractFile{
	
	private String name;
	
	private ArrayList<AbstractFile> files;

	public Folder(String name) {
		this.setName(name);
		files = new ArrayList<AbstractFile>();
		
	}

	public void add(AbstractFile file) {
		files.add(file);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int size() {
		int size =0;
		for (AbstractFile file : files){
			size+=file.size();
		}
		return size;
	}

	@Override
	public int getNumFiles() {
		int num =0;
		for (AbstractFile file : files){
			num+=file.getNumFiles();
		}
		return num;
	}

	
	/* 
	 * returns the total number of subfolders in this folder
	 * iterates through its list of AbstractFile references
	 * checks if each is a folder
	 * increments numFolders by one if a folder is found
	 * then call getNumFolders() in order to get the number of 
	 * subfolders contained with the folder.
	 */
	@Override
	public int getNumFolders() {
		int numFolders=0;
		for (AbstractFile file: files){
			if (file instanceof Folder){
				numFolders++;
				numFolders+=file.getNumFolders();
			}
		}
		return numFolders;
	}


}
