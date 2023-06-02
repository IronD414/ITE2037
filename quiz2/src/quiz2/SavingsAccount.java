package quiz2;

public class SavingsAccount implements Account{
	private double balance;
	private double Interest;
	
	public void deposit(double amount) 
	{
		this.balance += amount;
		this.applyInterest();
	}
	public void withdraw(double amount) 
	{
		if (amount <= this.balance) {
		this.balance -= amount;}
		else {System.out.println("not enough balance");}
	}
	public double getBalance() {return this.balance;}
	
	public void applyInterest() // Applies the interest over the current balance, this is done every time money is deposited to this account type.
	{
		this.balance *= this.Interest;
	}

	public String toString() // Prints the current balance and interestrate, as well as the account type.
	{
		return "SavingsAccount info; Balance: " + this.balance + ", Interest rate: " + this.Interest;
	}

	public SavingsAccount(double balance, double interestRate)
	{
		this.balance = balance;
		this.Interest = interestRate;
	}
}
