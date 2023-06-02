package quiz2;

public class Main {
	// 이자율 3프로 maximum overdraft 50
	public static void main(String[] args) {
		Bank mybank = new Bank();
		int saIndex, caIndex;
		
		SavingsAccount sa = new SavingsAccount(0, 1.03);
		CheckingsAccount ca = new CheckingsAccount(0, 50);
		
		saIndex = mybank.addAccount(sa);
		caIndex = mybank.addAccount(ca);
		
		mybank.printAccountInformation();
		
		mybank.deposit(saIndex, 500);
		mybank.deposit(caIndex, 100);
		
		mybank.withdraw(caIndex, 175);
		mybank.withdraw(caIndex, mybank.accounts[caIndex].getBalance() + 50);
		
		mybank.printAccountInformation();
	}

}
