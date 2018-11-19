package lecture1.lab;

import java.util.Scanner;

public class Largest {

	public static void main(String[] args) {
		double n1, n2, n3;

		System.out.println("Enter three numbers: ");

		Scanner scan = new Scanner(System.in);

		n1 = scan.nextDouble();
		n2 = scan.nextDouble();
		n3 = scan.nextDouble();

		scan.close();

		if (n1>=n2) {
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
