package music;

public class OGGPlugin implements Plugin{
	
	public final static String FORMAT = "ogg";
	   
	@Override
	   public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		if(audio.getAudioType().equals(FORMAT)){
	      System.out.println("Playing ogg file: "+ audio.getFileName());
		}else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}
	   }

	}