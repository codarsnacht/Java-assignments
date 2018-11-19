package casino;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcreteDealer implements Dealer{
	
	private Deck deck;
	
	

	public static void main(String[] args) {
		
		System.out.printf("Enter number of players (integer only): ");
		Scanner scan = new Scanner(System.in);
		int numPlayers = scan.nextInt();
		System.out.printf("Enter number of Cards (integer only): ");
		int cards_In_Hand  = scan.nextInt();
		scan.close();

		
		
		Player[] players = new Player[numPlayers];
		
		Dealer dealer = new ConcreteDealer(); // new Dealer object
		dealer.newDeck(); // creates a new Deck
		dealer.shuffle(); // then shuffles the Deck
		
		
		for (int i = 0; i< players.length; i++){ // for the number of hands required
			players[i] = new Player();
			Hand hand = dealer.deal(cards_In_Hand); // create a new  hand
			players[i].setHand(hand);; // store each hand in the array
		}
		
		
		for (int i = 0; i< players.length; i++){ // for each of the players
			players[i].showHand(); // print out the cards in each hand
		}
		
	}

	
	
@Override
	public Hand deal(int n) {
		// TODO write the code to deal out n cards from the deck
		// You will need to create a Hand object and add these cards to it.
  Hand newPlayerHand = new ConcreteHand(n);
  for ( int i=0 ; i<n; i++)
  {
	       newPlayerHand.addCard( deck.removeTopCard());
	    
	  
  }
  
  return newPlayerHand;
	}


@Override
	public void shuffle() {
		deck.shuffle();

	}

	

@Override
	public void newDeck() {
		deck= new ConcreteDeck();
		
	}

}
