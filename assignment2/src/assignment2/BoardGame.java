package assignment2;

public class BoardGame extends Game{
	public double getRepairCost() {return 0.04 * this.quality;} 		// $0.04 per quality point
	public void lowerQuality() {this.quality -=25;}			// Lowers the quality of the game by 25 points
	public String getQuality() 
	{
		if (this.quality > 70) {return "Good";}
		else if (this.quality < 50) {return "Bad";}
		else return "Okay";
	}			// Quality > 70 == Good, 70-50 == Okay, < 50 == Bad
	
	public BoardGame() {}
	public BoardGame(String name, double price, int quality) {super(name, price, quality);}
}
