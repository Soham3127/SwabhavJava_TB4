package com.aurionpro.inheritance.abstraction;

public class Developer extends Employee {
    double baseSalary;
    double bonus;

  public Developer(String name, int id, double baseSalary, double bonus) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

   public  double calculateSalary() {
        return baseSalary + bonus;
    }
}
