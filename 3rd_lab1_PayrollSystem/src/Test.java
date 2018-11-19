// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.CopticChronology;

// Java extension packages
import javax.swing.JOptionPane;

public class Test {
	
	
    // test Employee hierarchy
    public static void main(String args[]) throws UserException, InvalidDateException {
        Employee employee; // superclass reference
        String output = "";
        
        
        
        
        Boss boss=null;
        CommissionWorker commissionWorker =null;
        HourlyWorker hourlyWorker =null;
        PieceWorker pieceWorker =null;
        
  //joda time  test
        DateTime testDt = new DateTime();//creates datetime
        int month = testDt.getMonthOfYear(); // gets month
        
        DateTime year2017 = testDt.withYear(2017);//sets year as 2017 
        DateTime year2012 = testDt.withYear(2012);//testing for loop - 5 or more years ago
        
        
        DateTime bossSD = new DateTime(2001,4,9,10,31,34); //assign startdate
       // DateTime bossSD = new DateTime(1985, 6, 30, 13, 12,11); test1
      //  DateTime bossSD = new DateTime(2020, 8, 4, 10, 23,34);test2 for part 2 of assignment 2
       
        DateTime commSD = new DateTime(2010,7,22,11,41,24); // sets it as 2010
  //      DateTime commSD = new DateTime(1996, 2, 29, 9, 35,24);test3 for part 2 of assignment 2
//        DateTime commSD = new DateTime( 2010, 13, 9, 14, 45,24);test4 for part 2 of assignment 2
   
        DateTime hourSD = new DateTime(2015,11,2,15,12,55); // start date for hourly worker is 2015
      //  DateTime hourSD = new DateTime(2008, 10, 27, 8, 33,55);test5 for part 2 of assignment 2
        //DateTime hourSD = new DateTime(2003, 1, 18, 11, 14,55);test6 for part 2 of assignment 2
          
        DateTime pieceSD = new DateTime(2011,1,3,13,52,24); // start date for hourly worker is 2011
    //    DateTime pieceSD = new DateTime(1999, 2, 30, 16, 11,24);test7 for part 2 of assignment 2
      //  DateTime pieceSD = new DateTime(2015, 7, 8, 12, 37,24);test8 for part 2 of assignment 2
        
        Chronology calender = CopticChronology.getInstance(); // creates coptic calender
        
        
        //creates arraylist for employees
       ArrayList<Employee> new1 =new ArrayList<Employee>(10);
       
      //name , salary , start date//
       try{
      boss = new Boss("John", "Smith", 800.0, bossSD);
       }catch(InvalidDateException ec){
    	   System.out.println(ec.getLocalizedMessage());
       }
 
        
        finally{
        try{	
        
        commissionWorker =
                new CommissionWorker(
                "Sue", "Jones", 400.0, 3.0, 150, commSD);
        }catch(InvalidDateException ec){
        	System.out.println(ec.getLocalizedMessage());
        }
        finally{
	try{
         pieceWorker =
                new PieceWorker("Bob", "Lewis", 2.5, 200, pieceSD);
	}catch(InvalidDateException ec){
		System.out.println(ec.getLocalizedMessage());
	}

               
        finally{
       try{  hourlyWorker =
                new HourlyWorker("Karen", "Price", 13.75, 40, hourSD);
       }catch(InvalidDateException ec){
    	   System.out.println(ec.getLocalizedMessage());
       }
       }
	}
        }
        DecimalFormat precision2 = new DecimalFormat("0.00");

        
        
        
// Employee reference to a Boss
        employee = boss;
    if(boss!=null){
        try {
			output += employee.toString() + " earned $"
			        + precision2.format(employee.earnings()) + "\n"
			        + boss.toString() + " earned $"
			        + precision2.format(boss.earnings()) + "\n"
			        + "Start date for boss is the year "
			        + boss.getStartDate()+  "\n" 
			        + "Employee ID is : "
					+ boss.getEmployeeID() +   "\n";
		} catch (UserException e1) {
			//wage from assignment1
			 			output = "error in boss earnings ";
			System.err.println(e1.getLocalizedMessage());
			e1.printStackTrace();
			
		}
    }
        
        new1.add(boss); // adds boss to arraylist of type employee
   
        // Employee reference to a CommissionWorker
        employee = commissionWorker;
        if(boss!=null){
        try {
			output += employee.toString() + " earned $"
			        + precision2.format(employee.earnings()) + "\n"
			        + commissionWorker.toString() + " earned $"
			        + precision2.format(
			        + commissionWorker.earnings()) + "\n"
			        + "Start date for commission worker is the year "
			        + commissionWorker.getStartDate()+  "\n" 
			        + "Employee ID is : "
			        +commissionWorker.getEmployeeID() + "\n";   //gets employeeID
		} catch (UserException e1) {
			//wage from assignment1
			output = "error in commissionWorker earnings ";
			System.err.println(e1.getLocalizedMessage());
			e1.printStackTrace();
		}
        }
        new1.add(commissionWorker); 
        

        // Employee reference to a PieceWorker
        employee = pieceWorker;
        if(boss!=null){
        try {
			output += employee.toString() + " earned $"
			        + precision2.format(employee.earnings()) + "\n"
			        + pieceWorker.toString() + " earned $"
			        + precision2.format(pieceWorker.earnings()) + "\n"
			        + "Start date for piece worker is the year "
			        + pieceWorker.getStartDate()+  "\n" 
			        + "Employee ID is : "
			        + pieceWorker.getEmployeeID() + "\n";
		} catch (UserException e1) {
			//wage from assignment1
			output = "error in pieceWorker earnings ";
			System.err.println(e1.getLocalizedMessage());
			e1.printStackTrace();
		}
        }
        new1.add(pieceWorker); 
      
// Employee reference to an HourlyWorker
        employee = hourlyWorker;
        if(boss!=null){
        try {
			output += employee.toString() + " earned $"
			        + precision2.format(employee.earnings()) + "\n"
			        + hourlyWorker.toString() + " earned $"
			        + precision2.format(hourlyWorker.earnings()) + "\n"
			       	+ "Start date for hourly worker is the year "
			        + hourlyWorker.getStartDate()+  "\n" 
			        		 + "Employee ID is : "
					+ hourlyWorker.getEmployeeID() + "\n";
		} catch (UserException e1) {
			//wage from assignment1
			output = "error in hourlyWorker earnings ";
			System.err.println(e1.getLocalizedMessage());
			e1.printStackTrace();
		}
        }
        new1.add(hourlyWorker); 
        
        //looping through arraylist 
        //to tally up employee
        
        //not needed for assignment2
        
       /* for(Employee e:new1){
        	//condition to test dates if join date is 5 years 
        	//give bonus of $200
        	if ( e.getStartDate().isBefore(year2012)){
        		System.out.println(e.getFirstName() +" "+ e.getLastName() + " has been given bonus ");
        		double newEarn = 0;
				try {
					newEarn = e.earnings() + 200; // adds 200 bonus
				} catch (UserException e1) {
					//prints to consol, allows to show other earnings if error in one
					System.out.println("error in earnings ");
					System.err.println(e1.getLocalizedMessage());
					e1.printStackTrace();
				} 
        		System.out.println(e.getFirstName() +" "+ e.getLastName() + " new earnings are " + newEarn  );
        	}
        	
        	 }
        */
        JOptionPane.showMessageDialog(null, output,
                "Demonstrating Polymorphism - Employee Salaries",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
