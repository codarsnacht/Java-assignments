/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */

// dequeue does not  stop after the 4 words are dequeued and continues to output words from the queue.

package QueueArray;
import javax.swing.JOptionPane;

public class ArrayQueue implements Queue 
{
	 protected Object Q[];				// array used to implement the queue 
	 protected int rear = -1;			// index for the rear of the queue
	 
	 protected int front = 0, rear1 = 0 , count = 0; // index for front and rear of queue , count for counter of elements in array
	
	 protected int capacity; 			// The actual capacity of the queue array
	 public static final int CAPACITY = 1000;	// default array capacity
	   
	 public ArrayQueue() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public ArrayQueue(int cap) {
		  // this constructor allows you to specify capacity
		  capacity = (cap > 0) ? cap : CAPACITY; // Conditional Operator
		  Q = new Object[capacity]; 
	 }
	 
	
	 
	
	 //change for assingment
	 public void enqueue(Object n) {
	 
     if(isFull()){
    	 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full.");
		 return;
     }else{
    	  Q[rear1] = n;
         rear1 = (rear1 + 1) % capacity;  // mod is required for circular arrays
         
         count++;//increases count of elements in array
     }
 }
	 

	 //change for assingment
	
	 
	 public Object dequeue() {
		 //if empty , returns null
	        if(isEmpty()){
	        	 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is empty.");
	    		 return null;
	        }else{
	            Object toReturn = Q[front]; 
	        
	             Q[front] = null;
	            front = (front + 1) % capacity; // mod is required for circular arrays
	            count--; // reduces amount in array
	            return toReturn; //returns each element 

	        }
	       
	    }
	 
	 
	 //changed
	 public boolean isEmpty()  {
	    // return (rear < 0);
		 return ( count==0);    //  Returns true if this queue is empty and false otherwise. 
	 }
	 
	 
	 public boolean isFull() {
		return( rear == capacity-1);
	          
	 }
	 
	 public Object front()
	 {
		 if (isEmpty())
			 return null;
		 
		 return Q[0];
	 }
}