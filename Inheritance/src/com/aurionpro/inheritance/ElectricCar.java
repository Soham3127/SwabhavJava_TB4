package com.aurionpro.inheritance;

public class ElectricCar extends Carr {
    int batteryCapacity;
    int chargingTime;

    ElectricCar(String brand, String model, int speed, String fuelType, int numSeats, int batteryCapacity, int chargingTime) {
        
    	super( brand, model , speed, fuelType, numSeats);

        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
        
        System.out.println("Number of Seats: " + numSeats);
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Time: " + chargingTime + " hours");
    }
}