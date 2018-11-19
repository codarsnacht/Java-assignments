package question3_soln;




/**
 * Point class represents the x, y coordinates of a single point
 * in 2 dimensional space
 */

public class Point  {
	
	private double xCoordinate;
	private double yCoordinate;

	public Point(double d, double e) {
		setxCoordinate(d);
		setyCoordinate(e);
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	


}
