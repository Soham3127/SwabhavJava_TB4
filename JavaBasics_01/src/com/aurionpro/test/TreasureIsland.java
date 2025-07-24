package com.aurionpro.test;

import java.util.Scanner;

public class TreasureIsland {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Treasure Island");
		System.out.println("Your mission is to find the treasure.");

		System.out.println("Left or Right?: ");
		String Choice1 = scanner.nextLine();

		if (Choice1.equalsIgnoreCase("left")) {
			System.out.print("Swim or Wait?: ");
		} else {
			System.out.println("Fall into a hole. Game Over");
		}

		// System.out.println("Swim or Wait");
		String Choice2 = scanner.nextLine();

		if (Choice2.equalsIgnoreCase("Wait")) {
			System.out.println("Which door?: ");
		} else {
			System.out.println("Attacked by trout. Game Over");
		}

		String Choice3 = scanner.nextLine();

		if (Choice3.equalsIgnoreCase("Red")) {
			System.out.println("Burned by fire . Game Over");
		}
		if (Choice3.equalsIgnoreCase("Blue")) {
			System.out.println("Eaten by beasts.Game Over");
		}
		if (Choice3.equalsIgnoreCase("Yellow")) {
			System.out.println("You Win !!");
		} else {
			System.out.println("Game Over");
		}
		

	}

}
