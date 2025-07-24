package com.aurionpro.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMax {
	public static void main(String[] args) {
		
		List<Integer> num=  Arrays.asList(3,4,1,78,65,44);
		
		
		Optional<Integer> num2=num.stream().min(Comparator.comparingInt(Integer:: intValue));
		System.out.println("Min value: " + num2);
		
		List<String> student=  Arrays.asList("Soham" ,"A", "asdgfh","v");
		Optional<String> student1= student.stream().max(Comparator.comparing(String :: length));
		System.out.println("String with max length: " + student1);
		
		//largest even number
		Optional<Integer> even= num.stream().filter(n-> n%2==0).max(Comparator.comparingInt(n->n));
		System.out.println("largest even number:" +even);
		
		
		
	}	

}
