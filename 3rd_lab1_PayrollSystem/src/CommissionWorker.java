import org.joda.time.DateTime;

// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee {

    private double salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week
    private DateTime startDate; // startdate

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last,
            double salary, double commission, int quantity, DateTime startDate ) throws InvalidDateException {
        super(first, last, startDate); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
        this.startDate = startDate;
        getStartDate();
        
    }

    
    

	// set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary) {
        salary = (weeklySalary > 0 ? weeklySalary : 0);
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission) {
        commission = (itemCommission > 0 ? itemCommission : 0);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) {
        quantity = (totalSold > 0 ? totalSold : 0);
    }

    // determine CommissionWorker's earnings
    public double earnings() throws UserException {
    	if (salary<=0){  // if wage less or equal then 0
    		throw new UserException();
    		
    	}
        return salary + commission * quantity;
    }

    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }



	public DateTime getStartDate() {
		
		return startDate;
	}
} // end class CommissionWorker
