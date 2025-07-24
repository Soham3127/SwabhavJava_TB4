package com.aurionpro.inheritance.abstraction;

public   class  Warrior  extends GameCharacter{
	
	public Warrior(String name , double powerLevel) {
		
		super(name, powerLevel);
	}
	
	public void  attack() {
		powerLevel-=10;
	}

}
