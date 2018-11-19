package shopping;

import java.util.Scanner;

public class Bill {
	
	
	public void inputBill() {
		
		
	System.out.println("Enter your name: ");
	Scanner scanner = new Scanner(System.in);
	String name = scanner.nextLine();
	System.out.println("Your name is " + name);
	
	System.out.println("Enter address :");
	Scanner scanner1 = new Scanner(System.in);
	String address = scanner.nextLine();
	System.out.println("Your address is " + address);
	
	
	System.out.println("Enter credit card details:");
	Scanner scanner2 = new Scanner(System.in);
	String creditCard = scanner.nextLine();
	System.out.println("Your credit card details are " + creditCard);
	//redue for verification
	System.out.println("Re-Enter credit card details for verification:");
	Scanner scanner21 = new Scanner(System.in);
	String creditCard1 = scanner.nextLine();
	System.out.println("Your credit card details are " + creditCard1);
	
	if(creditCard.equals(creditCard1)){
	System.out.println("verified");
	}else{
		System.out.println("not verified");
	}
	
	System.out.println("Enter Email details:");
	Scanner scanner3 = new Scanner(System.in);
	String email = scanner.nextLine();
	System.out.println("Your Email is " + email);
	
	
	System.out.println("the following email is being sent to the email provided, which is :"  + email);
	System.out.println("the total cost for the 3 items are 55 units. ");
	System.out.println("the order is being sent to :"+ name  );
	System.out.println(address);
	System.out.println("the payment is being paid by the details entered , which are :" + creditCard);
	}

}
