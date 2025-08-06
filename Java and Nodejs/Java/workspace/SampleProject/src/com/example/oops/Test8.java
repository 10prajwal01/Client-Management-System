package com.example.oops;

abstract class Student{
	int student_id = 101;
	String student_name = "";
	
	void getStudentDetails() {
		System.out.println(this.student_id +" "+ this.student_name);
	}
	abstract void getStudentGrade();
}

public class Test8 extends Student {
	
	void getStudentGrade() {
		System.out.println("Grade 10");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test8 obj = new Test8();
		obj.getStudentGrade();
		obj.getStudentDetails();
	}

}
