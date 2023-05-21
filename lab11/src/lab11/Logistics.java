package lab11;

import java.util.Scanner;
import java.util.ArrayList;

public class Logistics {
	public static void main(String[] args) {
		String[] new_gyeonggi_boxes = {"SuWon#1","SeongNam#1","YongIn#1","GoSeong#1","GaPyeong#1"};
		String[] new_gangwon_boxes = {"Gangneung#1","Wonju#1"};
		ArrayList<Gyeonggi> gyList = new ArrayList<>();
		ArrayList<Gangwon> gaList = new ArrayList<>();
		Scanner scan= new Scanner(System.in);
		
		//***Gyeonggi와 Gangwon의 boxString목록을 모두인스턴스화해서 ArrayList에 넣는다.(tip: ClassName.class)
		ServiceManagement.<Gyeonggi>packageBoxes(new_gyeonggi_boxes, Gyeonggi.class, gyList);
		ServiceManagement.<Gangwon>packageBoxes(new_gangwon_boxes, Gangwon.class, gaList);
		System.out.println("*** Oh, delivery price has been increased!! ***");
		//***Gyeonggi와 Gangwon의 배송요금을 모두 5% 인상한다.
		ServiceManagement.<Gyeonggi>raiseAll(Gyeonggi.class , gyList, 1.05);
		ServiceManagement.<Gangwon>raiseAll(Gangwon.class , gaList, 1.05);
		System.out.println("Which box is important in Gangwon-area?");
		//***콘솔입력을 통해 정수값id를 받아서 Gangwonarraylist에서 index를 찾는다.
		int id = scan.nextInt();
		int index = ServiceManagement.<Gangwon>findIndexByNum(gaList, id);
		if(index == -1)
		{
			System.out.println("nothing");
		}else
		{
			System.out.println("The box \"" + gaList.get(index).getDescription() + "\" is important! be careful!\n");
		//***반환된 index의 해당 box요금을 20% 인상한다.(payment for risk-위험물배송 추가요금)
			ServiceManagement.<Gangwon>raisePerBox(gaList.get(index), 1.2);
		}
		System.out.println("Which box has the wrong area in Gyeonggi-area?");
		//***콘솔입력을 통해 정수값id를 받아서 Gyeonggi arraylist에서 index를 찾는다.
		id = scan.nextInt();
		index = ServiceManagement.<Gyeonggi>findIndexByNum(gyList, id);
		if(index == -1)
		{
			System.out.println("nothing");
		}else
		{
			System.out.println("The box \"" + gyList.get(index).getDescription() + "\" is actually has to go to Gangwon! late! hurry up!\n");
		//***gyList에서 반환된 index에 해당하는 box의 목적허브를 "Gangwon"으로 변경한다.
		//***지연배송에 대한 discount로 box의 요금을 10% 할인한다.(0.9)
			ServiceManagement.<Gyeonggi, Gangwon>changeHub(gyList, index, Gangwon.class, gaList);
		}
		for(Gyeonggi g : gyList)
		{
			System.out.println(g + "\n");
		}
		for(Gangwon j : gaList)
		{
			System.out.println(j + "\n");
		}
		scan.close();
	}
}
