package com.aurionpro.bank_transaction_system;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidatedInt(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer (e.g., 123).");
            }
        }
    }

    public static int getValidatedPositiveInt(String prompt) {
        while (true) {
            int value = getValidatedInt(prompt);
            if (value > 0) return value;
            System.out.println("Value must be a positive integer.");
        }
    }

    public static int getValidatedIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
                System.out.println("Value must be between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer between " + min + " and " + max + ".");
            }
        }
    }

    public static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }

    public static String getOptionalString(String prompt, String defaultValue) {
        System.out.print(prompt + " (press Enter to skip): ");
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    public static int getOptionalIntInRange(String prompt, int min, int max, int defaultValue) {
        System.out.print(prompt + " (" + min + "-" + max + ", press Enter to skip): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return defaultValue;
        try {
            int value = Integer.parseInt(input);
            if (value >= min && value <= max) return value;
            System.out.println("Value must be between " + min + " and " + max + ". Using default: " + defaultValue);
            return defaultValue;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Using default: " + defaultValue);
            return defaultValue;
        }
    }

    public static String getOptionalPhone(String prompt, String defaultValue) {
        System.out.print(prompt + " (press Enter to skip): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return defaultValue;
        if (input.matches("\\d{10}")) return input;
        System.out.println("Phone number must be exactly 10 digits. Using current value: " + defaultValue);
        return defaultValue;
    }

    public static String getOptionalGender(String prompt, String defaultValue) {
        System.out.print(prompt + " (M/F, press Enter to skip): ");
        String input = scanner.nextLine().trim().toUpperCase();
        if (input.isEmpty()) return defaultValue;
        if (input.equals("M") || input.equals("F")) return input.equals("M") ? "Male" : "Female";
        System.out.println("Please enter 'M' for Male or 'F' for Female. Using current value: " + defaultValue);
        return defaultValue;
    }

    public static String getValidatedGender(String prompt) {
        while (true) {
            System.out.print(prompt + " (M/F): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("M") || input.equals("F")) return input.equals("M") ? "Male" : "Female";
            System.out.println("Please enter 'M' for Male or 'F' for Female.");
        }
    }

    public static String getValidatedPhone(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{10}")) return input;
            System.out.println("Phone number must be exactly 10 digits.");
        }
    }

    public static int readMaskedPIN(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            if (System.console() != null) {
                char[] pinChars = System.console().readPassword();
                String pinStr = new String(pinChars).trim();
                try {
                    int pin = Integer.parseInt(pinStr);
                    if (String.valueOf(pin).length() == 4) return pin;
                    System.out.println("PIN must be exactly 4 digits.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid PIN format. Please enter a 4-digit number.");
                }
            } else {
                StringBuilder pinStr = new StringBuilder();
                System.out.flush();
                while (pinStr.length() < 4) {
                    try {
                        int ch = System.in.read();
                        if (ch == '\n' || ch == '\r') break;
                        if (Character.isDigit(ch)) {
                            pinStr.append((char) ch);
                            System.out.print("*");
                            System.out.flush();
                        }
                    } catch (Exception e) {
                        // Ignore invalid input
                    }
                }
                System.out.println();
                if (pinStr.length() == 4) {
                    try {
                        return Integer.parseInt(pinStr.toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid PIN format. Please enter a 4-digit number.");
                    }
                } else {
                    System.out.println("PIN must be exactly 4 digits.");
                }
            }
        }
    }

    public static int getValidatedAmount(String prompt, int multiple, int min) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int amount = Integer.parseInt(input);
                if (amount >= min && amount % multiple == 0) return amount;
                System.out.println("Amount must be at least " + min + " and in multiples of " + multiple + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer (e.g., 100).");
            }
        }
    }

    public static boolean confirmChoice(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) return true;
            if (input.equals("N")) return false;
            System.out.println("Please enter Y or N.");
        }
    }

    public static int readInt(String prompt) {
        return getValidatedInt(prompt);
    }

    public static String readString(String prompt) {
        return getNonEmptyString(prompt);
    }
}