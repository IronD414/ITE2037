package lab09;

import java.util.Scanner;

public class Market {

	public static void main(String[] args) {
		Wallet myWallet = new Wallet("wallet");
		Scanner scanner = new Scanner(System.in);
		int enter_price;
		
		while(true)
		{
			try
			{
				myWallet.empty();
				System.out.print("Enter price: ");
				enter_price = scanner.nextInt();
				if (enter_price < 0) throw new NegativeException();
				else if (enter_price > 100) throw new TooMuchExpenseException(enter_price);
				else if (enter_price > myWallet.getBalance()) throw new TooMuchExpenseException();
				else
				{
					myWallet.increaseIndex();
					myWallet.decreaseBalance(enter_price);
				}
			}
			catch(NegativeException ne)
			{
				System.out.println(ne);
				System.out.println("\tat"+ne.getStackTrace()[0]);
			}
			catch(TooMuchExpenseException te)
			{
				if (te.getInputNum() != 0) System.out.println("you pay " + te.getInputNum());
				else 
				{
					System.out.println(te);
					System.out.println("\tat"+te.getStackTrace()[0]);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("\tat"+e.getStackTrace()[0]);
				scanner.close();
				return;
			}
			finally
			{
				System.out.println(myWallet.toString());
				System.out.println("---transaction complete---\n");
			}
		}
	}

}
