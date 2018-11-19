package week7;

import java.util.ArrayList;

/**
 * a Drawing object is composed of number of basic shape objects (e.g Rectangle, Circle, Point)
 * and other Drawing objects
 *
 */
public class Drawing extends Figure {


	
	
	ArrayList<Figure> figures ;
	
	public Drawing(){
		figures = new ArrayList<Figure>();
	}
	
	public void add( Figure body){
		figures.add(body);
		
	}
	

	

	public void printArea() {
		// TODO Auto-generated method stub
		System.out.println("my total area is " + getArea() );
		
	}

	@Override
	public double getArea() {
		double totalArea = 0;
		for ( Figure fig : figures){
			totalArea += fig.getArea();
		}
		return totalArea;
	}

	@Override
	public int getFigures() {
		// watch video for getting numfiles 
		int totalFigs = 0;
		for ( Figure fig : figures){
			totalFigs += fig.getFigures();
		}
		return totalFigs;
	}

	public void printNumShapes() {
		System.out.println("Number of shapes are " + getFigures());
		
	}
	
	
	//ToDo : you must implement the functionality of the Drawing class

}
