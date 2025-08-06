 package com.example.oops;

class Customers{
	String cust_acc_number;
	String cust_name;
	double cust_mobile;
	String cust_bank_name;
	
	void getCustomersDetails(){
		System.out.println(cust_acc_number + " " + cust_name + " " + cust_mobile + " " + cust_bank_name);
	}
}

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customers obj1 = new Customers();
		obj1.getCustomersDetails();
	}

}
