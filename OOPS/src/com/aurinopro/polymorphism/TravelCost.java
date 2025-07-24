package com.aurinopro.polymorphism;

public class TravelCost {
	int estimate(int distance) {
		return distance * 10;
	}

	double estimate(int distance, int passengers) {
		return distance * 10 * passengers;
	}

	double estimate(int distance, int passengers, boolean AC) {
		double cost = estimate(distance, passengers);
		if (AC) {
			cost += cost * 0.20;
		}
		return cost;
	}

	public static void main(String[] args) {
		TravelCost tc = new TravelCost();
		System.out.println("Single: " + tc.estimate(50));
		System.out.println("Group: " + tc.estimate(100, 3));
		System.out.println("Group with AC: " + tc.estimate(100, 3, true));
	}

}


