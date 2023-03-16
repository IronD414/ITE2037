package lab03;

public class Staff 
{
		private String name;
		private int age;
		private String department;
		private int workDays;
		private int vacationDays;
		
		public Staff(String n, int a)
		{
			this.name = n;
			this.age = a;
			this.department = "None";
			this.workDays = 0;
			this.vacationDays = 20;
		}
		public Staff(String n, int a, String d, int w, int v)
		{
			this.name = n;
			this.age = a;
			this.department = d;
			this.workDays = w;
			this.vacationDays = v;
		}
		public String getName() {return this.name;}
		public void setCareer(String d, int w) 
		{
			this.department = d;
			this.workDays = w;
		}
		public boolean sameCareer(Staff x) 
		{
			return this.department.equals(x.department) && (this.workDays == x.workDays);
		}
		public String toString() 
		{
			return "Name: " + this.name + ", Age: " + this.age + ", Department: " + this.department + ", workDays: " + this.workDays + ", VacationDays: " + this.vacationDays;
		}
		public void vacation(int days) 
		{
			if (days > this.vacationDays)
			{
				System.out.printf("%s, 남은 휴가 일 수 부족.\n", this.name);
			}
			else
			{
				this.vacationDays -= days;
				System.out.printf("%s, 휴가 %d 사용. 남은 휴가 일수: %d\n", this.name, days, this.vacationDays);
			}
		}
}
