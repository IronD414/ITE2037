package assignment2;

public class ElectronicGame extends Game{
	public double getRepairCost() {return 0.06 * this.quality;} 		// $0.06 per quality point
	public void lowerQuality() {this.quality -= 20;}			// Lowers the quality of the game by 20 points
	public String getQuality()
	{
		if (this.quality > 80) {return "Good";}
		else if (this.quality < 60) {return "Bad";}
		else return "Okay";
	} // Quality > 80 == Good, 80-60 == Okay, < 60 == Bad
	
	public ElectronicGame() {}
	public ElectronicGame(String name, double price, int quality) {super(name, price, quality);}
}
