package com.aurionpro.inheritance.abstraction;

public class Intern extends Employee {
    double stipend;

    public Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

   public  double calculateSalary() {
        return stipend;
    }
}
