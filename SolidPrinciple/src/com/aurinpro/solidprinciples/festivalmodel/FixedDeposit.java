package com.aurinpro.solidprinciples.festivalmodel;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private IFestivalInterest interest;
	
	
	
	public FixedDeposit(int accountNumber, String name , double principal,int duration, IFestivalInterest interest) {
		
		this.accountNumber=accountNumber;
		this.name=name;
		this.principal=principal;
		this.duration=duration;
		this.interest= interest;
		
		
		
	}
	
	public double calculateSimpleInterest() {
		return (principal * duration * interest.getInterestRate()/100);
	}
	

}
