
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class chef implements Runnable {

	//queues to hold the pre-prepared orders and ther orders ready to be served
	protected BlockingQueue<String> toCookQueue = null;
	protected BlockingQueue<String> toServeQueue = null;

	//chefs name
	private String name;
	//counters for perpared orders
	private int pizzasCooked = 0;
	private int burgersCooked = 0;
	private int fishCooked = 0;
	
	//constructor
	public chef(BlockingQueue<String> ToCook, BlockingQueue<String> ToServe,String name) {
		this.toCookQueue = ToCook;
		this.toServeQueue = ToServe;
		this.name=name;
	}

	
	@Override
	public void run() {

		while(toCookQueue.size()>0) {
			String toCook = null;
			try {
				toCook = toCookQueue.take();
				if(toCook.contains("Neapolitan Pizza")) {
					pizzasCooked++; //adds +1 to the number of pizzas a chef prepared
				}
				else if(toCook.contains("Fish n Chips")) {
					fishCooked++;//adds +1 to the number of fish a chef prepared
				}
				else if(toCook.contains("Cheese Burger")) {
					burgersCooked++;//adds +1 to the number of burgers a chef prepared
				}
				
				toServeQueue.offer(toCook); //gives perpared order to the toServe queue
				System.out.println("Chef " +name+ " is preparing " + toCook);//prints out what order the chef has currently prepared
				Thread.sleep(150);//chef takes a breather to make anohter meal
			}
			//catches exception
			catch (InterruptedException e) {
				e.printStackTrace();
			}	}} //closes off the run()
	
	//getters and setters for the name of the chef and what orders they prepared

	public String getName() {
		return name;
	}

	public int getFish() {
		return fishCooked;
	}

	public int getBurgers() {
		return burgersCooked;
	}

	public int getPizzas() {
		return pizzasCooked;
	}
	
	//returns total number of orders perpared
	public int getTotal(){
		return fishCooked + burgersCooked + pizzasCooked;
	}
	//Method to print out what is required and to same some space in the main class
	public String finalPerpared(){
		return "Chef "+name+" finished perparing "+ getTotal() + " orders including "+getBurgers()+" burgers, "+getFish()+" fish and "+getPizzas()+" pizzas";
	}
	}


