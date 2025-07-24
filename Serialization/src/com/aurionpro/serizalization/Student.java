package com.aurionpro.serizalization;

import java.io.Serializable;



public class Student implements Serializable {
	String name ;
	int age;
	
	Student (String name , int age ){
		this.name=name;
		this.age=age;
	}
}
