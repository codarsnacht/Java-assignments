package lab9.copy;

import java.util.HashMap;

public class Converter {
	
	private static Converter converter = new Converter();
	
	HashMap<String, Double> map = new HashMap<String, Double>();
	
	
	private Converter(){
		
	}
	
	public static Converter getConverter(){
		return converter;
	}
	
	public void setXChangeRate(String curr, double rate){
		
		map.put(curr, new Double(rate));
		
	}
	
	/*
	 * This method takes a currency object as a parameter 
	 * it looks ups its rate of exchange against the euro
	 * and then sets its euro value 
	 * 
	*/
	public void setEuroValue(Currency curr){
		String currency = curr.getCurrencyName();
		double rate = map.get(currency);
		double value = curr.getAmount() * rate;
		curr.setEuroValue(value);
	}
	
	
	/*
	 * This method takes a currency name as a parameter
	 * It returns its rate of exchange against the euro 
	 * 
	*/
//	private double find(String currencyName){
//		for (int i = 0; i< currencies.length; i++){
//			if(currencies[i].equals(currencyName)){
//				return rates[i];
//			}
//		}
//		return -1;
//	}
	
}
