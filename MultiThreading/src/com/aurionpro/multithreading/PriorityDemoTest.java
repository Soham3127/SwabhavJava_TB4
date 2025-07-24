package com.aurionpro.multithreading;


public class PriorityDemoTest {
	
	public static void main(String[] args) {
		
		new PriorityDemo("Thread 1 " ,  3).start();
		
		new PriorityDemo("Thread 2" , 9).start();
		new PriorityDemo("Thread 3 " , 1).start();
	}

}
