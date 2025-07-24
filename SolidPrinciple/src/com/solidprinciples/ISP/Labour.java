package com.solidprinciples.ISP;

public class Labour implements IWorker {

	@Override
	public void start() {
		System.out.println("Labour starts work...");
	
		
	}

	@Override
	public void stop() {
		System.out.println("Labour stops.....");
		
	}

	@Override
	public void rest() {
		System.out.println("Labour rests......");
		
	}

	@Override
	public void startWork() {
		System.out.println("Labour start work....");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Labour stops work....");
		
	}

	@Override
	public void eat() {
	System.out.println("Labour eats.....");
		
	}

	@Override
	public void drink() {
		System.out.println("Labour drinks......");
		
	}

}
