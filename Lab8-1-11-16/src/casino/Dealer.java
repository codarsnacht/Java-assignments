package casino;

public interface Dealer {
	
	/*
	 * This method removes n cards from the top of the deck and inserts them one by one into a new Hand object
	 * which is then returned
	 * 
	 */
	public Hand deal(int n);
	
	public void shuffle();
	
	/*
	 * This method creates a new Deck object 
	 */
	
	public void newDeck();

}
