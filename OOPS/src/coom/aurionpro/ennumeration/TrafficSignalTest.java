package coom.aurionpro.ennumeration;

import java.util.Scanner;

public class TrafficSignalTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the traffic Signal(RED, YELLOW, GREEN): ");
		String input = scanner.next().toUpperCase();

		switch (input) {
		case "RED":
			System.out.println(" Signal:  RED " + TrafficSignal.RED.getAction());
			break;

		case "YELLOW":
			System.out.println(" Signal:  YELLOW " + TrafficSignal.YELLOW.getAction());
			break;

		case "GREEN":
			System.out.println(" Signal:  GREEN " + TrafficSignal.GREEN.getAction());
			break;

		default:
			System.out.println("Inavlid Input");

		}
		scanner.close();
;
	}

}
