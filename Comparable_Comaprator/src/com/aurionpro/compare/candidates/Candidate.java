package com.aurionpro.compare.candidates;

public class Candidate {
    String name;
    int age;

    public Candidate(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Candidate{name='" + name + "', age=" + age + '}';
    }
}
