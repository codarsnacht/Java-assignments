package question2;

public class MP4plugin implements Plugin {

	@Override
	public String play(MediaFile in) {
		// On real life this , this would decode the music the music incoded in media file 
		
		String out = "playing " + in.getFile();
		
		return out;
	}

}
