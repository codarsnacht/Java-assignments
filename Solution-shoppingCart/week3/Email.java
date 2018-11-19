package week3;

public class Email {
	
	private Customer customer;
	private String emailType;
	private String message;
	
	public Email(Customer customer) {
		this.customer = customer;
	}

	public void send(){
		System.out.println(message);
		
	}
	
	private void createMessage(Order order){
		message = "To: " + customer.getEmailAddress() + "\n\n";
		message += " Dear " + customer.getFirstName() + ",\n"; 
		message += " Thank you for your order, number " + order.getOrderId() + ".\n";
		message += " We will dispatch it shortly. The items you have ordered are listed below \n\n";
		message+= order;
		
	}

	public void setType(String type, Order order) {
		emailType = type;
		createMessage(order);
		
	}

	
}
