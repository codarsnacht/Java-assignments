import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class main  {

	public static void main(String[] args) {
										
		BlockingQueue<String> ToCook = new ArrayBlockingQueue<String>(100);
		BlockingQueue<String> ToServe = new ArrayBlockingQueue<String>(100);
		BufferedReader br = null;

		//reads in the file
		try {											
			br = new BufferedReader(new FileReader(new File("orderList.txt")));
			String buffer = null;
			while ((buffer = br.readLine()) != null) {				
				ToCook.offer(buffer);
			}	
			//catches the following exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close(); // closes the buffer reader
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//creates the chefs
		chef chefJohn = new chef(ToCook, ToServe, "John");
		chef chefMark = new chef(ToCook, ToServe, "Mark");

		//creates the servers
		server serverKatie = new server(ToServe, ToServe, "Katie");
		server serverEmily = new server(ToServe, ToServe, "Emily");
		server serverAndrew = new server(ToServe, ToServe, "Andrew");

		//creates the servers threads
		Thread Tserver1 = new Thread(serverEmily);
		Thread Tserver2 = new Thread(serverKatie);
		Thread Tserver3 = new Thread(serverAndrew);

		//creates the chefs threads
		Thread Tchef1 = new Thread(chefJohn);
		Thread Tchef2 = new Thread(chefMark);

		//starts the threads
		Tchef1.start();
		Tchef2.start();
		Tserver1.start();
		Tserver2.start();
		Tserver3.start();

		//closes the threads
		try {
			Tchef1.join();
			Tchef2.join();
			Tserver1.join();
			Tserver2.join();
			Tserver3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//following calls method in the server and chef classes to print out what they prepared/served
		
		//prints out what the cooks prepared
		System.out.println(chefJohn.finalPerpared());
		System.out.println(chefMark.finalPerpared());
		//prints out what the Servers served
		System.out.println(serverAndrew.finalServing());
		System.out.println(serverKatie.finalServing());
		System.out.print(serverEmily.finalServing());//last line so no need to print a new line at the end
		

		}

}
