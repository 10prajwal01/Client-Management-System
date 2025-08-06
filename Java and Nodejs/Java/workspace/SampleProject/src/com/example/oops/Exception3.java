package com.example.oops;

public class Exception3 {
	static void validate(int number) {
		if ( number == 0) {
			throw new ArithmeticException("Divisor is 0");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = 10;
		int number2 = 0;
		int result;
		System.out.println("start");
		try {
			validate(number2);
			result = number1/number2;
			System.out.println("Result is " + result);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
