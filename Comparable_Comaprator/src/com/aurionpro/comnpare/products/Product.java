package com.aurionpro.comnpare.products;


public class Product {
    private String category;
    private String name;
    private double price;

    public Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{category='" + category + "', name='" + name + "', price=₹" + price + "}";
    }
}

