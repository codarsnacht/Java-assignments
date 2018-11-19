package lab9;

import java.util.ArrayList;
import java.util.Collections;

public class Wallet {
	private String name;
	private ArrayList<Currency>Curr = new ArrayList<Currency>() ;
	
	
	public Wallet(String string) {
		
		name = string;
		
	}

	public void addCurrency(Currency currency){

		Curr.add(currency);
	}
	
	/*
	 * This method calculates and returns the total Euro value of 
	 * each currency in the wallet
	*/
	public double getTotalEuroValue(){
		
	    double sum = 0;
		for (Currency z : Curr){
		
			sum += z.euroValue;
			
		}
		return sum;
	}
	
	/*
	 * This method sorts the currencies in ascending order according to their euro Values
	*/
	public void sort(){
		//TODO
		Collections.sort(Curr);
		 System.out.println("After Sorting:");
		 
				System.out.println(this);
			
	}
	
	@Override
	/*
	 * The toString() method returns a String value of each currency and its amount in the wallet
	 * each currency- amount pair is separated by a comma
	 * e.g. USD:100,CAD:250,GBP:99,AUD:123
	 * 
	*/
	public String toString(){
		//TODO
		//return null;
		// idea , print USA = x EUR
		//return  Curr.get(0) + Curr.get(1) + Curr.get(2) + Curr.get(3);
		String ab = "";
		for (Currency counter : Curr){
			ab += counter.getCurrencyName() + ":" + counter.getAmount() +",";
			ab += counter.getCurrencyName() + ":" + counter.getEuroValue() +","; // printing out euro value as well
			
		}
		return ab ;
	}
	
}
