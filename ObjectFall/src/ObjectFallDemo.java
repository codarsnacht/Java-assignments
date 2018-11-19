/**
 * 
 */
import java.util.Scanner;
/**
 * @author Joe Gleeson
 *
 */
public class ObjectFallDemo {

	//Program to see how long and object will take to fall from an entered height 
	//Also speed will be printed
	//floor = 2.5 meters
	
	public static void main(String[] args) {
		
		cal cal = new cal();
		
		System.out.println("Please select height choice ( meters or floor):");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		
		if ("floor".equals(choice )) {
			System.out.println("Please enter the floor the object is to be droped from:");
			Scanner scan = new Scanner(System.in);
			int floor = scan.nextInt();
			//take away 1 floor height as taking 1st floor as ground level = 0
			double height = (floor*2.5)-2.5 ; 
		 cal.setheightFLoor(height);
			
		}
		
		if ( "meters".equals(choice)){
			System.out.println("Please enter the height from which the object is to be droped from:");
			Scanner scan = new Scanner(System.in);
			double meters = scan.nextDouble();
			cal.setheightMeters(meters);
			
		}
		else { 
			System.out.println("You did not enter a valid choice, please restart " );
			
		}
		
		
		
	}



}
