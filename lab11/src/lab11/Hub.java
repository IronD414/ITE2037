package lab11;

public class Hub {
	private int number; // box serial number
	private String description; // description of box object
	private String area; // hub position for sending
	private double price_per_box; // price per box
	
	public String toString() {return "Box Number : " + this.number + "\nDescription : " + this.description + "\nArea : " + this.area + "\nPrice per box : " + this.price_per_box;}
	
	public int getNumber() {return this.number;}
	public String getDescription() {return this.description;}
	public String getArea() {return this.area;}
	public double getPrice_per_box() {return this.price_per_box;}
	
	public void setNumber(int number) {this.number = number;}
	public void setDescription(String description) {this.description = description;}
	public void setArea(String area) {this.area = area;}
	public void setPrice_per_box(double price_per_box) {this.price_per_box = price_per_box;}
}
