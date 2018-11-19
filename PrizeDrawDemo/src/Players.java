import java.util.ArrayList;

import java.util.Collections;

import javax.swing.JOptionPane;

public class Players {

	static int players;
	static int prizes;

	public static void winners(int players2, int pri) {
		
		prizes = pri;
		players=players2;
		//array list for holding players
		ArrayList<Integer>  lista = new ArrayList<Integer>();
		
		//for loop for adding players
		for ( int counter =1 ;counter<=players;counter++){
			
			lista.add(counter);

		}
		
		//randomize 3 times for increase randomness 
		Collections.shuffle(lista);
		Collections.shuffle(lista);
		Collections.shuffle(lista);
		
		
		
		//for loop for printing out prize winners 
		for ( int prizeCounter = 1;prizeCounter<=pri;prizeCounter++){
			
		System.out.println("prize #"+prizeCounter + " goes to player #" + lista.get(prizeCounter-1));
		
		}
		
	}


}
