package com.weekly.assignment01;
import java.util.Scanner;


public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str = scanner.nextLine();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                result += '-';
            } else {
                result += ch;
            }
        }

        System.out.println("Modified string: " + result);
        scanner.close();
    }
}


