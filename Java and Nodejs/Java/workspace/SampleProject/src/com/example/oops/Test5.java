package com.example.oops;

class Employee{
	int emp_id;
	String emp_name;
	double salary;
	String department;
	
	public Employee(int emp_id, String emp_name, double salary, String department) {
		
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.department = department;
	}
}

class Company extends Employee{
	String company_name;
	String company_location;
	
	
	
	public Company(int emp_id, String emp_name, double salary, String department, String company_name,
			String company_location) {
		super(emp_id, emp_name, salary, department);
		this.company_name = company_name;
		this.company_location = company_location;
	}



	void getDetails() {
		System.out.println(super.emp_id +" "+ super.emp_name +" "+ super.department +" "+ this.company_name +" "+ this.company_location);
	}
}

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company obj = new Company(100, "ABC", 100000, "R&D", "PS", "Bangalore");
		obj.getDetails();
	}

}
