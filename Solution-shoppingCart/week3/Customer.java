package week3;

public class Customer {
	private String firstName;
	private String surName;
	private String emailAddress;
	private final long customerId;
	private Address deliveryAddress;
	
	public Customer(){
		customerId  = getCustId();
	}
	
	private long getCustId() {
		return (long)Math.random() * 99999999999999L;
	}

	public void setFirstName(String first) {
		firstName = first;
	}

	public void setSurName(String sur) {
		surName = sur;
		
	}

	public long getId() {
		
		return customerId;
	}

	public void setDeliveryAddress(Address delivery) {
		deliveryAddress = delivery;
		
	}

	public String getFirstName() {
		
		return firstName;
	}

	public String getSurName() {
		
		return surName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
