package lab02;
import java.util.Scanner;

public class BasicIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String name, submit;
		String[] var = input.split(",");
		name = var[0]; name = name.trim();
		submit = var[1]; submit = submit.trim();
		
		
		String[] fullName = name.split(" ");
		fullName[fullName.length-1] = fullName[fullName.length-1].substring(0, 1).toUpperCase() + fullName[fullName.length-1].substring(1);
		submit = submit.replace(".ppt", ".pdf");
		submit = submit.substring(0, 1).toUpperCase() + submit.substring(1);
		System.out.print("Name Length(Korean) : ");
		System.out.println(fullName.length);
		
		System.out.printf("%s.%s.%s submitted %s", fullName[0].substring(0, 1).toUpperCase(), fullName[1].substring(0, 1).toUpperCase(), fullName[fullName.length-1], submit);
	}

}
