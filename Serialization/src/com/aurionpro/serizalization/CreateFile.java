package com.aurionpro.serizalization;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		File file = new File("Demo.java");
		
		if(file.createNewFile()) {
			System.out.println("File Created");
			
		}else {
			System.out.println("File Already Exist");
		}
	}

}
