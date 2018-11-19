package ariana;

public class Thrusters {

	private double thrust;
	private final static double MAX_THRUST= 100000 ;
	private final static double MIN_THRUST= 100 ;
	private Computer computer;

	public Thrusters(Computer computer){
		this.computer = computer;
		thrust = 0;
	}

	public void go(){
		generateThrust ();
	}

	private void generateThrust (){
		if (thrust < MAX_THRUST){
			thrust  = thrust + 1000* Math.random();
			computer.setThrust(thrust);
		}
	}
//part 3 new code
	private void Decelleration(double altitude , double destination , double velocity ){
		if ( altitude > destination/2){
			thrust = thrust - 1000*Math.random();
		}
		if ( velocity < MIN_THRUST){
			velocity = MIN_THRUST;
		}
		
	}
}
