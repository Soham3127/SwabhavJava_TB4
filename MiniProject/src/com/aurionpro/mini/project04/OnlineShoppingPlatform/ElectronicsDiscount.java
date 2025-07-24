package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class ElectronicsDiscount implements IDiscountStratergy {

	@Override
	public double applyDiscount(double amount) {
		
		return  amount*0.90; //10% off 
	}

}
