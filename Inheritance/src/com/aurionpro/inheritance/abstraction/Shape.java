package com.aurionpro.inheritance.abstraction;

public abstract class Shape {
	String shapeName;
	
	public Shape( String shapeName) {
		this.shapeName=shapeName;
	}
	
	public abstract void  draw();

}
