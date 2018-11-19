package ariana;

import java.util.Scanner;

public class Rocket {

	private double altitude;
	private double acceleration;
	private double velocity;
	private double thrust;
	

	private Computer computer;
	private double destination= 4000;
	private int time;
	//new code
	private float oxygen;
	private float fuel;
	
	
	public Rocket(){
		this.computer = new Computer();
		this.time = 0;
		this.thrust = 0;
		this.altitude = 0;
		this.acceleration = 0;
		this.velocity = 0;
		//new code
		this.oxygen = 0;
		this.fuel = 0;
		
	}
	
	public void setDestination(double destination){
		this.destination = destination;
	}
	
	//part 3
	public double getDestination(){
		return this.destination;
	}

	
	public double getAltitude() {
		return this.altitude;
	}

	public void reportStatus(){
		System.out.printf("Ariana 5: Time: %d seconds \n", time);
		if (!computer.getMalfunctionStatus()){
			System.out.printf("All systems go. \n");
		}else{
			System.out.printf("Major error reported by computer \n");
			System.out.printf("Mission abort\n");
			System.out.printf("Reporting telemetry status:\n");
		}
		
		System.out.printf("thrust: %f \n", thrust);
		System.out.printf("velocity: %f \n", velocity);
		System.out.printf("acceleration: %f \n", acceleration);
		System.out.printf("altitude: %f \n\n", altitude);
		//new code
		System.out.printf("oxygen is : %f \n\n" , oxygen );
		System.out.printf("fuel is : %f \n\n" , fuel );
	}

	public void blastOff() {
		System.out.printf("\nAriana 5 Blastoff! \n\n");
		computer.goThrusters();
	}
	
	public void getTelemetry() {
		
		this.time = computer.getTimeSinceLaunch();
		this.altitude = computer.getAltitude();
		this.velocity = computer.getVelocity();
		this.thrust = computer.getThrust();
		this.acceleration = computer.getAverageAcceleration();
		//new code
		this.oxygen = computer.getOxygen(oxygen);
		this.fuel = computer.getFuel(fuel);
	}

	public boolean hasMajorError() {
		return computer.getMalfunctionStatus();
	}

	public boolean isMissionAccomplished() {
		if (this.getAltitude() < destination){
			computer.goThrusters();
			return false;
		}else{
			System.out.println("mission accomplished. Ariana reached " + destination);
			return true;
		}	
	}

	
	//new code
	public void setOxygen(float oxygen) {
		// TODO Auto-generated method stub
		this.oxygen = oxygen;
		System.out.println("oxygen is :" + oxygen );
		
	}

	public void setFuel(float fuel) {
		// TODO Auto-generated method stub
		this.fuel = fuel;
		System.out.println("fuel is: " + fuel);
		
	}

}
