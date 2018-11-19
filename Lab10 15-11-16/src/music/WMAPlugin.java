package music;

public class WMAPlugin implements Plugin{
	
	public final static String FORMAT = "wma";

	@Override
	   public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		if(audio.getAudioType().equals(FORMAT)){
	      System.out.println("Playing wma file: "+ audio.getFileName());
		}else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}
	   }
	}
