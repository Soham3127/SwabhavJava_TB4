package com.aurionpro.compare.transactionamount;


public class Transaction {
    private int id;
    private double amount;

    public Transaction(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + id + ", amount=₹" + amount + "}";
    }
}
