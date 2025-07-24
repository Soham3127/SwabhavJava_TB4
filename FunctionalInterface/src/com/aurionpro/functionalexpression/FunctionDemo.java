package com.aurionpro.functionalexpression;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<String , Integer> length = s-> s.length();
		System.out.println(length.apply("advdjkcdgdkjdb"));
		
		Function<Integer , String> string = i -> i.toString();
		System.out.println(string.apply(3412233));
	}

}
