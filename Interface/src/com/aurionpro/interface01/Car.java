package com.aurionpro.interface01;

public class Car implements IVehicle { 
	public void start() {
		System.out.println("Car has Started ");
	}
	
	public void stop() {
		System.out.println("Car has stopped");
	}
	public void fuelType() {
		System.out.println(" Car fuel type: Petrol or Diesel");
	}
	

}
