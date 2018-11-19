package filesystem;

public class File extends AbstractFile{
	
	private String name;

	public File(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int size() {
		return name.length();
	}

	@Override
	public int getNumFiles() {
		return 1;
	}

	@Override
	public int getNumFolders() {
		return 0;
	}

}
