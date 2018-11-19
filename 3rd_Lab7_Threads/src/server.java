import java.util.concurrent.BlockingQueue;

public class server implements Runnable {

	//servers name
	public String name;

	//queues , a to server queue and an input queue( queue from the chefs with the prepared food) 
	protected BlockingQueue<String> Queue = null;
	protected BlockingQueue<String> QueueToServe = null;

	public server(BlockingQueue<String> blockingQueue, BlockingQueue<String> QueueToServe, String name) {
		this.QueueToServe =QueueToServe;
		this.Queue = blockingQueue;
		this.name = name;
	}

	//counters for the orders that the servers served
	private int pizzasServed = 0;
	private int burgersServed = 0;
	private int fishServed = 0;

	@Override
	public void run() {
		//gets servers to initially wait so chefs can build up the orders so each server can serve
		try{
		Thread.sleep(750);} 
		catch(InterruptedException e){
			e.printStackTrace();
		}
		try {
			while (Queue.size() > 0) {
				String toServe = null;
				try {
					toServe = Queue.take();
					//makes the toServe queue a critical section 
				//allows only 1 server at a time to take an order to serve - with the "synchronized" of the toServe queue
					synchronized(toServe){
					if (toServe.contains("Pizza")) {
						pizzasServed++; //adds +1 to the number of pizzas a server served
						
					} else if (toServe.contains("Fish")) {
						fishServed++; //adds +1 to the number of fish & chips a server served
						
					} else if (toServe.contains("Burger")) {
						burgersServed++; //adds +1 to the number of cheese burgers a server served
						
					}
					QueueToServe.offer(toServe);
					System.out.println("Server " + name + " is serving " + QueueToServe.take()); //prints out what order a server is currently serving
					Thread.sleep(200);
					
				}//closes synchronized
					} //closes try
				
					//catches following exception
				catch (InterruptedException e) {
					e.printStackTrace(); 
				}
			}
		} finally {
			//nothing here
			//required to get class to compile
		}
	}
	
	//getters and setters for the name & orders served
	public String getName() {
		return name;
	}

	public int getFish() {
		return fishServed;
	}

	public int getBurgers() {
		return burgersServed;
	}

	public int getPizzas() {
		return pizzasServed;
	}
	//gets total number of orders served
	public int getTotal(){
		return fishServed + burgersServed + pizzasServed;
	}
	
	//method for printing out final form , Saves some space in the main , which does not need to contain all the code ,
											//just a call to this method
	public String finalServing(){
		return "Server "+name+" finished serving "+ getTotal() + " orders including "+getBurgers()+" burgers, "+getFish()+" fish and "+getPizzas()+" pizzas";
	}
	
	
}
