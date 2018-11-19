package lab9.copy;



public abstract class Currency implements Comparable<Currency> {

	protected  String country; // e.g. Canada
	protected  String currencyName; // Canadian Dollar
	protected double amount; // e.g. 100.0
	protected double euroValue; // e.g. 70.03 (the value in euros)
	
	public Currency(int amt){
		setAmount(amt);
	}

	public String getCountry(){
		return this.country;
	}
	
	public String getCurrencyName(){
		return this.currencyName;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void setAmount(double amt) {
		if(amt<0){
			throw new IllegalArgumentException("amount cannot be less than zero: " + amt);
		}
		this.amount = amt;
	}
	public  double getEuroValue(){
		Converter convert = Converter.getConverter();
		convert.setEuroValue(this);
		return this.euroValue;
	}
	
	public void setEuroValue(double val){
		this.euroValue = val;
	}
	
	@Override
	public int compareTo(Currency o) {	
		if (this.getEuroValue()==o.getEuroValue()){
			return 0;
		}
		
		if (this.getEuroValue() > o.getEuroValue()){
			return 1;
		}
		
		return -1;
	}
	
	@Override
	public String toString(){
		return this.getCurrencyName() +":"+ this.getAmount();
	}
	
}
