import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class inventory implements  Serializable {
	
		private Item item;
		private String itemId;
		private double cost;
		private double price;
		private int quantity;
		private String name;

					//id
//put as static to get to compile
	static	ArrayList<Item>inventoryList = new ArrayList();
	static ArrayList<inventory>il = new ArrayList();
		

	
	//sku = id
	public inventory(String id, String name, int quantity, double price, double cost) {
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.itemId = id;
		this.cost = cost;
		
		
		item = new Item(name, quantity, price);
		inventoryList.add(item);
		
	}

	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public static ArrayList<Item> getList(){
		return inventoryList;
	}
	

	public String toString(){
		return itemId +"\t"+item+"\t"+cost;
	}
	
	

}
