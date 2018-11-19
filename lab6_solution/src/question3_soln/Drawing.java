package question3_soln;

import java.util.ArrayList;


/**
 * a Drawing object is composed of number of basic shape objects (e.g Rectangle, Circle, Point)
 * and other Drawing objects
 *
 */
public class Drawing extends AbstractShape{
	
	ArrayList<AbstractShape> shapes = new ArrayList<AbstractShape>();
	

	public void  add(AbstractShape s){
		shapes.add(s);
	}

	

	@Override
	public double getArea() {
		
		double area = 0;
		
		for(AbstractShape s : shapes){
			area+=s.getArea();
		}
		return area;
		
	}

	public int getNumShapes() {
		
		int total = 0;
		
		for(AbstractShape s : shapes){
			if(!(s instanceof Drawing)){
				total++;
			}else{
				total+=((Drawing)s).getNumShapes();
			}
		}
		return total;
	}

	

}
