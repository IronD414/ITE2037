package lab03;

public class StaffManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Staff staff1 = new Staff("James Wright", 29, "Accounting", 365, 15);
		Staff staff2 = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
		Staff staff3 = new Staff("Amy Smith", 27);
		
		System.out.println(staff1.toString());
		System.out.println(staff2.toString());
		System.out.println(staff3.toString());
		
		System.out.println("Same Career?");
		System.out.printf("%s and %s, ", staff2.getName(), staff3.getName());
		if (staff2.sameCareer(staff3)) 
		{
			System.out.println("Same.");
		}
		else
		{
			System.out.println("Not same.");
		}
		System.out.println("a few years after...");
		staff3.setCareer("R&D", 1095);
		System.out.printf("%s and %s,", staff2.getName(), staff3.getName());
		if (staff2.sameCareer(staff3)) 
		{
			System.out.println("Same.");
		}
		else
		{
			System.out.println("Not same.");
		}
		staff1.vacation(10);
		staff3.vacation(20);
		staff3.vacation(1);
	}

}
