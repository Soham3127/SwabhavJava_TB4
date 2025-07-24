package com.aurionpro.interface01;

import java.util.Scanner;

public class SmartHomeController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IControllable[] devices = {
            new Light(),
            new Fan(),
            new TV(),
            new Speaker()
        };

        String[] deviceNames = {"Light", "Fan", "TV", "Speaker"};
        String[] status = new String[4];   // ON/OFF/Not used
        String[] modeUsed = new String[4]; // Selected mode if any

        while (true) {
            System.out.println("\n--- Smart Device Controller ---");
            for (int i = 0; i < deviceNames.length; i++) {
                System.out.println((i + 1) + ". " + deviceNames[i]);
            }
            System.out.println("5. Exit & Show Summary");

            System.out.print("Choose a device: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 5) {
                    System.out.println("\n--- Session Summary ---");
                    for (int i = 0; i < deviceNames.length; i++) {
                        String s = status[i] == null ? "Not used" : status[i];
                        String m = modeUsed[i] == null ? "" : ", Mode: " + modeUsed[i];
                        System.out.println(deviceNames[i] + ": " + s + m);
                    }
                    System.out.println("Exiting...");
                    break;
                }

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Try again.");
                    continue;
                }

                IControllable device = devices[choice - 1];
                String deviceName = deviceNames[choice - 1];

                String powerInput = "";
                while (true) {
                    System.out.print("Do you want to turn ON the " + deviceName + "? (yes/no): ");
                    powerInput = scanner.nextLine().trim().toLowerCase();

                    if (powerInput.equals("yes") || powerInput.equals("no")) {
                        break;
                    }
                    System.out.println("Invalid input. Enter yes or no.");
                }

                if (powerInput.equals("yes")) {
                    device.turnOn();
                    status[choice - 1] = "ON";

                    String mode = getModeForDevice(scanner, deviceName);
                    if (!mode.equals("")) {
                        device.setMode(mode);
                        modeUsed[choice - 1] = mode;
                    }

                } else {
                    System.out.println(deviceName + " was not turned ON. Skipping mode setup.");
                    status[choice - 1] = "OFF";
                    modeUsed[choice - 1] = null;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static String getModeForDevice(Scanner scanner, String deviceName) {
        String[] validModes;

        switch (deviceName) {
            case "Light":
                validModes = new String[]{"Dim", "Bright", "Normal"};
                System.out.println("Available Modes for Light: Dim, Bright, Normal");
                break;
            case "Fan":
                validModes = new String[]{"Low", "Medium", "High"};
                System.out.println("Available Modes for Fan: Low, Medium, High");
                break;
            case "TV":
                validModes = new String[]{"HD", "4K", "Cinema", "Sports"};
                System.out.println("Available Modes for TV: HD, 4K, Cinema, Sports");
                break;
            case "Speaker":
                validModes = new String[]{"Bass", "Treble", "Surround"};
                System.out.println("Available Modes for Speaker: Bass, Treble, Surround");
                break;
            default:
                return "";
        }

        while (true) {
            System.out.print("Choose a mode (enter name): ");
            String input = scanner.nextLine().trim();

            for (String mode : validModes) {
                if (mode.equalsIgnoreCase(input)) {
                    return mode;
                }
            }

            System.out.println("Invalid mode. Please choose from the available options.");
        }
    }
}
