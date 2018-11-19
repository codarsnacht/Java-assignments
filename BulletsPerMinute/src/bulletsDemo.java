import java.util.Scanner;

import org.joda.time.DateTime;

/**
 * 
 */

/**
 * @author Joe Gleeson
 *
 */
public class bulletsDemo {
	DateTime test = new DateTime();
	/**
	 * @param args
	 */
	// I could have put split this into 2 seperate classes but since it is quite a small program , there was no need 
	//find out how many bullets you fire from a weapon in a minute 
	// enter rate of fire and then program will calculate
	
	//Assumptions 
	//size of magazine does not equal or exceed the round per minute
	
	public static void main(String[] args) {
		
		System.out.println("Please enter Rate of Fire(rounds per minute) of weapon:");
		Scanner scan = new Scanner(System.in);//scans for input
		double RoF = scan.nextDouble();//gets base rate of fire
	
		
		System.out.println("Please enter rounds in magazine:") ;
		Scanner scan1 = new Scanner(System.in);
		int mag = scan.nextInt(); // gets mag size
		
		int bullet = 0 ;
		double rate=0;
		//gets time per 1 bullet is fired
		rate = (60/RoF); 
		System.out.println("The weapon fires a bullet every " + rate+ " seconds");
		
		double fired=0;
		int bulletCount=0; // counts bullets fired 
		//time expected until mag is empty;
		//stops when count hits the number of rounds in mag
		for (int count=0; count <mag; count++ ){
			fired = rate + fired;
			 bulletCount++;
			System.out.println("bullet fired are " + bulletCount+ ", time passed is " + fired) ;
		}
		System.out.println("Mag is empty");//says when mag is empty
	
		System.out.println("Enter reload speed (in seconds):");
		Scanner scan2 = new Scanner(System.in);//gets reload speed
		double reload = scan2.nextDouble();
		
		
		//Where assumption above is required to work
		
		double time = reload + fired; // gets total time of mag empty + reload
		double total = 60/time ;//gets amount of times you will be able to fire with reload and firing weapon per minute
		//print statement
		System.out.println("Total amount of time able to fire and reload the weapon per minute would be " + total + " times") ;
	
		// amount of times able to fire per min * time to empty magazine
		double efective = total*fired;// gets the effective time you are firing the weapon 
		System.out.println("Total effective time Firing the weapon would be " + efective + " seconds") ;
		double RateEff = efective / rate; // gets effective rate of fire with reload taken into account
		System.out.println("Effective rate of fire is " + RateEff + " rounds per minute, which is " + (int)RateEff+ " bullets per minute" );
	}

}
