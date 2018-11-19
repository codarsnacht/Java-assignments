package lab9;

public class CAD extends Currency {

	public CAD(double i) {
		// TODO Auto-generated constructor stub
		country = "Canada";
		currencyName= "CAD";
		amount = i;
		 
		new Converter().setEuroValue(this);
	}

}
