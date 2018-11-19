import java.util.Scanner;

public class InputPlayer {

	public static void main(String[] args) {
		
		//a simple way to get a crude value of a football player 
		//very basic way , just a basic idea of how to value a player
		//requires more tweeking of numbers and more stats for more accuracy 
		
		
		
	
		System.out.println("Positions available : gk , def ,  mid , f (forward) "); 
		System.out.println("to exit enter 'exit'" );
		System.out.println("please enter player position : " );
		
		Scanner scanner = new Scanner(System.in);
		String pos = scanner.nextLine();
		
		if ("gk".equals(pos )) {
		  
		    Gkvalue.stats();
		}
		
		else if ("def".equals(pos )) {
		    
			cbValue.stats();
		}
		
		else if ("mid".equals(pos )) {
		 
			midValue.stats();
		}
		else if ("f".equals(pos )) {
		   
			fValue.stats();
		}
		else  {
			System.out.println("you failed to pick a correct position");
		}
		
		
		
	}
	
	
	
	
}
