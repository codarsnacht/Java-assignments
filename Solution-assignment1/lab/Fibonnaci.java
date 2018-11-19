package lecture1.lab;

import java.util.Scanner;

public class Fibonnaci {

	public static void main(String[] args) {
		
		    int t1=0, t2=1, nextTerm = 0, n;

		    System.out.printf("Enter a positive integer: ");
		    Scanner scan = new Scanner(System.in);
		    n = scan.nextInt();
		    scan.close();

		    // displays the first two terms which is always 0 and 1
		    System.out.printf("Fibonacci Series: %d, %d, ", t1, t2);

		    nextTerm = t1+t2;

		    while(nextTerm < n)
		    {
		    	System.out.printf("%d, ",nextTerm);
		        t1 = t2;
		        t2 = nextTerm;
		        nextTerm = t1+t2;
		    }
		    
	

	}

}
