package com.aurionpro.inheritance.abstractionTest;
import java.util.Scanner;

import com.aurionpro.inheritance.abstraction.Doctor;
import com.aurionpro.inheritance.abstraction.HospitalStaff;
import com.aurionpro.inheritance.abstraction.Nurse;

public class HospitalMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		while (true) {
			System.out.println("-----Hospital Managment System-----");
			System.out.println("1. Add Staff and Display");
			System.out.println("2. Exit ");
			System.out.println("Choose Option (1/2): ");
			String choice = scanner.nextLine();
			
			if (choice.equals("1")) {
				// number of staff members 
				System.out.println("Enter the number of staff: ");
				int n = Integer.valueOf(scanner.nextInt());
				HospitalStaff[] staff = new HospitalStaff[n];
				
				for (int i = 0; i < n; i++) {
	                System.out.println("\nEnter Staff " + (i + 1) + " details:");
	                System.out.print("Is the staff a Doctor (1) or Nurse (2)? ");
	                String type = scanner.nextLine();

	                System.out.print("Staff ID: ");
	                int id = Integer.valueOf(scanner.nextLine());
	                System.out.print("Name: ");
	                String name = scanner.nextLine();
	                System.out.print("Department: ");
	                String department = scanner.nextLine();

	                if (type.equals("1")) {
	                    System.out.print("Specialization: ");
	                    String specialization = scanner.nextLine();
	                    System.out.print("Number of Patients: ");
	                    int pCount = Integer.valueOf(scanner.nextLine());
	                    String[] patients = new String[pCount];
	                    for (int j = 0; j < pCount; j++) {
	                        System.out.print("Patient " + (j + 1) + " Name: ");
	                        patients[j] = scanner.nextLine();
	                    }
	                    staff[i] = new Doctor(id, name, department, specialization, patients);
	                } else if (type.equals("2")) {
	                    System.out.print("Shift Timing (Morning/Evening/Night): ");
	                    String shift = scanner.nextLine();
	                    staff[i] = new Nurse(id, name, department, shift);
	                } else {
	                    System.out.println("Invalid type. Skipping entry.");
	                    i--; 
	                }
	            }

	            System.out.println("\n--- Staff Details ---");
	            for (HospitalStaff hs : staff) {
	                System.out.println(hs.toString());
	                hs.work();
	                System.out.println();
	            }
	            System.out.println("-------------------------------------------\n");
	        }
			else if (choice.equals("2")) {
				System.out.println("Exiting.......");
				break;
			}
			else {
				System.out.println("Invalid option !! Select the option between 1 and 2");
			
	    }
			
	}
		scanner.close();
	
			
			
		}
		
	}


