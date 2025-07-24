package com.aurionpro.functionalexpression;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCity {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Supplier<String> defaultcity = () -> "Pune";

		System.out.println("Enter a city: ");
		String inputCity = scanner.nextLine().trim();

		String city;
		if (inputCity.isEmpty()) {
			city = defaultcity.get();
		} else {
			city = inputCity;
		}
		System.out.println("The city name is : " + city);
		scanner.close();
	}

}
