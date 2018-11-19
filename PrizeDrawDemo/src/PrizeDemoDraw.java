import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrizeDemoDraw {
	
	public static void main(String[] args){
	
	System.out.println("Enter number of people in draw: ");
	Scanner scanner = new Scanner(System.in);
	int players = scanner.nextInt();
	System.out.println("number of people is  " + players);	//to comfirm # of players
	
	System.out.println("Enter number of prizes in draw: ");
	Scanner scanner1 = new Scanner(System.in);
	int pri = scanner.nextInt();
	System.out.println("number of prizes are  " + pri);	//to comfirm # of prizes
	
	//will not allow more prizes then players
	//crude failsafe to block more prizes then players 
	
	while ( pri>players){
		System.out.println("Too many prizes for the amount of people , please re-enter number of prizes: ");
		Scanner scannerRepeat = new Scanner(System.in);
		int priRept = scanner.nextInt();
		pri = priRept ;
	}
	
	scanner.close();
	Players.winners(players , pri);//calls method to begin draw
	}

}
