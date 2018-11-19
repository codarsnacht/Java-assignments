package casino;

import java.util.ArrayList;

public class ConcreteHand  implements Hand{
	
	private ArrayList<Card> cards;
	private int counter=0;
	private int size=0;

	public ConcreteHand(int n){
		//TODO you will need to initialise the cards variable with an array of size n
		size = n;
		cards = new ArrayList<Card>(n);
	}
	
	/*
	 * This method adds a Card to the cards array
	 */
	
	public void addCard(Card card ){
		//TODO you need to insert a Card to the array
		//You'll need to have kept track of how many cards have been added already
		//so that you add the card in the right place (i.e. immediately after the last added one)
		
		
		 cards.add( card);//adds card
		 
		
	}
	
	/*
	 * This method prints out the hand
	 * e.g. Ace of Clubs, 3 of Diamonds, Jack of Hearts, etc
	 */
	
	public void show() {
		
		System.out.println("Cards are" + cards);//prints out cards
	}

}
