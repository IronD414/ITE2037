package assignment2;

import java.util.Scanner;
import java.io.*;

public class CSVLoader {
	public Game[] LoadGames(String fileName) // create games based on a CSV file
	{
		Scanner inputStream = null;
		String line; String[] info;
		Game[] loadedGames = new Game[100]; int count = 0;
		
		try
		{
			inputStream = new Scanner(new FileInputStream(fileName));
			while (inputStream.hasNextLine()) 
			{
				line = inputStream.nextLine();
				info = line.split(",");
				if (info[0].equals("Board")) 
				{
					//loadedGames[count] = new BoardGame();
					loadedGames[count++] = new BoardGame(info[1], Double.valueOf(info[2]), Integer.valueOf(info[3]));
				}else if (info[0].equals("Card"))
				{
					//loadedGames[count] = new BoardGame();
					loadedGames[count++] = new CardGame(info[1], Double.valueOf(info[2]), Integer.valueOf(info[3]));
				}else if (info[0].equals("Electronic"))
				{
					//loadedGames[count] = new BoardGame();
					loadedGames[count++] = new ElectronicGame(info[1], Double.valueOf(info[2]), Integer.valueOf(info[3]));
				}else System.out.println("type not found");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
		return loadedGames;
	}
	public void SaveGames(Game[] games, String fileName) // write games to a CSV file
	{}
}