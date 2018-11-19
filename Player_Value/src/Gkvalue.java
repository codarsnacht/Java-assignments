import java.util.Scanner;

public class Gkvalue {

	public static void stats() {
		System.out.println("please enter the player stats( in percentage form e.g 55=55% for the following :" );
		
		System.out.println("save percentage: ");
		Scanner scanner = new Scanner(System.in);
		int gkSaves = scanner.nextInt();
		
		System.out.println("catch percentage: ");
		Scanner scanner1 = new Scanner(System.in);
		int catches = scanner.nextInt();
		
		System.out.println("punch from crosses percentage: ");
		Scanner scanner2 = new Scanner(System.in);
		int punch = scanner.nextInt();
		
		System.out.println("reflex rating: ");
		Scanner scanner3 = new Scanner(System.in);
		int reflex = scanner.nextInt();
		
		System.out.println("communication rating: ");
		Scanner scanner4 = new Scanner(System.in);
		int talk = scanner.nextInt();
		
		System.out.println("aerial ability rating: ");
		Scanner scanner5 = new Scanner(System.in);
		int aA = scanner.nextInt();
		
		System.out.println("pass accuracy: ");
		Scanner scanner6 = new Scanner(System.in);
		int pass = scanner.nextInt();
		
		System.out.println("1 on 1 ability: ");
		Scanner scanner7 = new Scanner(System.in);
		int one = scanner.nextInt();
		
		System.out.println("shots saved to goal conceded: ");
		Scanner scanner8 = new Scanner(System.in);
		int sstg = scanner.nextInt();
		
		System.out.println("age: ");
		Scanner scanner9 = new Scanner(System.in);
		int age = scanner.nextInt();
		
		float value = (gkSaves * 100) + ( catches * 80) + (punch * 50) + (reflex* 90) + (talk * 55) + (aA*70)+(pass*50)+(one*80)-(sstg*10)-(age*15);
		
		
		System.out.println("Save stat is " + gkSaves  ) ;
		System.out.println("Catching stat is " + catches  ) ;
		System.out.println("Punching stat is " + punch  ) ;
		System.out.println("Reflex stat is " + reflex  ) ;
		System.out.println("Communication stat is " + talk  ) ;
		System.out.println("Aerial Ability stat is " + aA  ) ;
		System.out.println("Passing stat is " + pass  ) ;
		System.out.println("1-on-1 stat is " + one  ) ;
		System.out.println("Saves to goal conceded stat is " + sstg  ) ;
		System.out.println("Player age is " + age  ) ;
		System.out.println("Player value is " + value);

	
	
	
	}	
}
