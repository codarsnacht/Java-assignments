import java.util.Scanner;

import javax.swing.JOptionPane;

// M Madden, M Schukat, 2005 - 2016

public class LLTest 
{
	public static void main(String[] args)
	{
		// Create a linked list
		SLinkedList list = new SLinkedList();
		LinkedListQueue llq = new LinkedListQueue();
		
		//ask for input
		System.out.println("please enter number of strings:");
		Scanner scanner = new Scanner(System.in);
		//gets input+saves it
		long numStrings = scanner.nextLong();
		System.out.println("Strings entered are : " + numStrings );
		
		
		// Put some strings onto the queue
		System.out.println("About to enqueue srtings onto queue:");
		
		//start of timing
		long	startTimeEn = System.currentTimeMillis();
	
		
		//for loop with random int for i going into queue
		for (int i =0;i<numStrings;i++){
			//adds random number to queue
		int	i2 =(int) (Math.random()*100);
			llq.enqueue(i2);
		}
		//timing part//enqueue part//end part
		long	endTimeEn = System.currentTimeMillis() - startTimeEn;
			System.out.println("Total time taken for enqueue: " +endTimeEn + "ns");
	
		System.out.println("About to dequeue the strings ...");
		//start of time zone
		long startTimedq = System.nanoTime();
		
				while(! llq.isEmpty()) {
					//reuse code from earlier labs , word is number in this case
					int word = (int)llq.dequeue(); // Note: have to cast Objects popped to String
					System.out.println( "strings dequeued: " + word);
				}
				//timing part//dequeue time//end time
	
				long endTimedq = System.nanoTime() - (startTimedq );
				System.out.println("Total time taken for dequeue: " +endTimedq + "ms");
		
				
				System.out.println("Total time taken for dequeue: " +endTimedq + "ms");
				System.out.println("Total time taken for enqueue: " +endTimeEn + "ns");
				System.out.println("Total time taken : " +endTimeEn + endTimedq + "ns" );
		
		
	
	}

	public static void display(SLinkedList list)
	{
		String alltext = "";
		Boolean haveNode = list.gotoHead();
		while (haveNode) {
			alltext +=  " " + list.getCurr();
			haveNode = list.gotoNext();
		}
		
		System.out.println("Full List (" + list.size() + " els): " + alltext);
	}

}
