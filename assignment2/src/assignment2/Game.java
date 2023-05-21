package assignment2;

public abstract class Game {
	//	member variable field
	private String name;
	protected int quality; // 0-100
	private double price;
	
	//	getter method field
	public String getName() {return this.name;}
	//public String getQuality() {return this.quality;}
	public double getPrice() {return this.price;}
	
	//	setter method field
	private void setName(String name) {this.name = name;}
	private void setQuality(int quality) {this.quality = quality;}
	private void setPrice(double price) {this.price = price;}
	public void setAll(Game game)
	{
		this.setName(game.name);
		this.setQuality(game.quality);
		this.setPrice(game.price);
	}

	//	constructor field
	public Game() {}
	public Game(String name, double price, int quality)
	{
		this.name = name;
		this.quality = quality;
		this.price = price;
	}
	
	//	public method field
	public String toString() // Returns Game's name, quality and price
	{
		return "Name: " + this.name + ", Quality: " + this.quality + ", Price: " + this.price + ".";
	}
	public abstract double getRepairCost();
	/*
		if (this.quality == "Bad") {return 0.5 * this.price;}
		else if (this.quality == "Okay") {return 0.2 * this.price;}
		else return 0;
	*/
	public void repair()
	{
		this.quality = 100;
		return;
	}
	public abstract void lowerQuality();
	/*
		if (this.quality == "Good") {this.quality = "Okay"; return;}
		else if (this.quality == "Okay") {this.quality = "Bad"; return;}
		else return;
	*/
	public abstract String getQuality();
}
