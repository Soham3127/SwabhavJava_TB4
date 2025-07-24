package com.aurionpro.serizalization;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	
	public static void main(String[] args) throws IOException {
		
		FileWriter writer = new FileWriter("Demo.docs");
		// to add the text one after another
		writer.append("\nHello World. \nSecond line");
		writer.close();
		
		System.out.println("Write operation done ");
	}
		
}
