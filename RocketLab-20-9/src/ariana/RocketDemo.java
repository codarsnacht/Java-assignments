package ariana;

import java.util.Scanner;

public class RocketDemo {

	public static void main(String[] args) {
		
	    System.out.print("Enter Destination Altitude as an interger value: \n");  
	    Scanner scan = new Scanner(System.in);
		int destination = scan.nextInt(); 
		//new code
		System.out.print("Enter Fuel as an interger value: \n");  
	    Scanner scanFuel = new Scanner(System.in);
		float fuel = scan.nextInt(); 
		System.out.print("Enter Oxygen as an interger value: \n");  
	    Scanner scanOxygen = new Scanner(System.in);
		float oxygen = scan.nextInt(); 
		scan.close();

		Rocket ariana = new Rocket();
		ariana.setDestination(destination);
		//new code
		ariana.setOxygen(oxygen);
		ariana.setFuel(fuel);
		ariana.blastOff();
	
		while (!ariana.hasMajorError() && !ariana.isMissionAccomplished()){
			ariana.getTelemetry();
			ariana.reportStatus();
		}	
		
	}

}
