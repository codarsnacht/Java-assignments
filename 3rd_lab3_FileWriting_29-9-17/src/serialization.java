import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class serialization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<transaction> list = new ArrayList(); // holds transactions
	ArrayList<bankAccount> bList = new ArrayList(); // holds bankAccounts
	public void writeToFile(transaction t) {
	
		try {
			FileOutputStream fos = new FileOutputStream("C:\\College 3rd Year\\Programming 3\\test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
			oos.close();
			fos.close();
		
		} catch (IOException ie) {
			System.out.println("IOException Transaction error below");
			ie.printStackTrace();
			return;
			
		}

			
		}
	
	public void readFromFile(){
		try{
		FileInputStream fis = new FileInputStream("C:\\College 3rd Year\\Programming 3\\test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		transaction copy = (transaction) ois.readObject();
		
		// print transactions to console
		for (Object t : list) {
			System.out.println(t.toString());
		}
		
		ois.close();
		fis.close();
		
		}catch(IOException | ClassNotFoundException ie){
			System.out.println("IOException Transaction error below");
			ie.printStackTrace();
			return;
		}
	}

	
	//adds transaction to arraylist from demo class
	public void addToList(transaction t) {
	list.add(t);	
	}

	
	
	//adds bankAccounts to arraylist of type bankAccount
	public void addToBankList(bankAccount ba) {
		bList.add(ba);
		
	}

	public void writeToBankFile(bankAccount ba) {
		try {
			FileOutputStream bfos = new FileOutputStream("C:\\College 3rd Year\\Programming 3\\accountdetails.txt");
			ObjectOutputStream boos = new ObjectOutputStream(bfos);
			boos.writeObject(ba);
			boos.close();
			bfos.close();
		
		} catch (IOException ie) {
			System.out.println("IOException bankAccount error below");
			ie.printStackTrace();
			return;
			
		}
		
		
	}
//reading from the accountdetails file for bankAccount details
	public void readFromBankFile() {
		
		try{
			FileInputStream bfis = new FileInputStream("C:\\College 3rd Year\\Programming 3\\accountdetails.txt");
			ObjectInputStream bois = new ObjectInputStream(bfis);
			bankAccount copy = (bankAccount) bois.readObject();
			
			// print to console
			for (Object b : bList) {
				System.out.println(((bankAccount) b).toBankString());
			}
			
			bois.close();
			bfis.close();
			
			}catch(IOException | ClassNotFoundException ie){
				System.out.println("IOException bankAccount error below");
				ie.printStackTrace();
				return;
			}
		
	}
	
	//part 3
	public void readFromRandomFile(){
		try {
			RandomAccessFile file = new RandomAccessFile("C:\\College 3rd Year\\Programming 3\\read.txt", "rw");
		
			file.seek(2); // resets pointer to start of line , 
						  //need to move it 2 places to avoid unwanted characters at start of line
			
			System.out.println(file.readLine()); //prints out the file
			file.close();
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	
	}





