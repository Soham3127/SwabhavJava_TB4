package com.aurionpro.multithreading;

public class PriorityDemo extends Thread
			{
	
	public PriorityDemo(String name , int priority) {
		
		setName(name);
		setPriority(priority);
		
		
	}
	public void run() {
		//System.out.println(Thread.currentThread().getName()+ " Priority" + Thread.currentThread().getPriority());
		
		
		//System.out.println(getName()+ " Priority" + getPriority());
		
		for(int i=1 ; i<=5; i++) {
			System.out.println(getName() + ":" + i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
