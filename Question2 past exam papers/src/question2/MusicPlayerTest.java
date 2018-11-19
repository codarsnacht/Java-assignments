package question2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicPlayerTest {
	
	OpenVideoPlayer player;

	@Before
	public void setUp() throws Exception {
		player = new OpenVideoPlayer() ;
	}

	@Test
	public void MP4Test() throws FormatNotSupportedException {
		
		MediaFile mp4 = new MediaFile("sandy.mp4");
	    String out = player.play(mp4); // play the mp4 file
		
		String expected = "playing " +mp4.getFile();
		assertEquals(expected, out);
	}
	
	
	@Test
	public void AVITest() throws FormatNotSupportedException {
		
		MediaFile avi = new MediaFile("sunny.avi");
		 String out = 	player.play(avi); // play the avi file
		
		String expected = "playing " +avi.getFile();
		assertEquals(expected, out);
	}
	
	@Test
	public void OGVTest() throws FormatNotSupportedException {
		
		MediaFile ogv = new MediaFile("rainy.ogv");
		 String out = 	player.play(ogv); // play the ogv file
		
		String expected = "playing " +ogv.getFile();
		assertEquals(expected, out);
	}
	
	@Test
	public void ExceptionTest(){
		MediaFile media = new MediaFile("dylan.acc");
		
		boolean exceptionThrown = true;
		try{
			player.play(media);
			
		}catch (FormatNotSupportedException e){
			e.printStackTrace();
			exceptionThrown = true;
			
		}
		
		assertTrue(exceptionThrown);
	}
	
	

}
