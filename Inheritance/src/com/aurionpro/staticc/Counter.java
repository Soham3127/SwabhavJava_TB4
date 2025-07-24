package com.aurionpro.staticc;

public class Counter {
	static int value = 0;
	
	public static void increment() {
		value++;
		System.out.println("Counter: "+ value);
	}
	public static void main(String[] args) {
		Counter.increment();
		Counter.increment();
		Counter.increment();
		Counter.increment();
	}
	

}
