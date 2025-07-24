package com.aurionpro.functionalexpression;

import java.util.function.Function;

public class TempConvertor {
	public static void main(String[] args) {

		Function<Double, Double> temp = c -> ((c * 9 / 5) + 32);
		System.out.println("Temp in Fahrenheit." + temp.apply(0.0));
		System.out.println("Temp in Fahrenheit " + temp.apply(20.0));
		System.out.println("Temp  in Fahrenheit" + temp.apply(37.0));

	}

}
