package quiz2;

public class CheckingsAccount implements Account{
	private double balance;
	private double overdraftLimit;
	
	public void deposit(double amount) {this.balance += amount;}
	public void withdraw(double amount) 
	{
		if (amount <= this.balance + this.overdraftLimit) {
		this.balance -= amount;}
		else {System.out.println("not enough balance");}
	}
	public double getBalance() {return this.balance;}
	
	public CheckingsAccount(double balance, double overdraftLimit)
	{
		this.balance = balance;
		this.overdraftLimit = overdraftLimit;
	}
	
	public String toString()
	{
		return "CheckingsAccount info; Balance: " + this.balance + ", Overdraft Limit: " + this.overdraftLimit;
	}
}
