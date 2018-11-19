
public enum ball {
		   BASEBALL(149, 73),
	       BASKETBALL(624, 239),
	       FOOTBALL(450 , 216),
	       GOLF(46, 43),
	       POOL(156, 60),
	       SOFTBALL(180, 97),
	       TENNIS(59, 64),
	       VOLLEYBALL(260, 218);
	
	public final double weight;
	public final double diameter;
	ball(double weight , double diameter){
		this.weight = weight;
		this.diameter = diameter;
	}
	
	public double weight(){return weight;}
	  		
	public double diameter(){return diameter;}
	
	
	public double  getCircumference(){
		double circ = diameter*Math.PI;
		return circ;
	}
	
	public double getVolume(){
						//4/3 * radius^3 * Pi // radius = diameter/2
		double volume = (4.0/3.0)*(Math.pow((diameter/2), 3))*Math.PI;
		return volume;
	}
	
public static void main(String[] args) {
		for(ball b:ball.values()){
		
			System.out.printf("%s Weight:  %fg  Diameter: %fmm, Circumference: %fmm  Volume: %smm^3 %n",b,b.weight(),b.diameter(),b.getCircumference() , b.getVolume()); 
		}
	
	rational x,y,z;

	rational r1 = new rational(BASEBALL.weight(),BASKETBALL.weight());
	rational r2 = new rational(FOOTBALL.weight(),GOLF.weight());
	rational r3 = new rational(POOL.diameter(), SOFTBALL.diameter());
	rational r4 = new rational(TENNIS.diameter(),VOLLEYBALL.diameter());
	rational r5 = new rational(15,40);
		
	//15/40
	System.out.println("\nRational Numbers part:");
	System.out.println(r5.toString()+" = "+r5.lowestForm() +" = " + r5.finalnum());
	
	//r1+r2
	z=r1.plus(r2);
	System.out.println("\n"+r1 +" + "+ r2);
	System.out.println(z.toString()+" = "+ z.lowestForm() +" = " + z.finalnum());
	
	//r2 – r3
	z= r2.minus(r3);
	System.out.println("\n"+r2 +" - "+ r3);
	System.out.println(z.toString()+" = "+ z.lowestForm() +" = " + z.finalnum());
	
	//r3 * r4
	z=r3.multi(r4);
	System.out.println("\n"+r3 +" x "+ r4);
	System.out.println(z.toString()+" = "+ z.lowestForm() +" = " + z.finalnum());
	
	
//	r4 / r1
	z=r4.divide(r1);
	System.out.println("\n"+r4 +" / "+ r1);
	System.out.println(z.toString()+" = "+ z.lowestForm() +" = " + z.finalnum());
	
	}
}
