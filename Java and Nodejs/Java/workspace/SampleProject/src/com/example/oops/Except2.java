package com.example.oops;

public class Except2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(10 / 0);
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("Closed");
		}
	}

}
