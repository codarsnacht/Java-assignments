/**
 * M Madden M Schukat: Test the Linked List implementation of the Queue.
 * We will compare it with the ArrayStack: both should work the same.
 * 
 * Note: students may do this comparison different ways.
 */

import javax.swing.JOptionPane;


public class LLQueueTest 
{
	public static void main(String[] args) 
	{
		// Create two queues, one using an ArrayQueue and one that's a LLQueue.
		Queue qa = new ArrayQueue(); 
		Queue ql = new LLQueue(); 
		
		// Put some strings onto each queue
		JOptionPane.showMessageDialog(null, "About to enqueue words onto both LL and Array queues: \nThe end is nigh!");
		qa.enqueue("The");
		qa.enqueue("end");
		qa.enqueue("is");
		qa.enqueue("nigh!");
		
		ql.enqueue("The");
		ql.enqueue("end");
		ql.enqueue("is");
		ql.enqueue("nigh!");

		// Now dequeue items from both queues and compare results
		JOptionPane.showMessageDialog(null, "About to dequeue the words from both queues...");
		while(! qa.isEmpty()) {
			String word1 = (String)qa.dequeue(); // Note: have to cast Objects popped to String
			String word2 = (String)ql.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Words dequeued: " + word1 + ", " + word2 + "\n" +
					(word1.equals(word2) ? "they match!" : "ERROR: don't match!"));
		}
		// make sure both are empty
		JOptionPane.showMessageDialog(null, "After dequeueing all: Empty? " + qa.isEmpty() + " and " + ql.isEmpty());
		
		System.exit(0);
	}
}
