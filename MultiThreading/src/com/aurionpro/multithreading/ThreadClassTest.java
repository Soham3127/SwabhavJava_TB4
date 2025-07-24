package com.aurionpro.multithreading;

public class ThreadClassTest extends Thread{
	public static void main(String[] args) {
		
		MyThreadusingThreadClass thread1 = new MyThreadusingThreadClass();
		thread1.start();
		
		
		MyThreadusingThreadClass thread2 = new MyThreadusingThreadClass();
		thread2.start();
		
	}

}
