package com.aurionpro.model;

public class Employee {
	
	
	int ID;
	String	name ;
	String	department;
    int	salary;
    
    public Employee (int ID, String name, String department, int salary) {
    	
    	this.ID=ID;
    	this.name=name;
    	this.department=department;
    	this.salary=salary;
    	
    }
    
    public void display() {
    	
    	if(department.equalsIgnoreCase("IT")){
			System.out.println("All the IT employes "+ department );
			
			
			
			
    	
    }
}
