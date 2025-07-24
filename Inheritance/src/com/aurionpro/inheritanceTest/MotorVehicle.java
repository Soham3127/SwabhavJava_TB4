package com.aurionpro.inheritanceTest;

import com.aurionpro.inheritance.*;

 
public class MotorVehicle {
	public static void main(String[] args) {
		Car c= new Car ();
	 	
		Bike b = new Bike ();
		
		
		c.start();
		c.features();
		c.start();
		
		b.start();
		b.features();
		
		
		
	}

}
