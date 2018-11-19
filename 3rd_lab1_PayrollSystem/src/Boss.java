import org.joda.time.DateTime;

// Boss class derived from Employee.

public final class Boss extends Employee {

    private double weeklySalary;
    private DateTime Startdate;

    // constructor for class Boss
    public Boss(String first, String last, double salary, DateTime startDate) throws InvalidDateException {
        super(first, last, startDate); // call superclass constructor
        setWeeklySalary(salary);
        this.Startdate = startDate;
        
    }

    //gets start date
    public DateTime getStartDate(){
    	
    	return Startdate;
    }
    
    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    // get Boss's pay
    public double earnings() throws UserException {
    	if (weeklySalary<=0){  // if wage less or equal then 0
    		throw new UserException();
    		
    	}
        return weeklySalary;
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
