package lab08;

import java.time.LocalDate;

public class BEV extends Car{
	private static int carNum;
	private static int CO2emission;
	private static int GHGPERCAR = 25;
	
	public BEV() {}
	public BEV(String name, LocalDate date, int carNum)
	{
		this.name = name;
		this.date = date;
		BEV.carNum += carNum;
		BEV.CO2emission += carNum * BEV.GHGPERCAR;
	}
	 
	public boolean equals(Object obj) 
	{
		BEV bev = (BEV) obj;
		return (this.name.equals(bev.name)) && (this.date.equals(bev.date));
	}
	
	public String toString() {return "name: " + this.name + ", date: " + this.date + ", carNum: " + BEV.carNum;}
	
	public int totalCO2() 
	{
		System.out.println("BEV emit CO2 most when generating electric energy");
		return BEV.CO2emission;
	}
}
