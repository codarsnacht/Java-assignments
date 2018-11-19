package shopping;

public class Item {

	private long itemId;
	private int cost;
	
	
	public Item(long id) {
		this.itemId = id;
		
		
	}


	public void setCost(int cost1) {
	
		this.cost = cost1;
		
		
	}


	public int getCost() {
		return cost;
	}

}
