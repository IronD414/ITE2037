package manager;
import java.time.*;
import java.util.Random;

import account.Account;

public class AccountManager 
{
	public static boolean eventSuccess()
	{
		Random r = new Random();
		int x = r.nextInt(10);
		return x == 5;
	}
	
	public static void main(String[] args) 
	{
		int flag = 0; Month jan = LocalDate.of(2000, 1, 1).getMonth();
		LocalDate created = LocalDate.of(2021, 12, 1); 
		Account myAccount = new Account("Kim", 5, created);
		System.out.println(myAccount.toString());
		while (myAccount.getBalance() < 10000) 
		{
			created = created.plusMonths(1);
			if (created.isAfter(LocalDate.of(2024, 11, 30)) && flag==0) 
			{
				flag = 1;
				myAccount.increaseYearlyInterest(2);
				System.out.println("가입 후 3년이 지나서 이자율이 2%% 인상되었습니다.");
			}
			myAccount.receiveIncome(100); myAccount.receiveInterest();
			if (created.isAfter(LocalDate.of(2022, 11, 30)) && created.getMonth()==jan && eventSuccess()) 
			{
				myAccount.receiveIncome(100);
				System.out.println("이벤트 당첨!");
			}
		}
		System.out.print(myAccount.toString());
		System.out.print(", 1억 모으기 끝: ");
		System.out.println(created);
	}

}
