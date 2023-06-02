package quiz2;

public class Bank {
	public Account[] accounts; // length 2
	public int n;
	
	public Bank()
	{
		this.accounts = new Account[2];
		this.n = 0;
	}
	
	public int addAccount(Account account)
	{
		this.accounts[n] = account;
		return this.n++;
	}
	public void deposit(int index, double amount)
	{
		this.accounts[index].deposit(amount);
	}
	public void withdraw(int index, double amount)
	{
		this.accounts[index].withdraw(amount);
	}
	public void printAccountInformation()
	{
		for (int i = 0; i < this.accounts.length; ++i)
		{
			System.out.println(this.accounts[i].toString());
		}
	}
}
