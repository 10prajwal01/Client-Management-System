package com.example.oops;

class Task<T>
{
	T obj;
	Task(T obj){
		this.obj = obj;
	}
	
	public T getObject() {
		return this.obj;
	}
}
public class Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task<String> obj1 = new Task<String>("String");
		System.out.println(obj1.getObject());
		
		Task<Integer> obj2 = new Task<Integer>(101);
		System.out.println(obj2.getObject());
	}

}
