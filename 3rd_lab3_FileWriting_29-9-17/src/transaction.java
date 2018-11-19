import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058910858174394620L;
	
	private  int transNum ;
	private String transDate;
	private String transType;
	private double transAmount;
	private static int count;

	
	
	
	
	//constructor
	public transaction(int num, String date, String type , double amount){
		this.transNum = (num = num +(++count)) ; // increments id number ||num = num + increment of count
		this.transDate = date;
		this.transType = type;
		this.transAmount = amount;
	
		
		
		
	}
		
	 public String toString() {
		 
	        return"Type is: " +transType + " \n Date is: " + transDate + "\n  Amount is: "+ transAmount  + "\n   Number of transaction is: " + transNum;
	        
	    }



	
	
	 

}
