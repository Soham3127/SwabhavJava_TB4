package com.aurionpro.mini.project03.StudentPerformanceSystem;

class CommerceStudent extends Student {
    private int accounts, business, economics;

    public CommerceStudent(String name, int rollNumber, int accounts, int business, int economics, String stream ) {
    	super(name, rollNumber, stream);
        this.accounts = accounts;
        this.business = business;
        this.economics = economics;
    }

    public double calculatePerformance() {
        return (accounts + business + economics) / 3.0;
    }

    public  void showMarks() {
        System.out.println("Accounts: " + accounts + ", Business: " + business + ", Economics: " + economics);
    }
}
