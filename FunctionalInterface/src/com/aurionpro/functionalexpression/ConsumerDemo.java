package com.aurionpro.functionalexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		//upperCase 
		Consumer<String> consumer = msg -> System.out.println(msg.toUpperCase());
		consumer.accept("asdfghjkl");
		
		
													//for each loop 
		Consumer<List<String>> printlist = list -> list.forEach(System.out::println);
		printlist.accept(Arrays.asList("Soham", "Amit", "A", "B"));
		
		Consumer<String> printlen= len-> System.out.println("Length of the string : "+ len.length());
		printlen.accept("Hello world , i ama a human ");
	}

}
