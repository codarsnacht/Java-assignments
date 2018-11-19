
public class demo {

	public static void main(String[] args) {
		
		serialization ser = new serialization();
		
		int num=1000;
		
		transaction tra = new transaction(num, "16/08/2017",  "Open Account", 100);
		transaction tra1 = new transaction(num, "22/08/2017",  "Withdraw", 50);
		transaction tra2 = new transaction(num, "23/09/2017",  "Deposit", 100);
		
		//(date, name, balance, transaction, overDraft)
		bankAccount ba = new bankAccount("16/08/2017","Jenny, Lee ",100.00,"Open Account",200.00);
		
		
		//part 2
		ser.addToBankList(ba);
		ser.writeToBankFile(ba);
		ser.readFromBankFile();
		
		ba.makeWithdraw("22/08/2017",200);
		ba.makeDeposit("23/08/2017",100);
		ba.makeWithdraw("01/09/2017",50);
		
		
		//part 3 , writes to txt file
	//ser.readFromRandomFile();
		
	//part1
		//adds to arraylist
		 
		ser.addToList(tra);
		ser.addToList(tra1);
		ser.addToList(tra2);
		
		//writes to file
		ser.writeToFile(tra);
		ser.writeToFile(tra1);
		ser.writeToFile(tra2);
		
		//reads from file
		ser.readFromFile();

	}

}
