package com.aurionpro.inheritance.abstraction;

public class Archer extends GameCharacter {
	
	public Archer(String name , double powerLevel){
		super(name , powerLevel );
	}
	
	public void attack() {
		 powerLevel -=5;
	}

}
