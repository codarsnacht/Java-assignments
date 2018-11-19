package casino;


public class Card{

	private int suit, rank;

	public final static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	public final static String[] ranks = {"zzz", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	

	/*
	 * Constructor with arguments.
	 */
	public Card (int s, int r)  { 
		//TODO 
		this.suit = s ; this.rank = r;
		
	}
	
	
	/*
	 * This method returns a String representation of the Card
	 * e.g.  "Jack of Hearts", "Ace of Spades", "Queen of Hearts"
	 */

	public  String toString() {
		//TODO
		return (ranks [this.rank] + " of " + suits[this.suit]);
	}


	/*
	 * This method checks if this Card object 
	 * has the same suit and rank values as the Card c being passed to it 
	 * as a parameter
	 * it returns true if this card has the same suit AND rank values as c
	 */
	
	public  boolean equals(Card c) {
		//TODO
		if(  this.suit == c.suit && this.rank == c.rank)
			return true;
		return false; 
	}

	
 
	
	public int getSuit(){
		return this.suit;
	}

	public int getRank(){
		return this.rank;
	}

	

}
