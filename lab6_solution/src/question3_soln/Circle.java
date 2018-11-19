package question3_soln;

/**
 * Circle class represents a circle 
 * in 2 dimensional space
 * It is defined by a Point that represents its top left hand corner
 * and by its width and height
 */

public class Circle extends AbstractShape{
	
	private Point centre;
	private double radius;

	public Circle(Point hub1, double d) {
		this.centre = hub1;
		this.radius = d;
	}

	@Override
	public double getArea() {
		
		return Math.PI * radius * radius;
		
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	
}
