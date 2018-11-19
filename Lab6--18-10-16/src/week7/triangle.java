package week7;

public class triangle extends Figure  {

	private Point p;
	private double x;
	private double y;
	
	
	public triangle(Point pointH3, int i, int j) {
		this.p = pointH3;
		this.x = i;
		this.y = j;
		
		
		double Tarea = (x*y)/2;
		System.out.println("Area of triangle is " + Tarea);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (x*y)/2;
	}

	@Override
	public int getFigures() {
		// TODO Auto-generated method stub
		return 1;
	}

}
