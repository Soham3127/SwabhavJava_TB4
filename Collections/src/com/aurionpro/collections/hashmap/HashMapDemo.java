package com.aurionpro.collections.hashmap;
import java.util.HashMap;
public class HashMapDemo {
	public static void main(String [] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		// add elements
		map.put(1,"Soham");
		map.put(2,"ABC");
		map.put(3, "ASD");
		map.put(null,"QWE");
		System.out.println(map);
		
		//check if the key is present or not (boolean return)
		System.out.println("Check if 5 is present: " + map.putIfAbsent(5,"WER"));
		
		// get 
		System.out.println("Return the value: "+ map.get(3));
		System.out.println("Return the value: "+ map.get(6));
		
		//remove
		System.out.println("Remove: "+ map.remove(2));
		System.out.println("After Remove: " + map);
		
		//remove with specific key-value
		System.out.println("Remove with key and value: "+ map.remove(3, "ASD"));
		System.out.println(map);
		System.out.println("Remove with key and value: "+ map.remove(3, "adf"));
		
		//contains
		System.out.println("Contain: " +map.containsKey(2));
		
		//size
		System.out.println(map.size());
		
		//replace
		System.out.println("REplace: "+ map.replace(1, "Jagtap"));
		System.out.println(map);
	}	
	
	
	

	

}
