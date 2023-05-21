package assignment2;

public class CardGame extends Game{
	public double getRepairCost() {return 0.02 * this.quality;} 		// $0.02 per quality point
	public void lowerQuality() {this.quality -=30;}			// Lowers the quality of the game by 30 points
	public String getQuality()
	{
		if (this.quality > 60) {return "Good";}
		else if (this.quality < 25) {return "Bad";}
		else return "Okay";
	} // Quality > 60 == Good, 60-25 == Okay, < 25 == Bad
	
	public CardGame() {}
	public CardGame(String name, double price, int quality) {super(name, price, quality);}
}
