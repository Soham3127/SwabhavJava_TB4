package com.aurionpro.interface01;

import java.util.Scanner;

public class VehicleController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IVehicleControl[] vehicles = {
            new Car2(),
            new Bike2(),
            new Truck()
        };

        String[] vehicleNames = {"Car", "Bike", "Truck"};

        while (true) {
            System.out.println("\n--- Select Vehicle ---");
            for (int i = 0; i < vehicleNames.length; i++) {
                System.out.println((i + 1) + ". " + vehicleNames[i]);
            }
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            String input = sc.nextLine().trim();

            if (input.equals("4")) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);

                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please select between 1 and 3.");
                    continue;
                }

                IVehicleControl vehicle = vehicles[choice - 1];
                String name = vehicleNames[choice - 1];

                vehicle.start();

                boolean validGear = false;
                while (!validGear) {
                    System.out.print("Enter gear (1-5 or R for reverse): ");
                    String gearInput = sc.nextLine().trim().toLowerCase();

                    if (gearInput.equals("r") || gearInput.equals("reverse")) {
                        System.out.println("Switched to Reverse Gear.");
                        vehicle.changeGear(-1);  // -1 represents reverse internally
                        validGear = true;
                        // Do NOT stop vehicle in reverse
                        break;
                    }

                    try {
                        int gear = Integer.parseInt(gearInput);
                        if (gear >= 1 && gear <= 5) {
                            vehicle.changeGear(gear);
                            validGear = true;
                            vehicle.stop();  // Only stop for forward gears
                        } else {
                            System.out.println("Invalid gear. Please enter 1-5 or R.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number or 'R'.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        sc.close();
    }
}
