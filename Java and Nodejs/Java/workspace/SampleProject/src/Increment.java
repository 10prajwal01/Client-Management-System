

class Emp{
	int Emp_id;
	String Emp_name;
	double Emp_salary;
	
	public Emp(int Emp_id, String Emp_name, double Emp_salary) {
		this.Emp_id = Emp_id;
		this.Emp_name = Emp_name;
		this.Emp_salary = Emp_salary;
	}
	
	public void incrementSalary(double per) {
		double result = this.Emp_salary*(1+(per/100));
		System.out.println(result);
		this.Emp_salary=result;
		System.out.println(this.Emp_salary);
	}
}
public class Increment {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp e = new Emp(1, "qqq", 10000);
		e.incrementSalary(10);
		
	}

}
