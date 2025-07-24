package com.aurionpro.interface01;

public class SavingsAccount implements IAccountOperations {
    double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount <= 5000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed. Limit is 5000 or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Savings Balance: " + balance);
    }
}

