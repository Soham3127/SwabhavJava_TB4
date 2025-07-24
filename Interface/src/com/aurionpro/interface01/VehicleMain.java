package com.aurionpro.interface01;

public class VehicleMain {
	public static void main(String[] args) {
		IVehicle[] vehicles = new IVehicle[2];
		
		vehicles[0] = new Car();
		vehicles [1]= new Bike();
		
		for (IVehicle v : vehicles) {
			v.start();
			v.fuelType();
			v.stop();
	System.out.println("---------------");
			
		}
	}

}
