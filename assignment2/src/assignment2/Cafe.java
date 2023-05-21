package assignment2;

public class Cafe {
	private double money;
	private Game[] gamesInCafe;
	private Game[] rentedOutGames;
	private int[] nums = new int[2];
	
	public Cafe(Game[] games, double startingMoney)
	{
		this.money = startingMoney;
		this.gamesInCafe = null;
		gamesInCafe = games;
		this.rentedOutGames = null;
		int count = 0;
		while (games[count] != null)
		{
			count++;
		}
		this.nums[0] = count;
		this.nums[1] = 0;
	}
	public void rentOutGame(String name)
	{
		int renting = getIndexGamesInCafe(name);
		if (renting >= 0)
		{
			if (this.gamesInCafe[renting].getQuality() == "Bad")
			{
				System.out.println("You cannot rent a game that needs to be repaired!");
				return;
			}else
			{
				this.money += this.gamesInCafe[renting].getPrice() * 0.5;
				this.rentedOutGames = this.appendGame(this.rentedOutGames, this.gamesInCafe[renting]);
				this.gamesInCafe = this.reduceGame(this.gamesInCafe, renting);
				System.out.println("Game rented successfully!");
				this.nums[0]--; this.nums[1]++;
			}
		}else {System.out.println("There is no game named " + name + "!");}
		return;
	}
	public void returnGame(String name)
	{
		int rented = getIndexRentedOutGames(name);
		if (rented >= 0)
		{
			this.gamesInCafe = this.appendGame(this.gamesInCafe, this.rentedOutGames[rented]);
			this.gamesInCafe[getIndexGamesInCafe(name)].lowerQuality();
			this.rentedOutGames = this.reduceGame(this.rentedOutGames, rented);
			System.out.println("Game returned successfully!");
			this.nums[0]++; this.nums[1]--;
		}else {System.out.println("This is not one of our games that is rented out!");}
	}
	public void buyGame(Game game)
	{
		if (game.getPrice() > this.money) {System.out.println("Not enough funds for the game");}
		else if (getIndexGamesInCafe(game.getName()) >= 0 || getIndexRentedOutGames(game.getName()) >= 0)
		{
			System.out.println("You already have this game!");
		}else
		{
			this.money -= game.getPrice();
			this.gamesInCafe = this.appendGame(this.gamesInCafe, game);
			System.out.println("Game bought successfully");
			this.nums[0]++;
		}
	}
	
	public void printCafeDetails()
	{
		System.out.println("Money: " + this.money);
		System.out.println("Games in cafe:");
		for (int i = 0; i < this.nums[0]; i++) 
		{
			System.out.println(this.gamesInCafe[i].toString());
		}
		System.out.println("Games rented out:");
		for (int i = 0; i < this.nums[1]; i++) 
		{
			System.out.println(this.rentedOutGames[i].toString());
		}
	}
	public void repairGame(String name)
	{
		int repairing = getIndexGamesInCafe(name);
		if (repairing > 0)
		{
			if (this.gamesInCafe[repairing].getRepairCost() == 0)
			{
				System.out.println("You don't need to repair this game");
			}else if (this.gamesInCafe[repairing].getRepairCost() > this.money)
			{
				System.out.println("There is not enough money!");
			}else
			{
				this.money -= this.gamesInCafe[repairing].getRepairCost();
				this.gamesInCafe[repairing].repair();
				System.out.println("Repaired successfully, remaining money: " + this.money);
			}
		}else {System.out.println("There is no game named " + name + "!");}
	}
	
	private int getIndexGamesInCafe(String name)
	{
		for (int i = 0; i < this.nums[0]; i++)
		{
			if (this.gamesInCafe[i].getName().equals(name)) {return i;}
		}
		return -1;
	}
	private int getIndexRentedOutGames(String name)
	{
		for (int i = 0; i < this.nums[1]; i++)
		{
			if (name.equals(this.rentedOutGames[i].getName())) {return i;}
		}
		return -1;
	}
	private Game[] appendGame(Game[] arr, Game newGame)	//	Helper function to append an element in array
	{
		int t = 0;
		if (newGame instanceof BoardGame) {t = 0;}
		else if (newGame instanceof CardGame) {t = 1;}
		else if (newGame instanceof ElectronicGame) {t = 2;}
		if (arr == null)
		{
			Game[] newArr = new Game[1];
			if (t == 0) {newArr[0] = new BoardGame(" ", 0, 0);}
			else if (t == 1) {newArr[0] = new CardGame(" ", 0, 0);}
			else if (t == 2) {newArr[0] = new ElectronicGame(" ", 0, 0);}
			newArr[0].setAll(newGame);
			this.nums[0] = 1;
			return newArr;
		}else
		{
			Game[] newArr = new Game[arr.length];
			for (int i = 0; i < this.nums[0]; i++) 
			{
				if (arr[i] instanceof BoardGame) {newArr[i] = new BoardGame(" ", 0, 0);}
				else if (arr[i] instanceof CardGame) {newArr[i] = new CardGame(" ", 0, 0);}
				else if (arr[i] instanceof ElectronicGame) {newArr[i] = new ElectronicGame(" ", 0, 0);}
			}
			for (int i = 0; i < this.nums[0]; i++)	//	copy all elements
			{
				newArr[i].setAll(arr[i]);
			}
			if (t == 0) {newArr[arr.length] = new BoardGame(" ", 0, 0);}
			else if (t == 1) {newArr[arr.length] = new CardGame(" ", 0, 0);}
			else if (t == 2) {newArr[arr.length] = new ElectronicGame(" ", 0, 0);}
			newArr[arr.length].setAll(newGame);	//	append newGame at last
			this.nums[0]++;
			return newArr;
		}
	}
	
	private Game[] reduceGame(Game[] arr, int idx)	//	Helper function to reduce an element in array
	{
		if (arr == null) {return null;}
		else if (arr.length == 1) {this.nums[0] = 0; return null;}
		else
		{
			Game[] newArr = new Game[arr.length];
			for (int i = 0; i < idx; i++)	//	copy before	the target index
			{
				if (arr[i] instanceof BoardGame) {newArr[i] = new BoardGame(" ", 0, 0);}
				else if (arr[i] instanceof CardGame) {newArr[i] = new CardGame(" ", 0, 0);}
				else if (arr[i] instanceof ElectronicGame) {newArr[i] = new ElectronicGame(" ", 0, 0);}
				newArr[i].setAll(arr[i]);
			}
			for (int i = idx; i < this.nums[0] + 1; i++)	//	copy after the target index
			{
				if (arr[i+1] instanceof BoardGame) {newArr[i] = new BoardGame(" ", 0, 0);}
				else if (arr[i+1] instanceof CardGame) {newArr[i] = new CardGame(" ", 0, 0);}
				else if (arr[i+1] instanceof ElectronicGame) {newArr[i] = new ElectronicGame(" ", 0, 0);}
				newArr[i].setAll(arr[i+1]);
			}
			this.nums[0]++;
			return newArr;
		}
	}
	
	// custom methods
	public Game[] getGamesInCafe() {return this.gamesInCafe;}
}
