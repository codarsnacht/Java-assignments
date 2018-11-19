package week7;

import java.util.ArrayList;

public class plan extends Figure {

	
	ArrayList<Figure> figures ;
	
	public plan(){
		figures = new ArrayList<Figure>();
	}
	
	public void add( Figure body){
		figures.add(body);
		
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
		int totalFigs = 0;
		for ( Figure fig : figures){
			totalFigs += fig.getFigures();
		}
		return totalFigs;
	}

	public void printArea() {
		// TODO Auto-generated method stub
		System.out.println("my total area is " + getArea() );
	}

	public void printNumShapes() {
		// TODO Auto-generated method stub
		//printing figures
		System.out.println("Number of shapes are " + getFigures());
		
	}

}
