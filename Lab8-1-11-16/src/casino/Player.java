package casino;

public class Player {
	private Hand hand;
	
	public void setHand(Hand hand){
		this.hand = hand;
	}

	public void showHand() {
		hand.show();
	}
	
}
