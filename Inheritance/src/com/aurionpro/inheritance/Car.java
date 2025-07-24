package com.aurionpro.inheritance;

public class Car extends Vehicle {
	public void features() {
		System.out.println(" 4- weheeler with AC");
	}
	@override
	public void start() {
		System.out.println("Car has started");
	}

}
