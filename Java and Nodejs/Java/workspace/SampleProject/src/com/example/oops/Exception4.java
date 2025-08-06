package com.example.oops;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String msg) {
		super(msg);
	}
}
public class Exception4 {

	static void validtaeAge(int age) throws InvalidAgeException{
		if(age<19) {
			throw new InvalidAgeException("Age is lesser than 18");
		}else {
			System.out.println("Eligible to vote");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 19;
		try {
			
		}catch(Exception ex) {
			
		}
	}

}
