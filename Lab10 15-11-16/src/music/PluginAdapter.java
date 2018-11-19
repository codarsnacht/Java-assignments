package music;

public class PluginAdapter implements Plugin {

	private Plugin player;

	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		
		switch (audio.getAudioType()) {
		case "ogg":
			this.player = new OGGPlugin();
			break;
		case "wma":
			this.player = new WMAPlugin();
			break;
		case "mp3":
			this.player = new MP3Plugin();
			break;
		default: 
			throw new UnSupportedAudioFormatException("unsupported format: "
			+ audio.getAudioType());
		}
		
		this.player.play(audio);
	}
}
