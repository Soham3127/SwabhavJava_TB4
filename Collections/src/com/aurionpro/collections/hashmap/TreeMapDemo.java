package com.aurionpro.collections.hashmap;

import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {

		TreeMap<Integer, String> map = new TreeMap<>();
		{

			map.put(1, "Soham");
			map.put(2, "Jagtap");
			map.put(3, "Soh");
			map.put(4, "Jag");
			System.out.println(map);

			System.out.println("Get OBject: " + map.get(3));

			System.out.println("Remove: " + map.remove(4));
			System.out.println(map);

			System.out.println("Size :" + map.size());

			System.out.println("Values" + map.values());

			System.out.println("Clone" + map.clone());

			System.out.println(map.hashCode());

			// Entry Set
			System.out.println("Entry" + map.entrySet());

			// output of only key
			System.out.println("Key: " + map.keySet());

			// isEmpty
			System.out.println("Is it empty" + map.isEmpty());

			// first key
			System.out.println("Higher key value than :" + map.higherKey(2));
			System.out.println("Lower then: " + map.lowerKey(2));

			// sub map
			System.out.println("view map from this to that " + map.subMap(1, 2));

		}

	}
}
