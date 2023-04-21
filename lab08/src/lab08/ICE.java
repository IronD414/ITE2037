package lab08;

import java.time.LocalDate;

public class ICE extends Car{
	private static int carNum;
	private static int CO2emission;
	private static int GHGPERCAR = 35;
	
	public ICE() {}
	public ICE(String name, LocalDate date, int carNum)
	{
		this.name = name;
		this.date = date;
		ICE.carNum += carNum;
		ICE.CO2emission += carNum * ICE.GHGPERCAR;
	}
	
	public boolean equals(Object obj) 
	{
		ICE ice = (ICE) obj;
		return (this.name.equals(ice.name)) && (this.date.equals(ice.date));
	}
	
	public String toString() {return "name: " + this.name + ", date: " + this.date + ", carNum: " + ICE.carNum;}
	
	public int totalCO2() 
	{
		System.out.println("ICE emit CO2 most when driving");
		return ICE.CO2emission;
	}
}
