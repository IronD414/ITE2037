package lab04;
import java.util.Random;

public class City 
{
	Random rnd = new Random();
	
	private String name; 
	private int locationX; 
	private int locationY;
	
	City(String name, int x, int y)
	{
		this.name = name;
		this.locationX = x;
		this.locationY = y;
	}
	
	City(String name)
	{
		this.name = name;
		this.locationX = rnd.nextInt(360);
		this.locationY = rnd.nextInt(360);
	}
	
	public String getName() {return this.name;}
	public int getLocationX() {return this.locationX;}
	public int getLocationY() {return this.locationY;}
	
	public boolean equals(City x) {return this.name==x.name && this.locationX==x.locationX && this.locationY==x.locationY;}
	
	public String toString() 
	{
		return this.name + ", " + Integer.toString(this.locationX) + ", " + Integer.toString(this.locationY);
	}
	
	public static double distance(City a, City b)
	{
		return Math.sqrt(Math.pow(a.locationX - b.locationX, 2) + Math.pow(a.locationY - b.locationY, 2));
	}
}
