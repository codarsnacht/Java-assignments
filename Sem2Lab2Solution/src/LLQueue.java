import javax.swing.JOptionPane;

/** M Madden / M Schukat: Linked List implementation of Queue ADT  */

public class LLQueue implements Queue 
{
	 protected SLinkedList Q;			// linked list used to implement the queue 
	   
	 public LLQueue() {
		 Q = new SLinkedList();
	 }

	 public boolean isEmpty()  {
	     return (Q.size == 0); // Check whether the linked list is empty
	 }
	 
	 public boolean isFull() {
		 // Linked list has no specific limit on its capacity
		 return false;
	 }
	 
	 public void enqueue(Object n)
	 {
		 // We will enqueue at the tail of the linked list and dequeue at the head, 
		 // because there's a deleteHead method.
		 // No real need for the isFull() test; could remove it
		 if (isFull()) {
			 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full.");
			 return;
		 }
		 //To insert at the tail, go to the end and insert after it.
		 Q.gotoTail();
		 Q.insertNext(n);
	 }
	 
	 public Object dequeue()
	 {
		 // We will enqueue at the tail of the linked list and dequeue at the head,
		 // because there's a deleteHead method.
		 // Can't do anything if it's empty.
		 if (isEmpty())
			 return null;

		 // Get the object from the head of the list, then delete the head and return the object.
		 Q.gotoHead();
		 Object toReturn = Q.getCurr();
		 Q.deleteHead();
		 
		 return toReturn;
	 }
	 
	 public Object front()
	 {
		 if (isEmpty())
			 return null;
		 
		 // Go to the head of the list and return that object without deleting it.
		 Q.gotoHead();
		 return Q.getCurr();
	 }
}