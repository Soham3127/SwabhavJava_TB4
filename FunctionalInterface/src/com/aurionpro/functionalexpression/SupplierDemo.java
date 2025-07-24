package com.aurionpro.functionalexpression;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		//random number generator
		Supplier<Double> random = () -> Math.random();
		System.out.println(random.get());
		
		Supplier<LocalDate> currentDate = () -> LocalDate.now();
		System.out.println(currentDate.get());
		//Current time 
		Supplier<LocalTime> currentTime = () -> LocalTime.now();
		System.out.println("Current Time:" + currentTime.get());
		
	}

}
