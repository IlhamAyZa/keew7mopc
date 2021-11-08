package lesson9COMP132;

public class Employee extends Person {

	private int salary;
	private double professionalism; //(0 = novice, 1 = professional)
	
	public Employee(String name, String surname, int age, Gender gender, int salary, double professionalism) {
		super(name, surname, age, gender);
		this.salary = salary;
		this.professionalism = professionalism;
	}
	
	public Employee(String name, Gender gender, int salary, double professionalism) {
		super(name, gender);
		this.salary = salary;
		this.professionalism = professionalism;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getProfessionalism() {
		return professionalism;
	}

	public void setProfessionalism(double professionalism) {
		this.professionalism = professionalism;
	}
	
	public void raiseSalary(int up) {
		this.salary += up;
	}
	public void lowerSalary(int down) {
		this.salary -= down;
	}

}