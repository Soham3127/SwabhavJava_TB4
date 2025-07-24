package com.aurionpro.multithreading;

public class DaemonThreadDemo  extends Thread{
	
	public void run() {
		if (Thread.currentThread().isDaemon()) { // Checks if the thread is Daemon or not 
			System.out.println("Daemon thread is running");
		}
		else {
			System.out.println("User thread is working");
		}
	}
	
	public static void main(String[] args) {
		DaemonThreadDemo t1 = new DaemonThreadDemo();
		DaemonThreadDemo t2 = new DaemonThreadDemo();
		DaemonThreadDemo t3 = new DaemonThreadDemo();
		
		t1.setDaemon(true); // sets the thread to Daemon
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
	
	

}
