package com.aurionpro.inheritance;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Vehicle Input =====
        System.out.println("Enter Vehicle Details:");
        System.out.print("Brand: ");
        String vBrand = sc.nextLine();
        System.out.print("Model: ");
        String vModel = sc.nextLine();
        System.out.print("Speed: ");
        int vSpeed = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = new Vehicle(vBrand, vModel, vSpeed);

        // ===== Car Input =====
        System.out.println("\nEnter Car Details:");
        System.out.print("Brand: ");
        String cBrand = sc.nextLine();
        System.out.print("Model: ");
        String cModel = sc.nextLine();
        System.out.print("Speed: ");
        int cSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String fuelType = sc.nextLine();
        System.out.print("Number of Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        Carr car = new Carr(cBrand, cModel, cSpeed, fuelType, seats);

        // ===== Electric Car Input =====
        System.out.println("\nEnter Electric Car Details:");
        System.out.print("Brand: ");
        String eBrand = sc.nextLine();
        System.out.print("Model: ");
        String eModel = sc.nextLine();
        System.out.print("Speed: ");
        int eSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String eFuelType = sc.nextLine();
        System.out.print("Number of Seats: ");
        int eSeats = sc.nextInt();
        sc.nextLine();
        System.out.print("Battery Capacity (kWh): ");
        int battery = sc.nextInt();
        System.out.print("Charging Time (hours): ");
        int charging = sc.nextInt();
        sc.nextLine();

        ElectricCar eCar = new ElectricCar(eBrand, eModel, eSpeed, eFuelType, eSeats, battery, charging);

        // ======= Display Details =======
        System.out.println("\n=== Vehicle Info ===");
        vehicle.displayInfo();
        vehicle.accelerate();
        vehicle.brake();

        System.out.println("\n=== Car Info ===");
        car.displayInfo();
        car.accelerate();
        car.brake();

        System.out.println("\n=== Electric Car Info ===");
        eCar.displayInfo();
        eCar.accelerate();
        eCar.brake();

        sc.close();
    }
}


