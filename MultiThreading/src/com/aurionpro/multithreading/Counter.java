package com.aurionpro.multithreading;

public class Counter  implements Runnable{
	
	public static int count =0;
	
	public synchronized void countProtection() {
		count++;
	}

	@Override
	public void run() {
		for (int i=1 ; i<=1000 ; i++) {
			countProtection();
		}
		
	}

}
