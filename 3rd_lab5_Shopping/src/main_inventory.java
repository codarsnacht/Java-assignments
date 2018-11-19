import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class main_inventory {
			//il=inventory list
	
	
	
	private static String fileName = "C:\\College 3rd Year\\Programming 3\\inventoryHoldings.txt";
	static ArrayList<inventory>il = new ArrayList();
	
	public static void main(String[] args) {
		 inventory in=	new inventory("1000", "Apple", 30, 2.50, 1.25);
		 inventory in1= new inventory("1001", "Orange", 40, 2, 1.00);
		 inventory in2= new inventory("2001", "Milk", 10, 2.39, 1.50);
		 inventory in3= new inventory("2002", "Orange Juice", 20, 1.99, 1.25)	;		
		 inventory in4= new inventory("3001", "Blue Cheese", 10, 2.25, 1.50);
		 inventory in5= new inventory("3002", "Cheddar", 20, 2.79, 1.60);
		 inventory in6= new inventory("4001", "Chocolate", 40, 2.99, 1.70);
		 inventory in7= new inventory("4002", "Candy", 30, 0.99, 0.50);
		 inventory in8= new inventory("5001", "Beef", 10, 5.00, 3.00);
		 inventory in9= new inventory("5002", "Chicken", 10, 4.00, 2.00);
		 
		 il.add(in);il.add(in1);il.add(in2);il.add(in3);il.add(in4);il.add(in5);
		 il.add(in6);il.add(in7);il.add(in8);il.add(in9);//adds inventory to arraylist of type inventory
		
		
		 System.out.println("\n"); // just to give a line in console
		
		 
		 ArrayList<inventory> inlst = new ArrayList();
		 
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
			
}}
