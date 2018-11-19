/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */


import javax.swing.JOptionPane;
import java.util.Scanner;
import java.math.*;

public class QueueTest {
	public static void main(String[] args) {
		// Create a Queue
		Queue q = new ArrayQueue(); 
		long numLocalStrings;
		long startTime;
		long endTime;
		
		//ask for input
		System.out.println("please enter number of strings:");
		Scanner scanner = new Scanner(System.in);
		//gets input+saves it
		long numStrings = scanner.nextLong();
		System.out.println("Strings entered are : " + numStrings );
		//start of overall time
		startTime = System.currentTimeMillis();
		
		
				// Put some strings onto the queue
		System.out.println("About to enqueue srtings onto queue:");
		
		//start of enqueue time
		long	startTimeEn = System.currentTimeMillis();
				//for loop with random int for i going into queue
				for (int i =0;i<numStrings;i++){
					//adds random number to queue
				int	i2 =(int) (Math.random()*1000);
					q.enqueue(i2);
				}
				//timing part//enqueue part//end part
			long	endTimeEn = System.currentTimeMillis() - startTimeEn;
				System.out.println("Total time taken for enqueue: " +endTimeEn + "ms");
				
				// Now dequeue them from the queue
				System.out.println("About to dequeue the strings ...");
				//start of time zone
				long startTimedq = System.currentTimeMillis();
				
						while(! q.isEmpty()) {
							//reuse code from earlier labs , word is number of strings in this case
							int word = (int)q.dequeue(); // Note: have to cast Objects popped to String
							System.out.println( "strings dequeued: " + word);
						}
						//timing part//dequeue time//end time
			
						long endTimedq = System.currentTimeMillis() - (startTimedq + endTimeEn);
						System.out.println("Total time taken for dequeue: " +endTimedq + "ms");
						
				
		//timing part//total time
	
	endTime = System.currentTimeMillis() - startTime;
	System.out.println("Total time taken: " +endTime + "ms ");		
	//easier to compare
	System.out.println("For ease of reading");
	System.out.println("Total time taken for enqueue: " +endTimeEn + "ms");			
	System.out.println("Total time taken for dequeue: " +endTimedq + "ms");
	System.out.println("Total time taken: " +endTime + "ms ");	
	}

	private static long currentTimeMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
