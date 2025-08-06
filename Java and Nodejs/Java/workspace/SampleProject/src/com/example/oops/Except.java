package com.example.oops;
import java.util.Scanner;
public class Except {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Value:");
		sc.nextInt();
		try {
			int num = 20;
			//System.out.println(num/0);
			//String name = null;
			//System.out.println(name.length());
			System.out.println(Integer.parseInt(sc.next()));
		}catch(ArithmeticException ex) {
			System.out.println(ex);
		}catch(NullPointerException ex) {
			System.out.println(ex);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
