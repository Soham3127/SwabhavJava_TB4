package com.aurionpro.interface01;

public class CurrentAccount implements IAccountOperations {
    double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

