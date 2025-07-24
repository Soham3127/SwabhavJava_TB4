package com.aurionpro.interface01;

public class LoanAccount implements IAccountOperations {
    double loanAmount;

    public LoanAccount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void deposit(double amount) {
        System.out.println("Cannot deposit in Loan Account.");
    }

    public void withdraw(double amount) {
        loanAmount += amount;
        System.out.println("Loan increased by: " + amount);
    }

    public void checkBalance() {
        System.out.println("Loan Outstanding: " + loanAmount);
    }
}

