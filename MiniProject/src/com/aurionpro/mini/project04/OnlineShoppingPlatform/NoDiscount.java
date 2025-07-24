package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class NoDiscount implements IDiscountStratergy {
    public double applyDiscount(double amount) {
        return amount;
    }
}
