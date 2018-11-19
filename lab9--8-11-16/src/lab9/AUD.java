package lab9;

public class AUD extends Currency {

	public AUD(double i) {
		// TODO Auto-generated constructor stub
		country = "Australia";
		currencyName= "AUD";
		amount = i;
		 
		new Converter().setEuroValue(this);
	}

}
