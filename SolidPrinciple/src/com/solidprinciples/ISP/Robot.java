package com.solidprinciples.ISP;

public class Robot implements IWorkable {

	@Override
	public void start() {
		System.out.println("Robots starts.......");
		
	}

	@Override
	public void stop() {
		System.out.println("Robot stops.......");
		
		
	}

	@Override
	public void rest() {
		System.out.println("Robot rests.......");
		
	}

}
