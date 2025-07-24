package com.aurionpro.inheritance;

public class Vehicle {
    String brand;
    String model;
    int speed;

    Vehicle(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    void accelerate() {
        speed += 10;
        System.out.println("Accelerated. Current speed: " + speed);
    }

    void brake() {
        speed -= 10;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Braked. Current speed: " + speed);
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
    }
}