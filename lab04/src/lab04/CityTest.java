package lab04;

public class CityTest {

	public static void main(String[] args) {
		City seoul = new City("Seoul", 23, 45);
		City paris = new City("Paris", 123, 41);
		City racoon = new City("Racoon City");
		City mega = new City("Mega City");
		
		System.out.println(seoul.toString());
		System.out.println(paris.toString());
		System.out.println(racoon.toString());
		System.out.println(mega.toString());
		
		System.out.printf("%s-%s : %f\n", seoul.getName(), paris.getName(), City.distance(seoul, paris));
		System.out.printf("%s-%s : %f\n", seoul.getName(), racoon.getName(), City.distance(seoul, racoon));
		System.out.printf("%s-%s : %f\n", paris.getName(), mega.getName(), City.distance(paris, mega));
	}

}
