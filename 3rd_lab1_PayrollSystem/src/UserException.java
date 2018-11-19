
public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void UserException() {
	//	super("error in inputs");
		super.printStackTrace();
		System.err.println("error in inputs");
	}
	

}
