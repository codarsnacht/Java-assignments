package filesystem;

public class Filesystem {

	public static void main(String[] args) {
		
		Folder documents = new Folder("Documents");
		Folder music = new Folder("Music");
		Folder photos = new Folder("Photos");
		Folder dylan = new Folder("Dylan");
		Folder band = new Folder("Band");
		
		File assign1 = new File("assign1.doc");
		File family = new File("family.jpg");
		File tambourine = new File("tambourine.pm3");
		File dixie = new File("dixie.mp3");
		File weight = new File("weight.mp3");
		
		documents.add(assign1);
		documents.add(music);
		documents.add(photos);
		photos.add(family);
		music.add(dylan);
		music.add(band);
		dylan.add(tambourine);
		band.add(dixie);
		band.add(weight);
		
		// expected results
		int expectedSize = 54;
		int expectedNumFiles = 5;
		int expectedNumFolders = 4;
		
		// results returned from the code
		int sizeResult = documents.size();
		int numFilesResult = documents.getNumFiles();
		int numFoldersResult = documents.getNumFolders();
		
		// testing to see if the expected results 
		//match the results returned from the code
		
		String sizeTest = (sizeResult==expectedSize)? "size correct" : "size incorrect";
		System.out.println(sizeTest);
		
		String numFilesTest = (numFilesResult==expectedNumFiles)? "numFiles correct" : "numFiles incorrect";
		System.out.println(numFilesTest);
		
		String numFoldersTest = (numFoldersResult==expectedNumFolders)? "numFolders correct" : "numFolders incorrect";
		System.out.println(numFoldersTest);
		
		
		
		
		
	}

}
