package com.aurionpro.multithreading;

public class RunnableDemo  implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread running " + Thread.currentThread().getName());
		
	}

}
