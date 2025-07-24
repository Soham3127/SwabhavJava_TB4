package com.aurionpro.staticc;

public class Printer {
	static class Inner{
		public void printMessage() {
			System.out.println(" Nested Class accessed");
			
			
		}
	}
	public static void main(String[] args) {
		Printer.Inner obj = new Printer.Inner();
		obj.printMessage();
	}

}
