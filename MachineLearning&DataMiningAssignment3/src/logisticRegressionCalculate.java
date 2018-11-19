import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import sun.applet.Main;

public class logisticRegressionCalculate extends LinkedList {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Owl owl1 = null;
		LinkedList<Owl> ll1 = new LinkedList<Owl>();	
		String csvFile = "C:\\Test\\owls.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        //some below are not necessary
        int count=0;
        int count0=0;
        int count1=0;
        int count2=0;
        double barnAvg = 0;
		 double longAvg = 0;
		 double snowAvg = 0;
        int finalcount0;
        int finalcount1;
        int finalcount2;
        
        
        //read in the file
        try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// comma deliminator
				String[] owlCase = line.split(cvsSplitBy);

				owl1 = new Owl(Double.parseDouble(owlCase[0]), Double.parseDouble(owlCase[1]),
						Double.parseDouble(owlCase[2]), Double.parseDouble(owlCase[3]), owlCase[4]);
				//sends attributes to matrixCal method, 
				matrixCal(owlCase[0],owlCase[1],owlCase[2],owlCase[3] , owlCase[4]);
				ll1.add(owl1);//adds to linked list
				//System.out.println();
				switch (owlCase[4]){
				case "BarnOwl": 	
		       	count0++;
		            break;
		        case "SnowyOwl":
		       	 count1++;
		            break;
		        case "LongEaredOwl":
		        	count2++;
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid Owl: " + owlCase[4]);
				}
				
				count++; //total number of enteries
		//System.out.println(" count is:"+count + " barn owl count is:"+count0);
				
				//sets counters to final count, might be useful when doing average
			finalcount0 = count0;
			finalcount1 = count1;
			finalcount2 = count2;
			
			//attempt to send attributes to method, would not print, thinking it has something to do with going through
			//the linked list
	/*		for(Owl e:ll1){
				if(e.getType()=="SnowyOwl"){
					System.out.println("test");
					matrixCal(e.getBodyLength(),e.getBodyWidth(),e.getWingLength(),e.getWingWidth() , e.getType(), count0);
				}if(e.getType()=="LongEaredOwl"){
					
					matrixCal(e.getBodyLength(),e.getBodyWidth(),e.getWingLength(),e.getWingWidth() , e.getType(), count0);
				}if(e.getType()=="BarnOwl"){
					
					matrixCal(e.getBodyLength(),e.getBodyWidth(),e.getWingLength(),e.getWingWidth() , e.getType(), count0);
				}
			}*/
			}
			
				
			}finally{//empty code
			}
        
			
		
		}

	

	/*private static void matrixCal(double bodyLength, double bodyWidth, double wingLength, double wingWidth, String type,
			int count0) {
		System.out.println("got this far");
		double a = bodyLength;
		double b = bodyWidth;
		double c = wingLength;
		double d = wingWidth;
		sigmoid(a*d-b*c, type, count0);
		
	}*/

	//method for the maths function to get determinant of the attributes, in the form of an (A B ) matrix
			//formula is A*D - B*C													//	    (C D )
	
	
	private static void matrixCal(String string, String owlCase, String owlCase2, String owlCase3, String owlCase4) {
		double a = Double.parseDouble(string);
		double b = Double.parseDouble(owlCase);
		double c = Double.parseDouble(owlCase3);
		double d = Double.parseDouble(owlCase2);
		//sends value ( negative number in all cases) to calculate the sigmoid value
		sigmoid(a*d-b*c, owlCase4);
	
	}

	
	//method for getting the sigmoid
	private static double sigmoid(double d, String owlCase4) {
		double vv = 1.0/(1.0 +Math.exp(d)); 
		System.out.println("for the "+ owlCase4 + ", the sigmoid result is as follows:"+vv );
		//getAvg(vv, owlCase4, count0); //not needed at time
		return vv;
	}
	
	
	//start of method to get the average sigmoid value for each type of bird
	private static void getAvg(double d, String owlCase4, int count0) {
		String birdName = owlCase4;
	
		//need to pass in the the average of the sigmoids
		//to do this, need to store all values of the sigmoids for each type of bird somewhere and call it later, once all are read
		//by the file reader
		//get average of each sigmoid
		
	}
	
	//space for comparing and then predicting which type of bird the attributes are
/*	//private static void predict( double sigAvg, string Birdname){
	//code implementation 
	//idea, calculate the sigmoid of the particilar attribute and then compare it to the saved averages
	 whichever avg this particilar sigmoid is closest to, it shall be predicted to that bird type 
	can read in the actual bird at a later time to see if prediction is correct
	
	example - sig value =0.2
	BOavg= 0.01 - 10.1
	LEavg= 0.11 - 0.4
	SOavg= 0.41 - 0.99
	
	with this, this example is predicted as a LongEared owl
	and so on
//}
	*/
}