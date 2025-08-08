package com.foodorderingsystem;

public class OrderItem {
    int id;
    String name;
    int quantity;
    double price;

    public OrderItem(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}