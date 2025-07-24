package com.aurionpro.inheritance.abstraction;

public abstract  class GameCharacter {
	public String name ;
	public double powerLevel;
	

	GameCharacter(String name , double powerLevel){
		this.name=name;
		this.powerLevel=powerLevel;
		
	}
	
	public abstract void  attack();
	

}
