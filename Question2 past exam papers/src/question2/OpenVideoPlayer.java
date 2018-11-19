package question2;

public class OpenVideoPlayer {
	
	private Plugin plugin;
	
	public String play(MediaFile in) throws FormatNotSupportedException {
		
		String out = null;
		
		if(in.getFile().endsWith(".mp4")){
		plugin = new MP4plugin();
		 out = plugin.play(in);
		}
		
		if(in.getFile().endsWith(".avi")){
			plugin = new AVIplugin();
			 out = plugin.play(in);
			}
		
		if(in.getFile().endsWith(".ogv")){
			plugin = new OGVplugin();
			 out = plugin.play(in);
			}
	//	else 
		//	throw new FormatNotSupportedException("error");		
		
		return out;
	}
	

}
