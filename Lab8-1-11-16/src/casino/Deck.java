package casino;

public interface Deck {


	/*
	 * This method shuffles the deck.
	 * There are many ways to do this
	 * One such way would be to select two random positions in the deck and swap the cards
	 * Then do this a number of times
	 */
	
	public void shuffle();
	
	
	/*
	 * This method selects the top card from the Deck
	 * It then copies all the Cards (except the top Card) in the cards array into a new array 
	 * and then sets the cards variable to point to that array
	 * This has the effect of reducing the size of he deck by one every time this 
	 * method is called
	 * The method returns the Card selected in the first step
	 */
	public Card removeTopCard();

}
