package com.aurionpro.collections.arraylist;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ArrayListMethods {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Ravi");
		list.add("SA");
		list.add("Vijay");
		//Display the added elements 
		System.out.println("Add elemnets : "+ list);
		
		//Change an element
		 list.set(0," Soham");
		 System.out.println("Changed Array:" + list);
		 
		 //Remove an item 
		 list.remove(1);
		 System.out.println("Remove: " +list);
		 
		 //Size
		 System.out.println("Size of an array: " + list.size());
		
		 //Sort
		 
		 Collections.sort(list);
		 for (String i : list) {
			 System.out.println("Sorted Array using collection: "+ i);
		 }
		 
		 //Fetching an element
		 System.out.println("Adding at element :"  + list.get(1));
		 
		 //Contain returns True or False 
		 System.out.println("The Element is found  "+ list.contains("Soham"));
		 
		 //To find the index 
		 System.out.println("Last : " + list.lastIndexOf("Vijay"));
		 
		 //tells if array is empty or not 
		 System.out.println("IsEmpty: " + list.isEmpty());
		 
		
		 
	}
	

}
