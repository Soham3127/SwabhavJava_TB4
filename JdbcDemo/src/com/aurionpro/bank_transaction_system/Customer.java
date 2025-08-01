package com.aurionpro.bank_transaction_system;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private int pin;
    private int balance;
    private boolean isActive;
    private int wrongAttempts;

    public Customer(int id, String name, int age, String gender, String phone, int pin, int balance, boolean isActive, int wrongAttempts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.pin = pin;
        this.balance = balance;
        this.isActive = isActive;
        this.wrongAttempts = wrongAttempts;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public int getPin() { return pin; }
    public int getBalance() { return balance; }
    public boolean isActive() { return isActive; }
    public int getWrongAttempts() { return wrongAttempts; }

    public void setPin(int pin) { this.pin = pin; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setName(String name) { this.name = name; }
    public void setBalance(int balance) { this.balance = balance; }
    public void setActive(boolean active) { this.isActive = active; }
    public void setWrongAttempts(int wrongAttempts) { this.wrongAttempts = wrongAttempts; }

    @Override
    public String toString() {
        return String.format("| %-4d | %-15s | %-3d | %-6s | %-10s | Rs. %-7d | %-8s |",
                id, name, age, gender, phone, balance, isActive ? "Active" : "Inactive");
    }
}