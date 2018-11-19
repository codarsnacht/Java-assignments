package lab9;

public class GBP extends Currency {

	public GBP(double i) {
		// TODO Auto-generated constructor stub
		country = "UK";
		currencyName= "GBP";
		amount = i;
		 
		new Converter().setEuroValue(this);
	}

}
