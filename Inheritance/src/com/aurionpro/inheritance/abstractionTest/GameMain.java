package com.aurionpro.inheritance.abstractionTest;

import java.util.Scanner;
import com.aurionpro.inheritance.abstraction.Warrior;
import com.aurionpro.inheritance.abstraction.Archer;
import com.aurionpro.inheritance.abstraction.GameCharacter;

public class GameMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("--------Start Game -----");
			System.out.println("1. Play Attack");
			System.out.println("2. Exit");
			System.out.print("Choose: ");
			String choice = scanner.next();

			if (choice.equals("1")) {

				GameCharacter[] chars = new GameCharacter[2];

				for (int i = 0; i < 2; i++) {
					System.out.print("Enter the Character Name: ");
					String name = scanner.nextLine();
					
					scanner.nextLine();

					System.out.print("Enter the Power Level: ");
					int level = Integer.valueOf(scanner.nextLine());

					System.out.print("Type (1-Warrior , 2-Archer): ");
					String type = scanner.next();

					if (type.equals("1")) {
						chars[i] = new Warrior(name, level);

					} 
					else if (type.equals("2")) {
						chars[i] = new Archer(name, level);
					} 
					else {
						System.out.println("Enter a valid option");

					}
				}
				System.out.println("------Starting-------");
				for (int round = 1; round <= 2; round++) {
					System.out.print("Round " + round);
					for (GameCharacter g : chars) {
						g.attack();
						System.out.println(g.name + "Power Level: " + g.powerLevel);
					}
				}

				

			}
			if (choice.equals("2")) {
				System.out.println("Exting the game ----------");
				break;
			}

			else {
				System.out.println("Select a valid option ");
			}
			
		}
		scanner.close();
	}

}