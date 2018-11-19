import org.joda.time.DateTime;

// Definition of class HourlyWorker

public final class HourlyWorker extends Employee {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
            double wagePerHour, double hoursWorked,DateTime startDate) throws InvalidDateException  {
        super(first, last, startDate); // call superclass constructor

        setWage(wagePerHour);
        setHours(hoursWorked);
        getStartDate();
    }

    // Set the wage
    public void setWage(double wagePerHour)   {
      wage = (wagePerHour > 0 ? wagePerHour : 0);
        }


    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    public double earnings() throws UserException {
    	if (wage<=0){  // if wage less or equal then 0
    		throw new UserException();
    		
    	}
        return wage * hours;
    }

    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
