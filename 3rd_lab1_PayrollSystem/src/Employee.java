import org.joda.time.DateTime;

// Abstract base class Employee.

public abstract class Employee {

	//days
public static final int MONDAY = 1;
public static final int TUESDAY = 2;
public static final int WEDNESDAY = 3;
public static final int THURSDAY = 4;
public static final int FRIDAY = 5;
public static final int SATURDAY = 6;
public static final int SUNDAY = 7;
	
	
    private String firstName;
    private String lastName;
    private DateTime startDate;
    //
    private DateTime timeForDay;
   private  static int employeeID;
   private int num; //counter
   

   DateTime testTime = new DateTime(2017,9,22,10,31,34); //assign startdate as today//time of writing

    // constructor
    public Employee(String first, String last, DateTime startDate) throws InvalidDateException {
        firstName = first;
        lastName = last;
        this.startDate = startDate; //sets startdate 
        
        String detail = firstName +" " + lastName + " with start date of " + startDate+ " is invalid \n Reason: "  ;
       
        //check to see if start date is in the future
        if(	startDate.isAfter(testTime)){
        	
        	throw new InvalidDateException( detail+"Start date is in the future"  ); //stops rest of program from completing	
        }
       
        //check to see if start date is before 1990
        if(startDate.isBefore(1990)){
        	throw new InvalidDateException(  detail+"Start date before is 1990"); //stops rest of program from completing	
        }
        
        //check to see if day is out of bounds 
        //joda time will throw exception before this code 
        //if day is less then 0 or greater then 31, throw exception
        //will trigger default exception if month days is 28 or 31
        
        
        
   //    if(startDate.isBefore(startDate.withDayOfMonth(1)) || startDate.isAfter(startDate.withDayOfMonth(30))){
   //     	throw new InvalidDateException(detail +"The day entered is outside the current range of days");
    //    }
        

        //if month is 0 or less or greater then 12 , throws exception
        //joda time does throws the exception before this code
        if(startDate.isAfter(startDate.withMonthOfYear(12) ) || startDate.isBefore(startDate.withMonthOfYear(1)) ){
        	
        	throw new InvalidDateException(detail +"The month entered is outside of the current range of months"); //stops rest of program from completing	
        }
      
        //invalid working day
        if(startDate.getDayOfWeek()== SATURDAY || startDate.getDayOfWeek()== SUNDAY )
        {
        	throw new InvalidDateException( detail + "Start date on the weekend"); //stops remaining when called
        }

        //invalid start hour
        if(startDate.isAfter(startDate.withHourOfDay(18)) || startDate.isBefore(startDate.withHourOfDay(9))){
        	throw new InvalidDateException(detail + "Start date hour is not between 0900 & 1800");
        }
 
        this.startDate = startDate; //sets startdate 
    }
    
    //gets start date
    public DateTime getStartDate(){
    	return startDate;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + ' ' + lastName;
    }

    
    public abstract double earnings()throws UserException;
    
 // adds employee number
	public static int getEmployeeID() {
		employeeID ++;
		return employeeID;
	}
	public void setEmplyeeID(int id){
		this.employeeID = id;
		
	}
		
	
	
	
}
