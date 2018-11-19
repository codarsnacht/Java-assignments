package week3;

import java.util.ArrayList;

public class Order {
	private final long orderId;
	private final long cartId; 
	private final Customer customer; 
	private ArrayList<Item> orderItems = new ArrayList<Item>();
	private double orderTotal;
	private Address delivery;
	private boolean paymentSucessful;
	private boolean cancelled = false;
	
	public Order(ShoppingCart cart){
		
		orderId = getNewId();
		cartId = cart.getCartId();
		customer = cart.getCustomer();
		
		while(cart.hasItems()){
			
			Item item = cart.getNext();
			orderItems.add(item);
			orderTotal+=item.getPrice();
		}
		cart.finalise();
	}
	
	private long getNewId(){
		long id = (long)(1000000000L * Math.random());
		return id;
	}
	

	
	public long getOrderNumber(){
		return orderId;
	}

	public void setAddress(Address delivery) {
		this.delivery = delivery;
		
	}

	

	public long getOrderId() {
		return orderId;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	

	public boolean isPaymentSucessful() {
		return paymentSucessful;
	}

	public void setPaymentSucessful(boolean paymentSucessful) {
		this.paymentSucessful = paymentSucessful;
	}

	public void notifyDispatch() {
		// TODO Auto-generated method stub
		
	}

	public void cancel() {
		cancelled= true;
		orderItems.clear();
		
	}
	
	@Override
	public String toString(){
		String out = "Order Details \n";
		
		out+= "******************************\n";
	
		for (Item item: orderItems){
			out+=item + "\n";
		}
		out+="________________________________\n";
		out+= "Order Total:\t\t" + getOrderTotal();

		return out;
		
	}

}
