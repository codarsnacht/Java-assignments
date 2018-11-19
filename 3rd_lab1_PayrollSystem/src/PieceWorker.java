import org.joda.time.DateTime;

// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
            double wage, int numberOfItems, DateTime StartDate) throws InvalidDateException {
        super(first, last, StartDate); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
        getStartDate();
    }

    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = (wage > 0 ? wage : 0);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
    public double earnings() throws UserException {
    	if (quantity * wagePerPiece<=0){ // if wage less or equal then 0
    		throw new UserException();
    		
    	}
        return quantity * wagePerPiece;
    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
