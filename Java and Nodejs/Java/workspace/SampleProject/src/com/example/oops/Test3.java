package com.example.oops;

class Product{
	String product_name;
	int product_qty;
	double product_price;
	
	Product(){
		System.out.println("Default Constructor");
	}
	
	Product(String product_name, int product_qty, double product_price){
		this.product_name = product_name;
		this.product_qty = product_qty;
		this.product_price = product_price;

	}
	
	void getProduct_details() {
		System.out.println(this.product_name + " " + this.product_qty + " " + this.product_price);
		
	}
	
	void totalAmount() {
		double result = this.product_qty*this.product_price;
		System.out.println("Total amount: " + result);
	}
}

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product obj1 = new Product("Laptop", 20, 50000);
		Product obj2 = new Product("Destop", 10, 80000);
		obj1.getProduct_details();
		obj2.getProduct_details();
		System.out.println("==========================");
		obj1.totalAmount();
		obj2.totalAmount();
		
	}

}
