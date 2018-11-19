package ariana;

public class Computer{

	private static byte TIME_BETWEEN_READINGS = 5;
	private byte numReadings;

	private Thrusters thrusters;
	private double altitude;
	private double ave_acceleration;
	private double velocity;
	private boolean criticalError;
	private double thrust;
	// new code
	private float oxygen;
	private float fuel;
	private boolean oxyError;
	private double destination;

	public Computer() {
		this.thrusters = new Thrusters(this);
		this.thrust = 0;
		this.velocity=0;
		this.ave_acceleration=0;
		this.altitude = 0;
		this.numReadings= 0;
		this.criticalError = false;
		//new code
		this.oxygen = 0;
		this.fuel = 0;
		this.destination = 0;
	}


	private double calculateAltitude (double acceleration){
		int time = numReadings * TIME_BETWEEN_READINGS;
		long alt = (long) (0.5 * acceleration * time * time);
		return alt;
	}
// changed short alt to long alt as short only goes up to ~32,256 
	private boolean getAltitudeError(double alt) {
		if (alt< altitude){
			System.out.println("Major Telemetry Malfunction: altitude dropping ");
			return true;
		}
		return false;
	}

	private boolean getOxyError(double oxi) {
		if (oxi< oxygen/10){
			System.out.println("Major Telemetry Malfunction: low oxygen ");
			return true;
		}
		return false;
	}
		
	public void goThrusters() {
		thrusters.go();
	}

	public double getVelocity(){
		return velocity;
	}

	public double getAverageAcceleration(){
		return ave_acceleration;
	}

	public double getAltitude(){
		return altitude;
	}

	public double getDestination( double destination){
		return destination;
	}
	
	private double calculateAverageAcceleration(double newVelocity){
		double current_acceleration = (newVelocity - velocity)/TIME_BETWEEN_READINGS;
		double ave_acceler = current_acceleration + (ave_acceleration * numReadings)/++numReadings;
		return ave_acceler;
	}

	private void updateTelemetryData(double thrust) {
		double newVelocity = calculateVelocity(thrust);
		this.ave_acceleration= calculateAverageAcceleration(newVelocity);
		double alt= calculateAltitude(ave_acceleration);
		this.criticalError = getAltitudeError(alt);
		this.oxyError = getOxyError(oxygen);
		
		this.altitude = alt;
		this.velocity = newVelocity;
		this.thrust = thrust;
		//new code 
		float newOxygen = oxygen/10 ;
		this.oxygen = newOxygen ;
	}

	public void setThrust(double thrust) {
		updateTelemetryData(thrust);
	}

	private double calculateVelocity(double thrust) {
		// very simplistic thrust calculation!
		return thrust/100;

	}

	public boolean getMalfunctionStatus(){
		return this.criticalError;
		//return this.oxyError;
		//return this.fuelError;
	}


	public double getThrust() {
		return this.thrust;
	}


	public int getTimeSinceLaunch() {
		return numReadings*TIME_BETWEEN_READINGS;
	}

//new code
	//use of getters and setters required
	public float getOxygen(float oxygen) {
		// warnings dont work , would be nice if they did
		
		float startOxy = oxygen;
		float newOxy = oxygen*1/2 ;
		if ( startOxy/10 > newOxy){
			System.out.println("WARNING  OXYGEN LOW\n");
		}
		oxygen = newOxy;
		return oxygen;
	}


	public float getFuel(float fuel) {
		// TODO Auto-generated method stub
		float startFuel = fuel;
		float newFuel = fuel*1/3;
		if ( startFuel/10 > newFuel){
			System.out.println("WARNING  FUEL LOW\n");
		}
		fuel = newFuel;
		return fuel;
	}


}
