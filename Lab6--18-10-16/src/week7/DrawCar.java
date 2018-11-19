package week7;

/**
 * main method for demonstrating how these Shapes can be assembled into the shape of a Car
 *
 */
public class DrawCar {

	public static void main(String[] args) {

		// for this program, we'll assume that the input is an array of double values
		double[] input = {2,3,3,1,3,4,1,1,0.5,2.5,4.5};

		//create a new Drawing
		Drawing car = new Drawing();

		Point Point1 = new Point(input[0], input[1]); // (x, y) coordinates
		Rectangle body = new Rectangle(Point1, input[2], input[3]); // (top left hand point, width, height)

		Point Point2 = new Point(input[4], input[5]); // (x, y) coordinates
		Rectangle top = new Rectangle(Point2, input[6], input[7]); // (top left hand point, width, height)

		car.add(body); // add body to car Drawing
		car.add(top); // add top to car Drawing

		Point hub1 = new Point(input[9], input[0]); // (x, y) coordinates
		Point hub2 = new Point(input[10], input[0]); // (x, y) coordinates

		Circle wheel1 = new Circle(hub1, input[8]); // (centre, radius)
		Circle wheel2 = new Circle(hub2, input[8]); // (centre, radius)

		Drawing chassis = new Drawing();
		chassis.add(wheel1); // add wheel1 to chassis Drawing
		chassis.add(wheel2); // add wheel2 to chassis Drawing

		car.add(chassis); //add chassis Drawing to car Drawing

		//print area
		car.printArea();
		//print number of shapes
		car.printNumShapes();

	}

}
