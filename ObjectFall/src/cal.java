import java.math.*;
public class cal {

	double Lh;
	
	public void setheightFLoor(double h) {
		Lh = h;
		int initial = 0;
		double acc = 9.81;
		double fin1 =  (2*9.81*Lh);
		double finalSpeed = Math.pow( fin1, .5);//allows for power maths 
		double time = (finalSpeed - initial )/acc;
		//convert to get floor again
	double	LH = ((Lh+2.5)/2.5);
		System.out.println("Time taken to fall "+ LH + " floors is " + time+ " seconds" );
		System.out.println("Speed when object impacted ground is " + finalSpeed+ " m/s");
		
	}

	public void setheightMeters(double meters) {
		Lh = meters;
		int initial = 0;
		double acc = 9.81;
		double fin1 =  (2*9.81*Lh);
		double finalSpeed = Math.pow( fin1, .5);//allows for power maths 
		double time = (finalSpeed - initial )/acc;
		System.out.println("Time taken to fall "+ Lh + " meters is " + time + " seconds" );
		System.out.println("Speed when object impacted ground is " + finalSpeed + " m/s");
	}

}
