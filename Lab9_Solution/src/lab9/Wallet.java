package lab9;

import java.util.ArrayList;
import java.util.Collections;


public class Wallet {
	
	private String name;
	private ArrayList<Currency> currencies = new ArrayList<Currency>();
	
	public Wallet(String name) {
		this.setName(name);
	}

	public void addCurrency(Currency currency){
		currencies.add(currency);
	}
	
	/*
	 * This method calculates and returns the total Euro value of 
	 * each currency in the wallet
	*/
	public double getTotalEuroValue(){
		
		double total = 0;
		for(Currency curr : currencies){
			total+=curr.getEuroValue();
		}
		return total;
	}
	
	/*
	 * This method sorts the currencies in ascending order according to their euro Values
	*/
	public void sort(){
		Collections.sort(currencies);
	}
	
	@Override
	/*
	 * The toString() method returns a String value of each currency and its amount in the wallet
	 * each currency- amount pair is separated by a comma
	 * e.g. USD:100,CAD:250,GBP:99,AUD:123
	 * 
	*/
	public String toString(){
		String out= "";
		
		for (Currency curr : currencies){
			out=out+curr +","; //note how the toString() method of curr is implicitly called
		}
		out = out.substring(0, out.length()-1); // clips off the trailing comma
		return out;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
