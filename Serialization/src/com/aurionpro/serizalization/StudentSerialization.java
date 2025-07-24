package com.aurionpro.serizalization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentSerialization {

	public static void main(String[] args) throws IOException , FileNotFoundException, ClassNotFoundException {
		Student student = new Student("Soham", 123);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
		out.writeObject(student);
		out.close();
		System.out.println("Obejct Saved ");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
		Student student2 = (Student) in.readObject();
		
		in.close();
		
		System.out.println("Object Read ");
		System.out.println("Name "+ student.name);
		System.out.println("Age " + student.age);
		
		
	}

}
