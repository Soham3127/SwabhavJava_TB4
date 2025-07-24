package com.aurionpro.collections.hashmap;


import java.util.Hashtable;


public class HashTableDemo {
	public static void main(String[] args) {
		
		Hashtable<Integer, String> map = new Hashtable<>();{
			
			map.put(1, "Soham");
			map.put(2, "Jagtap");
			map.put(3, "Soh");
			map.put(4, "Jag");
			System.out.println(map);
			
			System.out.println("Get OBject: "+ map.get(3));
			
			System.out.println("Remove: "+ map.remove(4));
			System.out.println(map);
			
			System.out.println("Size :"+map.size());
			
			System.out.println("Values" + map.values());
			
			System.out.println("Clone"+ map.clone());
			
			System.out.println(map.hashCode());
			
			//Entry Set
			System.out.println("Entry"+ map.entrySet());
			
			//output of only key
			System.out.println("Key: "+ map.keySet());
			
			//isEmpty
			System.out.println("Is it empty"+ map.isEmpty());
			
			// contains
			System.out.println(map.contains("Soham"));
		}
		
		
	}
	

}
