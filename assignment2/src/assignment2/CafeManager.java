package assignment2;

import java.util.Scanner;

public class CafeManager {

	public static void main(String[] args) {
		System.out.println("What is the path of the gamesfile?");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.next();
		// Initialize the CSVLoader
		CSVLoader csv = new CSVLoader();
		// Initialize the Cafe
		Cafe myCafe = new Cafe(csv.LoadGames(path), 5);
		// Rent out a game until it's quality is 'bad' and repair it
		int userInput; String nameInput; double price; String gameType; Game boughtGame;
		while (true)
		{
			myCafe.printCafeDetails();
			System.out.println("What would you like to do:");
			System.out.println("1: Rent a game, 2: Return a game, 3: Repair a game, 4: Buy a new game, 5: Save games");
			userInput = scanner.nextInt();
			if (userInput == 1)
			{
				System.out.println("Which game would you like to rent?");
				nameInput = scanner.next();
				myCafe.rentOutGame(nameInput);
			}else if (userInput == 2)
			{
				System.out.println("Which game would you like to return?");
				nameInput = scanner.next();
				myCafe.returnGame(nameInput);
			}else if (userInput == 3)
			{
				System.out.println("Which game would you like to repair?");
				nameInput = scanner.next();
				myCafe.repairGame(nameInput);
			}else if (userInput == 4)
			{
				System.out.println("What is name of the game?");
				nameInput = scanner.next();
				System.out.println("What is the price of the game?");
				price = scanner.nextDouble();
				System.out.println("What is the type of the game?");
				gameType = scanner.next();
				System.out.println("Game bought successfully");
				if (gameType == "Board") {boughtGame = new BoardGame(nameInput, price, 100); myCafe.buyGame(boughtGame);}
				else if (gameType == "Card") {boughtGame = new CardGame(nameInput, price, 100); myCafe.buyGame(boughtGame);}
				else if (gameType == "Electronic") {boughtGame = new ElectronicGame(nameInput, price, 100); myCafe.buyGame(boughtGame);}
				else System.out.println("Invalid type!");
			}else if (userInput == 5) 
			{
				System.out.println("What is the file you want to save to?");
				path = scanner.next();
				csv.SaveGames(myCafe.getGamesInCafe(), path);
			}else if (userInput == 0) {break;}
			else System.out.println("Invalid input!");
		}
		scanner.close();
		// Rent out more games until you have enough money to buy a new one
		// Buy a new game
	}

}
