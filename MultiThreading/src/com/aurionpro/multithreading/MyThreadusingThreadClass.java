package com.aurionpro.multithreading;

public class MyThreadusingThreadClass extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread running: " + Thread.currentThread().getName());
	}

}
