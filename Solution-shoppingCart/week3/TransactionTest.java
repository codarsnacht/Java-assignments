package week3;

import java.util.Scanner;

public class TransactionTest {

	private Scanner scanner;
	
	public TransactionTest(){
		scanner = new Scanner(System.in);
	}

	private String prompt(String prompt) {
		System.out.print(prompt);
		String in = scanner.nextLine();
		System.out.println();
		return in;
	}
	
	private void close() {
		scanner.close();
		
	}

	public static void main(String[] args) {

		TransactionTest transaction = new TransactionTest();
		ShoppingCart cart = new ShoppingCart();

		while(true){
			String itemName = transaction.prompt("Add item name to shopping cart: ");
			String costString = transaction.prompt("Enter the price of the item (integer value only): ");
			int cost = Integer.parseInt(costString) ;
			Item item = new Item(itemName);
			item.setPrice(cost);
			
			cart.addItem(item);
			String answer = transaction.prompt("finished?: y/n ");
			if(answer.equalsIgnoreCase("y")){
				double total = cart.getTotal();
				System.out.printf("The cart total is %f \n", total);
				break;
			}
		}

		String first = transaction.prompt("Enter First Name: ");
		String surN = transaction.prompt("Enter Surname: ");
		String emailAddress = transaction.prompt("Enter Email Address: ");
		String address = transaction.prompt("Enter Delivery address: ");

		Customer customer = new Customer();

		customer.setFirstName(first);
		customer.setSurName(surN);
		customer.setEmailAddress(emailAddress);
		
		Address delivery = new Address(address);
		customer.setDeliveryAddress(delivery);
		cart.setCustomer(customer);

		Order order = new Order(cart);
		order.setAddress(delivery);

		String invoiceAddress = transaction.prompt("Enter Invoice address: ");
		Address invoice = new Address(invoiceAddress);

		String cardType;
		while (true){
			cardType = transaction.prompt("Enter CARD TYPE: Visa or MasterCard ");
			if(cardType.equalsIgnoreCase("Visa")||cardType.equalsIgnoreCase("MasterCard") ){
				break;
			}
		}
		
		long number  = Long.parseLong(transaction.prompt("Enter CARD Number: "));
		String date =  transaction.prompt("Enter expiry date: dd/mm/yy ");

		Card card  = new Card(customer, invoice, cardType, number, date );

		Payment payment = new Payment(card);
		payment.validate(order.getOrderTotal());

		if(payment.isvalidated()){
			payment.makePayment(order);
		}else{
			order.cancel();
		}

		Email email = new Email(customer);

		if (order.isPaymentSucessful()){
			email.setType("success", order);
			email.send();
			order.notifyDispatch();
		}else{
			email.setType("fail", null);
			email.send();
		}
		transaction.close();
	}
}
