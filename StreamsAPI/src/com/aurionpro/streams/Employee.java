package com.aurionpro.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
	String name;
	double salary;
	int joiningDate;
	String gender;

	public Employee(String name, double salary, int joiningDate, String gender) {
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.gender = gender;

	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getJoiningDate() {
		return joiningDate;
	}

	public String getGender() {
		return gender;
	}
	
	public String toString() {
		
		return " Name: " + name + " |Salary: " + salary + " |Joining Date:" + joiningDate + " | Gender:"+ gender;
		
	}
	
	public static void main(String[] args) {
		
		List<Employee> emp= Arrays.asList(
				
				new Employee("Soham", 75000, (2020_5_27), "Male"),
	            new Employee("Neha", 82000, (2021_3_15), "Female"),
	            new Employee("Ravi", 67000, (2019_8_1), "Male"),
	            new Employee("Sneha", 90000, (2022_11_23), "Female"),
	            new Employee("Amit", 58000, (2023_1_5), "Male")
				
				
				
				
				
				);
		System.out.println("----------Highest Salary--------");
		emp.stream().max(Comparator.comparingDouble(Employee :: getSalary))
		.ifPresent(e -> System.out.println("Highest Paid Employee: " + e));
		
		System.out.println("----------Seconmd Highest Salary---------------");
		Optional<Employee> secondHighest = emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
					.skip(1).findFirst();

			secondHighest.ifPresent(e -> System.out.println("Second Highest Paid Employee: " + e));
		
			System.out.println("-----------Senior Employee------------------");
			Optional<Employee> senior = emp.stream().sorted(Comparator.comparingDouble(Employee:: getJoiningDate).reversed())
					.findFirst();

			senior.ifPresent(e -> System.out.println("Senior Most Employee: " + e));
			System.out.println("-------------Gender Count--------------");
			Map<String , Long> count = emp.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
			System.out.println("Employee Count by gender" + count);
	}

}
