package question2;

public class PlugInAdapter implements Plugin {

	public MediaFile File;

	@Override
	public void play(MediaFile File) {
	this.File = File;
		return;
	}
	
	
}
