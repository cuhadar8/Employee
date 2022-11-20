import java.util.Scanner;

public class Employee {
	
	private String name;
	private double 	salary;
	private int workHours;
	private int hireYear;
	
	public Employee(String name, double salary, int workHours, int hireYear) {
		
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}
	
	public double tax(double salary) {  
		if(this.salary < 1000) {    //1000 liradan düşük maaşlardan vergi alınmıyor
			return 0;
		}
		
		else  {
			return (salary*3/100);  //1000 liradan yüksek maaşlardan yüzde 3 oranında vergi alınıyor
		}
	}
	
	public double bonus(int workHours) {
		
		if(this.workHours > 40) {
			return ((workHours - 40)*30);   //haftada 40 saatten fazla çalışanlara ekstra çalıştığı saat başı 30 lira ödeniyor
		}
		else {
			return 0;
		}
	}
	
	public double raiseSalary(int hireYear) {
		if(2021-hireYear < 10 && 2021-hireYear >= 0) {    //10 yıldan az çalışanlara yüzde 5 zam
			return (salary*5/100);
		}
		
		else if(2021 - hireYear >= 10 && 2021 - hireYear < 20) {
			return (salary * 10 / 100);                     //10-20 yıl arası çalışanlara yüzden 10 zam
		}
		
		else if (2021 - hireYear >= 20){
			return (salary * 15 / 100);                     //20 yıldan fazla çalışanlara yüzde 15 zam
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Adı: " + name + " \nMaaşı: " + salary + " \nÇalışma Saati: " + workHours 
				+ " \nBaşlangıç yılı: " + hireYear;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Maaş Hesaplamana Sistemine Hoşgeldiniz");
		System.out.print("Lütfen isminizi giriniz:");
		String name = scanner.nextLine();
		System.out.print("Lütfen aylık maaşınızı giriniz: ");
		double salary = scanner.nextDouble();
		System.out.print("Lütfen haftalık çalışma saatinizi giriniz: ");
		int workHours = scanner.nextInt();
		System.out.print("Lütfen çalışmaya başladığınız yılı giriniz: ");
		int hireYear = scanner.nextInt();
		
		
		Employee employee1 = new Employee(name, salary, workHours, hireYear);
		System.out.println(employee1);
							
		double taxCut = employee1.tax(salary);
		double bonusSalary = employee1.bonus(workHours);
		double raised = employee1.raiseSalary(hireYear);
		
		System.out.println("Vergi: " + taxCut);
		System.out.println("Bonus: " + bonusSalary);
		System.out.println("Maaş artışı: " + raised);
		
		System.out.println("Vergi ve bonuslar ile birlikte maaş: " + (salary -  taxCut + bonusSalary));
		System.out.println("Toplam maaş: " +  (salary -  taxCut + bonusSalary + raised));
		
	}
	
	
}
