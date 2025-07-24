package com.weekly.assignment01;
import java.util.Scanner;
import java.util.Arrays;


public class AnagramChecker {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine().toLowerCase();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine().toLowerCase();

        char[] a = s1.toCharArray();// String to Array 
        char[] b = s2.toCharArray();

        Arrays.sort(a); // sorting the array
        Arrays.sort(b);

        if (Arrays.equals(a, b)) {
            System.out.println("Yes, they are anagrams.");
        } else {
            System.out.println("No, they are not anagrams.");
        }

        sc.close();
    }




    }
    	
   
    
        
