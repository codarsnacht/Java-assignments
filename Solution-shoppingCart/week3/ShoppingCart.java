package week3;

import java.util.Stack;

public class ShoppingCart {
	
	private final long cartId;
	private long orderId;
	private Customer customer; 
	private boolean finalised = false;
	
	private Stack<Item> list;
	
	public ShoppingCart(){
		cartId = getNewId();
		list = new Stack<Item>();
	}
	
	private long getNewId(){
		long id = (long)(1000000000L * Math.random());
		return id;
	}
	


	public void addItem(Item item) {
		if(!finalised){
			list.push(item);
		}
	}



	public double getTotal() {
		
		double total =0 ;
		
		for(Item item: list){
			total+= item.getPrice();
		}
		return total;
	}

	public void finalise() {
		this.finalised = true;
		this.list.clear();
	}
	
	public long getCustomerId() {
		return customer.getId();
	}
	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCartId() {
		return cartId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public boolean hasItems() {
		if(!list.isEmpty()){
			return true;
		}
		return false;
	}

	public Item getNext() {
		return list.pop();
	}

	public Customer getCustomer() {
		
		return customer;
	}

}
