package com.aurionpro.inheritance;

public class Carr extends Vehicle{
	
	    String fuelType;
	    int numSeats;

	    Carr(String brand,String model,int speed , String fuelType, int numSeats){
	    	
	    	super(brand , model, speed);
	        this.fuelType = fuelType;
	        this.numSeats = numSeats;
	    }

	    @Override
	    void displayInfo() {
	        System.out.println("Brand: " + brand);
	        System.out.println("Model: " + model);
	        System.out.println("Speed: " + speed);
	        System.out.println("Fuel Type: " + fuelType);
	        System.out.println("Number of Seats: " + numSeats);
	    }
	}


