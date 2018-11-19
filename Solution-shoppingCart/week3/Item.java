package week3;

public class Item {
	private String name;
	private int price;;

	public Item(String itemName) {
		name = itemName;
	}
	
	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString(){
		
		String out = "Item: " + name +";\tPrice: " + price;
		
		return out;
	}

}
