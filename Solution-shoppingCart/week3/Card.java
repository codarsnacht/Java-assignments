package week3;

public class Card {
	private final Customer customer;
	private final String cardType;
	private final long number;
	private final String date;
	private Address address;
	

	public Card(Customer customer, Address address, String cardType, long number, String date) {
		this.customer = customer;
		this.cardType = cardType;
		this.number = number;
		this.date = date;
		this.address = address;
	}


	public String getDate() {
		return date;
	}


	public long getNumber() {
		return number;
	}


	public String getCardType() {
		return cardType;
	}
	
	public String getCustomerFirstName(){
		return this.customer.getFirstName();
	}
	public String getCustomerSurName(){
		return this.customer.getSurName();
	}

}
