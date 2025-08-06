package com.example.oops;
//polymorphisom
class Addition{
	void add(int x, int y) {
		int res;
		res = x+y;
		System.out.println("Sum = " + res);
	}
	
	void add(int x, int y, int z) {
		int res;
		res = x+y+z;
		System.out.println("Sum =" + res);
	}
}

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addition obj = new Addition();
		obj.add(10, 20);
		obj.add(30, 40 , 50);
	}

}
