package lab10;

public class Dog extends Animal implements Barkable{
	public String bark() {return "Bowwow";}
	
	public Dog() {super("Dog");}
}
