package lab8Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Card;
import casino.ConcreteDeck;

public class Lab8Test {


	@Test
	public void test() {
		Card c = new Card(1,1);
		System.out.println("Test " +  c.toString() );
		System.out.println("  ");
	}
	
	@Test
	public void testConDeck(){
		ConcreteDeck d = new ConcreteDeck();
		for ( Card c : d.getCards()){
			System.out.println(c.toString());
			
		}
		System.out.println("  ");
	}
	
	@Test
	public void testSuffleDeck(){
		ConcreteDeck d1 = new ConcreteDeck();
		d1.shuffle();
		for ( Card c : d1.getCards()){
			System.out.println(c.toString());
			
		}
		System.out.println("  ");
	}
	
	
	@Test
	public void testTemoveCard(){
		
		ConcreteDeck d2 = new ConcreteDeck();
		d2.shuffle();
		int left = 0;
		while ( d2.removeTopCard() != null){
			left++;
			System.out.println(" Removed top card , remaining cards are " + d2.getCards().size());
		}
		
		System.out.println("cards removed  : " + left );
	}

}
