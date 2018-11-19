import java.util.Scanner;

public class fValue {

	public static void stats() {
System.out.println("please enter the player stats( in percentage form e.g 55=55% for the following :" );
		
		System.out.println("shots to goal rating: ");
		Scanner scanner = new Scanner(System.in);
		int gkSaves = scanner.nextInt();
		
		System.out.println("fitness rating: ");
		Scanner scanner1 = new Scanner(System.in);
		int catches = scanner.nextInt();
		
		System.out.println("pass rating: ");
		Scanner scanner2 = new Scanner(System.in);
		int punch = scanner.nextInt();
		
		System.out.println("touch rating: ");
		Scanner scanner3 = new Scanner(System.in);
		int reflex = scanner.nextInt();
		
		System.out.println("communication rating: ");
		Scanner scanner4 = new Scanner(System.in);
		int talk = scanner.nextInt();
		
		System.out.println("positional rating: ");
		Scanner scanner5 = new Scanner(System.in);
		int position = scanner.nextInt();
		
		System.out.println("shooting rating: ");
		Scanner scanner6 = new Scanner(System.in);
		int position1 = scanner.nextInt();
		
		System.out.println("age: ");
		Scanner scanner9 = new Scanner(System.in);
		int age = scanner.nextInt();
		
		float value = (gkSaves * 100) + ( catches * 80) + (punch * 50) + (reflex* 90) + (talk * 55) + (position * 70)+(position1 * 50) - (age*20);
		
		
		System.out.println("Save stat is " + gkSaves  ) ;
		System.out.println("Catching stat is " + catches  ) ;
		System.out.println("Punching stat is " + punch  ) ;
		System.out.println("Reflex stat is " + reflex  ) ;
		System.out.println("Communication stat is " + talk  ) ;
		System.out.println("positional stat is " + position  ) ;
		System.out.println("positional stat is " + position1  ) ;
		System.out.println("Player age is " + age  ) ;
		System.out.println("Player value is " + value);
		
	}

}
