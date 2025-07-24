package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class LoyaltyDiscount  implements IDiscountStratergy{

	@Override
	public double applyDiscount(double amount) {
		
		return  amount * 0.80; // 20 % off 
	}

}
