package lab9;

public class USD extends Currency {

	public USD(double i) {
		// TODO Auto-generated constructor stub
		country = "USA";
		currencyName= "USD";
		amount = i;
		 
		new Converter().setEuroValue(this);
	}

}
