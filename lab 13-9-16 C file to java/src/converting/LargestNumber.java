package converting;

import java.util.Scanner; 

public class LargestNumber {
	
	public static void main(String[] args) {
		
		
		{
		    double n1, n2, n3;

		    System.out.printf("Enter three numbers: ");
		    
		    Scanner scan = new Scanner(System.in);
		    
		    n1 = scan.nextDouble();
		    n2 = scan.nextDouble();
		    n3 = scan.nextDouble();
		    		
		 

		    if (n1>=n2)
		    {
		        if(n1>=n3)
		        	System.out.printf("%.2f is the largest number.", n1);
		        else
		        	System.out.printf("%.2f is the largest number.", n3);
		    }
		    else
		    {
		        if(n2>=n3)
		        	System.out.printf("%.2f is the largest number.", n2);
		        else
		        	System.out.printf("%.2f is the largest number.",n3);
		    }
		    
		 
		}
		
	}

}
