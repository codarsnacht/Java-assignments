
public class LinkedListQueue implements Queue {
	
	protected Node head;	 // head node of the list
	  protected Node tail;	 // tail node of the list
	  protected Node curr;	 // node referencing current position in the list  
	  protected long size;	 // number of nodes in the list

	
	
	public LinkedListQueue(){
		 tail = curr = head = null;
		    size = 0;
		
	}
	
	

	@Override
	public void enqueue(Object n) {
		  Node node = null;
		if(isFull()){
			  System.out.println("Cannot enqueue object; queue is full.");
			  return;
		  }
		  else 
			tail.setNext(node); // tail is increased for every new node
		  tail = node;  // tail is now new node 
		  size++; // counter
		      
	}

	@Override
	public Object dequeue() {
		Object toReturn =null;
		if(isFull()){
			  System.out.println("Cannot enqueue object; queue is empty.");
			  return null;
		}
			  else
				  head.setElement(toReturn);//gets head node
				head = head.getNext();  // goes to next node //new head is head +1 //
		size--; //  counter // reduces size of array
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		 return ( size==0);    //  Returns true if this queue is empty and false otherwise. 
		
	}

	@Override
	public boolean isFull() {
	return false;
	
		//return( tail == size-1);
	}

	@Override
	public Object front() {
		if (isEmpty())
			 return null;
		
		return head; // returns head node 
	}

}
