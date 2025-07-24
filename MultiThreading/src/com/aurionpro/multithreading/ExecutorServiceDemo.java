package com.aurionpro.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		//Will only create a fix numbers of threads
		ExecutorService service = Executors.newFixedThreadPool(5);
		// the task will get performed  to a new thread if the no of threads is bigger than tasks 
		//ExecutorService service = Executors.newFixedThreadPool(3);
		
		//ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task1=() -> System.out.println("Task 1 by: " + Thread.currentThread().getName());
		Runnable task2=() -> System.out.println("Task 2 by: " + Thread.currentThread().getName());
		Runnable task3=() -> System.out.println("Task 3 by: " + Thread.currentThread().getName());
		Runnable task4=() -> System.out.println("Task 4 by: " + Thread.currentThread().getName());
		
		
		service.submit(task1);
		service.submit(task2);
		service.submit(task3);
		service.submit(task4);
		
		//manually shutdown the thread
		service.shutdown();
		
	}

}
