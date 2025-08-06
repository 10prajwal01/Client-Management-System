package com.example.oops;

class Task{
	void Scanning() {
		System.out.println("Scanning complete");
	}
}

class TrackTask extends Task{
	void Scanning() {
		System.out.println("Scan completed in 5 mins");
	}
}

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrackTask obj = new TrackTask();
		obj.Scanning();
		Task obj1 = new TrackTask();
		obj1.Scanning();
	}

}
