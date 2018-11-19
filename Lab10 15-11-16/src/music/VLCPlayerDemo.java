package music;


public class VLCPlayerDemo {
	
	public static void main (String[] args ){
		
		VLCPlayer player;
		
		player = new VLCPlayer();
		AudioFile mp3File = new AudioFile("mp3", "C://Music/Vicissitudes.mp3");
		try{
			player.play(mp3File);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("player playing: " + player.getPlayState()); 
		player.stop();
		
	}
	

}
