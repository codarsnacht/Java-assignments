import java.io.Serializable;

public class bankAccount implements Serializable{
	

	private String name;
	private double balance;
	private String transaction;
	private double overdraft;
	private int accnum;
	private String date;
	private static int count=1000;
	
	
	public bankAccount(String date, String name,double balance,String transaction,double overDraft){
		this.date = date;
		this.accnum = (++count) ; // increments id number ||accnum = accnum + increment of count
		this.name=name;
		this.balance=balance;
		this.transaction=transaction;
		this.overdraft=overDraft;
	}
	
	public void makeDeposit(String date,double amount){
		balance += amount;
		System.out.println(accnum +" " +date + " Deposit " + amount+"  New balance: " + balance );
		
		
	}
	
	public void makeWithdraw(String date,double amount){
		if(amount <= balance){//amount is less then balance
			balance -= amount;
			
			System.out.println(accnum +" " +date + " Withdraw " + amount+"  New Balance: " + balance );
		
			
		}
		//check to see if overdraft can be used
		if(amount - balance <= overdraft){
			balance -= amount;
			System.out.println(accnum +" " +date + " Withdraw " + amount+ "  New Balance: " + balance );
	
		}
		else{//amount greater then balance + overdraft
			System.out.println("Balance is less then the requested amount, withdraw request rejected");
			System.out.println(date + "  Current Balance: "  + balance);
			
		}
		
	}
	
	public void getTransactionDetail(){
		System.out.println(date +"  "+ name+" "+transaction+"\n");
	}
	
	public String toBankString(){
	return date +"  Account Number: "+accnum +"\nname: " + name + "\nbalance: " + balance + "\nTransaction: "+ transaction + "\nOverdraft: "+ overdraft+"\n\n";
	}

}
