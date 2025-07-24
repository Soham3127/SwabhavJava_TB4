package com.aurionpro.multithreading;

public class CounterTest {
	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Final Count: " + counter.count);
		
	}

}
