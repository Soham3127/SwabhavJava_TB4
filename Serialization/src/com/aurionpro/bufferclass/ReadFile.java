package com.aurionpro.bufferclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("demo.txt"));
		
		String line;
		
		while((line = reader.readLine())!= null){
			System.out.println(line);
			
		}
		
		reader.close();
		
	}

}
