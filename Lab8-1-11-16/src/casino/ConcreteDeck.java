package casino;

import java.util.Random;


public class ConcreteDeck  implements Deck{

	//private Card[] cards = null; 
	private Stack<Card> cards;
	/*
	 * public Constructor with arguments.
	 */
	public ConcreteDeck() {
		//TODO initialise the cards array (size 52)
		//then insert a new unique (and valid) Card for each of the array slots
		//Your deck can't include duplicates
		
		cards = new  Stack<Card>();
		for ( int i =0; i<4; i++){
			for ( int j = 0; j<13 ; j++)
			{
				cards.push( new Card( i, j+1));
			}
		}
		
	} 

	
	/*
	 * returns a String representation of the array of Card
	 * e.g Ace of Clubs, Two of Clubs, Three of Clubs,..
	 */
	public String toString(){
		//TODO
		return null;
	}
	
	
	@Override
	public void shuffle(){
		//TODO 
		//To get a random position in the deck you could use the math.random() function
		int index;
		Card temp;
		Random random = new Random();
		for ( int i =cards.size() - 1; i > 0 ; i--)
		{ 
			index = random.nextInt(i+1);
			temp = cards.get(index);
			cards.set(index, cards.get(i));
			cards.set(i,temp);
		}
	}
	
	
	@Override
	public Card removeTopCard(){
		
		Card c = cards.pop();
		return c;
	
	}
	
	public Stack<Card> getCards(){
		return this.cards;
	}
	
	
}


