import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class main_shoppingCart {

	public static void main(String[] args) {
		shoppingCart cart1 = new shoppingCart("tom", "10-1-2017");
		shoppingCart cart2 = new shoppingCart("Carol", "10-12-2017");
		
		
		private static String fileName = "C:\\College 3rd Year\\Programming 3\\inventoryHoldings.txt";
		
		 ArrayList<inventory>il = new ArrayList();
		 ArrayList<inventory> inlst = new ArrayList();
		
		cart1.addItem("Apple", 2);
		cart1.addItem("Orange", 5);
		cart1.addItem("Milk", 2);
		cart1.addItem("Blue Cheese", 4);
		cart1.addItem("Candy", 25);
		cart1.removeItem("Candy", 5);
		
		cart2.addItem("Apple", 2);
		cart2.addItem("Orange", 5);
		cart2.addItem("Milk", 2);
		cart2.addItem("Blue Cheese", 4);
		cart2.addItem("Cheddar", 3);
		cart2.addItem("Beef", 6);
		cart2.addItem("Candy", 20);
		cart2.addItem("Chocolate", 10);
		cart2.addItem("Chicken", 2);
		cart2.removeItem("Chocolate", 5);
		cart2.removeItem("Blue Cheese", 1);
		
		 //output
		 try{
		 ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fileName));
			ois.writeObject(il);
			ois.close();
		 }catch(IOException ie){
			 ie.printStackTrace();
		 }
		 
		 //input to console
		 try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
				
					inlst = (ArrayList<inventory>) ois.readObject();
					 for ( inventory inv: il){
						 System.out.println(inv);
					 }
					ois.close();
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
					
				}
		

	}

}
