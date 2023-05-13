package lab10;

public class Program {

	public static void main(String[] args) {
		Animal[] animals = {new Dog(), new Tiger(), new Turtle()};
		Person person = new Person()
				{
					private int hp = 100;
					
					@Override
					public void control(Animal animal) 
					{
						if (animal instanceof Tiger) this.hp -= 80;
						if (animal instanceof Dog) this.hp -= 10;
						System.out.println("You have overpowered the " + animal.getName());
					}
					public void showInfo() {System.out.println("Person HP: " + this.hp);}
				};
		showResult(animals, person);
	}
	
	private static void showResult(Animal[] animals, Person p)
	{
		for (int i = 0; i < animals.length; i++) 
		{
			System.out.printf("Animal%d: %s\n", i+1, animals[i].getName());
			if (animals[i] instanceof Barkable) System.out.printf("Animal%d barked %s\n", i+1, ((Barkable)animals[i]).bark());
			p.control(animals[i]);
			p.showInfo();
		}
	}

}
