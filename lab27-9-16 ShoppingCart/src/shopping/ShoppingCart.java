package shopping;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<Item> list ;
	
	
	public ShoppingCart(){
	this.list = new ArrayList<Item>(5);
	
	}
	
	
	
	public void addItem(Item item1) {
		
		this.list.add(item1);
		
		
	}



	public int getTotal() {
		int total = 0;
		
		for(Item it : list){
			
			total=total+it.getCost();
		}
		return total;
	}



	public void removeItem(Item item4) {
		this.list.remove(item4);
		
		
	}

}
