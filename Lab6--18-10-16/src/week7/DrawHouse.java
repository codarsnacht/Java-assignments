package week7;

public class DrawHouse {
	public static void main(String[] args) {
	// house consists of a square base , with a triangle roof and a rectangle chimley on the side
	
		
		// points on grid required
		int[] input = {1,2,3,4};
		
		//create new plan for house
		plan house = new plan();
		
		Point pointH1 = new Point(input[0] , input[2]);
		Rectangle ground = new Rectangle(pointH1, input[1], input[1]);//actually a square but same method applies to both
		
		Point pointH2 = new Point ( input[2], input[3]);
		Rectangle chim = new Rectangle(pointH2, input[0], input[2]);//chimmley //chimney
		
		Point pointH3 = new Point ( input[0], input[3]);
		triangle roof = new triangle(pointH3, input[0], input[2]);//roof
		
		house.add( ground);
		house.add( chim);
		house.add( roof);
		
		
		//print area
				house.printArea();
				//print number of shapes
				house.printNumShapes();
		
		
	
	}
}
