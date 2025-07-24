package com.aurionpro.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SkipLimit {
	public static void main(String[] args) {

		List<String> num = Arrays.asList("a","Abc","Scv", "xys","abc");
		// Skip  2 n print
		num.stream().sorted().skip(2).forEach(System.out :: println);
		// reverse and skip 2
		System.out.println("-----------------");
		List<Integer> sal = Arrays.asList(10000, 20000, 30000, 7000, 6000, 3000);
		sal.stream().sorted(Comparator.reverseOrder()).skip(2).forEach(System.out:: println);
		
		List<String> wor= Arrays.asList("Abc","sad", "Abc", " xys");
		
		wor.stream().sorted( Comparator.comparingInt(String :: length)).limit(2).forEach(System.out:: println);
		
		System.out.println("-----------------");
		
		List<String> words= Arrays.asList("Soham" , " World", "Programming ", "Coding", "together");
		words.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out :: println);
		
		System.out.println("---------Find First--------");
		List<String> first= Arrays.asList("Soham" , " World", "Programming", "Coding", "together", "Welcome", "winner");
		Optional<String> result=first.stream().findFirst();
		System.out.println("First element: " + result);
		
		System.out.println("--------------");
		List<Integer> even = Arrays.asList(45,67,89,4,3,2,56,78);
		Optional<Integer> even2= even.stream().filter(n-> n%2==0).findFirst();
		System.out.println("First Even: "+ even2);
		
	}
}
