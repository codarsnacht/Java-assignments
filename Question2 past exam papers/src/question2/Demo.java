package question2;



/**
 * @author conorhayes
 * The Demo  just illustrates how the 
 * OpenVideoPlayer player ought to work
 * It is not intended to be used for anything else
 */
public class Demo {
	
	public static void main(String[] args) throws FormatNotSupportedException{
		
		OpenVideoPlayer player = new OpenVideoPlayer();
		
		
		//create new mp4 file
		MediaFile mp4 = new MediaFile("sandy.mp4");
		player.play(mp4); // play the mp4 file
		
		//create new ogv file
		MediaFile ogv = new MediaFile("rainy.ogv");
		player.play(ogv); // play the ogv file
		
		//create new avi file
		MediaFile avi = new MediaFile("sunny.avi");
		player.play(avi); // play the avi file
		
	}

}
