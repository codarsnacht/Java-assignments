package music;

public class MP3Plugin implements Plugin {

	public final static String FORMAT = "mp3";
	   
	@Override
	   public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		if(audio.getAudioType().equals(FORMAT)){
	      System.out.println("Playing mp3 file: "+ audio.getFileName());
		}else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
			}
		
	   }

}
