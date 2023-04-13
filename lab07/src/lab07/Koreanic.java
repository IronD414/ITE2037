package lab07;

public class Koreanic extends Language{
	public Koreanic(String name, int numSpeakers)
	{
		this.name = name;
		this.numSpeakers = numSpeakers;
		if (this.name.contains("Jeju")) {this.regionsSpoken = "Jeju island";}
		else {this.regionsSpoken = "Korean peninsula(South Korea, North Korea, Jeju) and several prefectures of China";}
		this.wordOrder = "subject-object-verb";
	}
}
