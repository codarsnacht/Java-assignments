package week3;

public class Payment {
	private final Card card;
	private boolean validated;
	
	public Payment(Card card) {
		this.card = card;
	}

	public void validate(double amount){
		// normally send the details securely to a credit card centre
		
		if ((card.getCardType().equalsIgnoreCase("Visa")||card.getCardType().equalsIgnoreCase("MasterCard"))  && card.getNumber() > 12345 && amount < 1000){
			validated = true;
		}
		
	}

	public void makePayment(Order order) {
		// normally send the details securely to a credit card centre
		// if the payment goes through
		
		order.setPaymentSucessful(true);
		
	}

	public boolean isvalidated() {
		return validated;
	}
	

}
