package week7;

/**
 * Circle class represents a circle 
 * in 2 dimensional space
 * It is defined by a Point that represents its top left hand corner
 * and by its width and height
 */

public class Circle extends Figure {
	double radius;
	private Point point;

	public Circle(Point hub1, double d) {
		this.point = hub1;
		this.radius = d;
		
		double Carea = Math.PI * radius * radius;
		
		System.out.println("area of circle is " + Carea );
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		
		return Math.PI * radius * radius;
	}

	@Override
	public int getFigures() {
		// watch video for getting numfiles 
		return 1;
	}
	
	//ToDo : you must implement the functionality of the Circle class

}
