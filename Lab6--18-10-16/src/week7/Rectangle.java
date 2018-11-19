package week7;

/**
 * Rectangle class represents a rectangle 
 * in 2 dimensional space
 * It is defined by a Point that represents its top left hand corner
 * and by its width and height
 */

	


public class Rectangle extends Figure {
		
		private Point p;
		private double x;
		private double y;
		
		
	public Rectangle(Point point1, double d, double e) {
		// TODO Auto-generated constructor stub
		//this{dot} etc
		this.p = point1;
		this.x = d;
		this.y = e;
		
		double Rarea = x*y;
		System.out.println("Area of rectangle is " + Rarea);
	}

	@Override
	public double getArea() {
		
		return x * y;
		
	}

	@Override
	public int getFigures() {
		 
		return  1;
	}


		
	}

