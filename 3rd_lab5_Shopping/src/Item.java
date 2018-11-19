import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 */

/**
 * @author Joe
 *
 */
public class Item implements Serializable {
	
	private String name;
	private double price;
	private int quantity;

	public Item(String name, int quantity, double price) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String toString(){
		return name +" "+price+" "+getQuantity();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	//gets price of x items
	public double getOverallPrice() {
		return price*quantity;
	}
	
	

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
