import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class shoppingCart implements Serializable, Comparator {

	private static String fileName = "C:\\College 3rd Year\\Programming 3\\inventoryHoldings.txt";
	static ArrayList<inventory>il = new ArrayList();
	private String custName;
	private String date;

	public shoppingCart(String custName,String date){
		this.custName = custName;
		this.date = date;
		
	}
	
	ArrayList<Item> shoppingcart = new ArrayList();
	private int localQuantity;
	
	
	
	public void addItem(String itemName, int quantity){
		Item searchItem = null;
		this.localQuantity = quantity;
		//comment out as it will not compile
	 //   searchItem=searchInventory(itemName);
	    
		//item is found and in stock
		if(searchItem.getQuantity() - localQuantity > 0){
			//updates item's quantity in inventory
			searchItem.setQuantity(searchItem.getQuantity() - localQuantity);
			
			//adds item to cart
			shoppingcart.add(new Item(itemName,localQuantity,searchItem.getOverallPrice()));
			
		}
		//item is out of stock
		else if(searchItem.getQuantity() - localQuantity <= 0){
			System.out.println(itemName + " does not have enough stock to finalise this purchases");
			
		}
		//if item is not found
		else if(searchItem == null) {
			System.out.println("Item not found.");
		}

		//write updated inventory  to file
		 try{
			 ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fileName));
				ois.writeObject(il);
				ois.close();
			 }catch(IOException ie){
				 ie.printStackTrace();
			 }

		
	}
	
	public void removeItem(String itemName, int quantity){
		
		Item searchItem = null;
		this.localQuantity = quantity;
	   
		
	  //to find item in the shopping cart list
	    
		for(Item sh : shoppingcart) {
			if(sh.getName() == itemName) 
			{
	  		if(searchItem.getQuantity() > 0){
	  			//updates item's quantity in inventory
	  			searchItem.setQuantity(searchItem.getQuantity() + localQuantity);
	  			
	  			//adds item to cart
	  			shoppingcart.remove(new Item(itemName,localQuantity,searchItem.getOverallPrice()));
	  			
	  		}
			}
	  		//if item is not found
	  		else {
	  			System.out.println("Item not found.");
	  		}

	  		//write updated inventory  to file
	  		 try{
	  			 ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fileName));
	  				ois.writeObject(il);
	  				ois.close();
	  			 }catch(IOException ie){
	  				 ie.printStackTrace();
	  			 }
		}
		
		
	}
	
//	public Item searchInventory(String itemName){
//		int counter = Collections.binarySearch(il,
//                new inventory(null,n,0,0,0), new Comparator());
//		
//		return il.get(counter)).getItem();
//
//	}
	
	
	
	public void viewCart(){
		System.out.println("Shopping cart contains: " + shoppingcart.toString());
	}
	


//	@Override
	public int compare(Object o1, Object o2) {
//		if(o1>o2)//idea of condition to go in here
//		return 1;
//		else if(o1<02) // idea of condition to go in here
//			return -1;
//		else 
			return 0;
	}

	

}
