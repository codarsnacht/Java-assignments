package question3_soln;

/**
 * Rectangle class represents a rectangle 
 * in 2 dimensional space
 * It is defined by a Point that represents its top left hand corner
 * and by its width and height
 */

public class Rectangle extends AbstractShape{
	
	private Point corner;
	private double width;
	private double height;

	public Rectangle(Point point1, double d, double e) {
		corner = point1;
		width = d;
		height = e;

	}

	@Override
	public double getArea() {
		return width * height;
		
	}

	public Point getCorner() {
		return corner;
	}

	public void setCorner(Point corner) {
		this.corner = corner;
	}

}
