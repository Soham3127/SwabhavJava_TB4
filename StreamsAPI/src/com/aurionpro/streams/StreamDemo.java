package com.aurionpro.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String[] args) {
		// odd numbers
		List<Integer> list = Arrays.asList(3, 4, 1, 23, 56, 78, 55);

		List<Integer> list1 = list.stream().filter(i -> i % 2 == 1).collect(Collectors.toList());
		System.out.println(list1);

		// Greater than 30
		List<Integer> num = Arrays.asList(2, 4, 6, 78, 99, 65, 34);
		List<Integer> num2 = num.stream().filter(n -> n > 30).collect(Collectors.toList());
		num2.forEach(System.out::println);

		// Even Numbers

		List<Integer> evenNum = Arrays.asList(3, 4, 1, 23, 56, 78, 55);

		List<Integer> evenNum2 = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers: " + evenNum2);
		
		//Start w A
		List<String> name = Arrays.asList("Soham", "Ashu" , "Aditya", "Rahul");

		List<String> name2 = name.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());
		System.out.println("Start with A  " + name2);
		
		
		
		// blanks
		List<String> empty = Arrays.asList("S", " " , "", "   ");
		System.out.println("original: "+empty);
		List<String> empty2 = empty.stream().filter(n ->!n.isBlank()).collect(Collectors.toList());
		System.out.println("Empty string : " + empty2);
		
		//student more than 60
		List<String> student = Arrays.asList("Soham");
		System.out.println("original: "+empty);
		List<String> student2 = student.stream().filter(n ->!n.isBlank()).collect(Collectors.toList());
		System.out.println("Empty string : " + empty2);
		
		
		List<Integer> sqr = Arrays.asList(2,3,5,7,9,10);
		List<Integer> sqr2 = sqr.stream().map(n -> n*n).collect(Collectors.toList());
			sqr2.forEach(System.out :: println);
		
			System.out.println("--------------------------------------");
			List<Integer> mul = Arrays.asList(2,3,5,7,9,10);
			List<Integer> mul2 = mul.stream().map(n -> n*10).collect(Collectors.toList());
				mul2.forEach(System.out :: println);
				
				System.out.println("--------------------------------------");
				List<Double> dis = Arrays.asList(100.0,300.0,50.0,70.0,90.0,1000.0);
				List<String> dis2 = dis.stream().map(price -> "Original: " + price + ", Discount: " + (price * 0.1)).collect(Collectors.toList());
				
					dis2.forEach(System.out :: println);
			System.out.println("--------------------------------------");	
			 List<String> names = Arrays.asList("Soham", "Neha", "Sneha", "Ravi");

		        List<String> prefix = names.stream()
		            .map(n-> {
		                if (n.endsWith("a")) {
		                    return "Ms. " + n;
		                } else {
		                    return "Mr. " + n;
		                }
		            })
		            .collect(Collectors.toList());

		        prefix.forEach(System.out::println);
		        
		      System.out.println("--------------------------------------");	
		      
		      List<Integer> nums= Arrays.asList(2,4,6,3,5,8,24);
		      long evenCount= nums.stream().filter(n-> n%2==0).count();
		      long oddCount = nums.stream().filter(n-> n%2==1).count();
		      
		      System.out.println("Odd Numbers: "+ oddCount);
		      System.out.println("Even Numbers: " + evenCount);
		      
		      
		      System.out.println("--------Comparator---------");
		      //normal sort
		      List<Integer> sort = Arrays.asList(2,4,6,1,78,43,45,21);
		      sort.stream().sorted().forEach(System.out:: println);
		      //reverse order 
		      System.out.println("-------Normal Reverse-------");
		      
		      List<Integer> reverse = Arrays.asList(2,4,6,1,78,43,45,21);
		      reverse.stream().sorted(Comparator.reverseOrder()).forEach(System.out:: println);
		      
		      System.out.println("----------Normal order names -------");
		      List<String> namesort = Arrays.asList("Soham", "Sohan", "Aditya", "Xyz");
		      namesort.stream().sorted().forEach(System.out:: println);
		      
		      System.out.println("----------Reverse order names -------");
		      List<String> nameReverse = Arrays.asList("Soham", "Sohan", "Aditya", "Xyz");
		      nameReverse.stream().sorted(Comparator.comparing(String:: length).reversed()).forEach(System.out:: println);
		      
		     System.out.println("-------Sort more than 50---------");
		     List<Integer> nums2= Arrays.asList(2,4,6,3,5,8,78,89,67,80,91,24);
		     System.out.println("Even sorted numbers: ");
		     nums2.stream().filter(n-> n%2==0 && n>50).sorted().forEach(System.out:: println);
		     
		     System.out.println("Normal Odd numbers");
		     nums2.stream().filter(n-> n%2==1&& n<50).sorted().forEach(System.out::println);
		      
		     
		      
		    }
	
		}

				