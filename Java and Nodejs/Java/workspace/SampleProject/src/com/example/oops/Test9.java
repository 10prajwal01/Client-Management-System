package com.example.oops;

interface A1{
	void Task1();
}
interface B1{
	void Task2();
}

public class Test9 implements A1, B1 {
	public void Task1() {
		System.out.println("Task1........");
	}
	public void Task2() {
		System.out.println("Task2........");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test9 obj = new Test9();
		obj.Task1();
		obj.Task2();
	}

}
