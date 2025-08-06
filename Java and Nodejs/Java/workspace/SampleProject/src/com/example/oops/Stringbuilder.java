package com.example.oops;

public class Stringbuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("AABBCC");
		System.out.println("String: "+sb.toString());
		
		StringBuilder reverseStr = sb.reverse();
		System.out.println("Reverse: "+reverseStr);
		
		sb.append("abc");
		System.out.println("Modified: "+sb);
		
		int capacity = sb.capacity();
		System.out.println("StringBuilder: " + sb);
		System.out.println("Capacity: "+capacity);
	}

}
