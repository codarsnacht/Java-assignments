/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */

import javax.swing.JOptionPane;

public class ArrayQueue implements Queue 
{
	 protected Object Q[];				// array used to implement the queue 
	 protected int rear = -1;			// index for the rear of the queue
	 protected int capacity; 			// The actual capacity of the queue array
	 public static final long CAPACITY = 100000000;	// default array capacity//expanded final capacity
	  
	     
	   
	 public ArrayQueue() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public ArrayQueue(long cap) {
		  // this constructor allows you to specify capacity
		  capacity = (int) ((cap > 0) ? cap : CAPACITY); // Conditional Operator
		  Q = new Object[capacity]; 
	 }
	 
	 public void enqueue(Object n)
	 {
		 if (isFull()) {
			 System.out.println( "Cannot enqueue object; queue is full.");
			 return;
		 }
		
		 rear++;
		 Q[rear] = n;
	 }
	 
	 public Object dequeue()
	 {
		 // Can't do anything if it's empty
		 if (isEmpty())
			 return null;
		 
		 Object toReturn = Q[0];
		 
		 // shuffle all other objects towards 0
		 int i = 1;
		 while (i <= rear) {
			 Q[i-1] = Q[i];
			 i++;
		 }
		 rear--;
		 return toReturn;
	 }
	 
	 public boolean isEmpty()  {
	     return (rear < 0);
	 }
	 
	 public boolean isFull() {
		 return (rear == capacity-1);
	 }
	 
	 public Object front()
	 {
		 if (isEmpty())
			 return null;
		 
		 return Q[0];
	 }
}