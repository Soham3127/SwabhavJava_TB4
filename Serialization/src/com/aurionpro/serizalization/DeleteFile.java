package com.aurionpro.serizalization;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("Demo.pdf");

		if (file.delete()) {
			System.out.println("Deleted: " + file.getName());
		} else {
			System.out.println("File not exist");
		}

	}

}
