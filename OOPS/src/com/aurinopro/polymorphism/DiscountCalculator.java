package com.aurinopro.polymorphism;

public class DiscountCalculator {
	    
	    double calculateDiscount(double price) {
	        return price - (price * 0.05);
	    }

	    double calculateDiscount(double price, String coupon) {
	        if (coupon.equals("SAVE10")) {
	            return price - (price * 0.10);
	        }
	        return calculateDiscount(price);
	    }

	    double calculateDiscount(double price, String coupon, boolean isMember) {
	        double finalPrice = calculateDiscount(price, coupon);
	        if (isMember) {
	            finalPrice -= (finalPrice * 0.05);
	        }
	        return finalPrice;
	    }

	    public static void main(String[] args) {
	        DiscountCalculator dc = new DiscountCalculator();
	        System.out.println("Default Discount: ₹" + dc.calculateDiscount(1000));
	        System.out.println("With Coupon: ₹" + dc.calculateDiscount(1000, "SAVE10"));
	        System.out.println("With Coupon + Member: ₹" + dc.calculateDiscount(1000, "SAVE10", true));
	    }
	}



