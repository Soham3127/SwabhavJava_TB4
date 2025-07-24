package com.weekly.assignment02.GuitarApp;

public class Guitar {
    private String serialNumber;
    private double price;
    private GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    public double getPrice() {
        return price;
    }

    public void display(int index) {
        System.out.printf("| %-2d | %-10s | %-10.2f | %-10s | %-12s | %-8s | %-7d | %-16s | %-14s |\n",
            index + 1,
            serialNumber,
            price,
            spec.getBuilder(),
            spec.getModel() == null ? "N/A" : spec.getModel(),
            spec.getType(),
            spec.getNumStrings(),
            spec.getBackWood(),
            spec.getTopWood()
        );
    }
}