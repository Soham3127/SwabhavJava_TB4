package com.aurionpro.collections.setTest;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        
        // Creating a HashSet 
        HashSet<String> fruits = new HashSet<>();

        
        // add()
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");
        System.out.println("Set after add(): " + fruits); 

        //contains()
        System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Contains 'Pineapple'? " + fruits.contains("Pineapple"));

      
        //  isEmpty()
        System.out.println("Is set empty? " + fruits.isEmpty());

        
        //size()
        System.out.println("Size of set: " + fruits.size());

    
        //  iterator()
        System.out.println("Iterating using iterator():");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // remove()
        fruits.remove("Banana");
        System.out.println("Set after removing 'Banana': " + fruits);

      
        //  toArray()
        Object[] fruitArray = fruits.toArray();
        System.out.println("Set as array:");
        for (Object f : fruitArray) {
            System.out.println(f);
        }

   
        //addAll()
        HashSet<String> tropicalFruits = new HashSet<>();
        tropicalFruits.add("Papaya");
        tropicalFruits.add("Guava");

        fruits.addAll(tropicalFruits);
        System.out.println("Set after addAll(): " + fruits);

     
        // retainAll()
        HashSet<String> keepOnly = new HashSet<>();
        keepOnly.add("Apple");
        keepOnly.add("Guava");

        fruits.retainAll(keepOnly);
        System.out.println("Set after retainAll (keeping Apple & Guava only): " + fruits);

     
        // removeAll()
        fruits.removeAll(keepOnly);
        System.out.println("Set after removeAll(): " + fruits);

    
        //  clear()
        fruits.clear();
        System.out.println("Set after clear(): " + fruits);
        System.out.println("Is set empty now? " + fruits.isEmpty());
    }
}
