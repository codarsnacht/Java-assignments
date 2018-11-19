import java.text.DecimalFormat;

public class rational {
	private static rational zero = new rational(0, 1);
	
	private double num;//numerator
	private double den;//denominator
	
	
	private double lownum;// lowest common numerator
	private double lowden;//lowest common denominator
	
	
	public rational(double numerator, double denominator) {
		if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }
		num = numerator;
		den = denominator;
		//gets greatest common divisor
		double g =  gcd(numerator, denominator);
		 this.lownum = numerator  / g;
	        this.lowden = denominator / g;
		
	}
	
	public rational plus(rational b){
		double numerator   = (this.num * b.den) + (this.den * b.num);
        double denominator = this.den * b.den;
        return new rational(numerator, denominator);
	}
	
	public rational minus(rational b){
		double numerator   = (this.num * b.den) - (this.den * b.num);
       double denominator = this.den * b.den;
        return new rational(numerator, denominator);
	}
	
	public rational multi(rational b){
		return new rational(this.num * b.num, this.den * b.den);
	}
	
	// return (1 / this) for division
    public rational reciprocal() { 
    	return new rational(den, num); 
    	}
	
	
    // division of a/b / c/d = a/b * d/c
	public rational divide(rational b){
		
		return this.multi(b.reciprocal());
	}

	
    public String toString() { 
    	
        if (den == 1) return num + "";
        else          return num + "/" + den ;
    }
    
    //greatest common divider //highest common factor
    private static double gcd(double a, double b) {
        if (0 == b) return a;
        else return gcd(b, a % b);}
	
	

    public rational lowestForm(){
    	return new rational(lownum,lowden);
    	
    }
    //gets decimal value
    public double finalnum(){
    	 double number = num/den;
    	 
    	return number ;
    }
	
	
}
