package com.aurionpro.inheritance.abstraction;

public class Nurse extends HospitalStaff {
	String shiftTimmings;

	public Nurse(int staffId, String name, String department, String shiftTimmings) {

		super(staffId, name, department);
		this.shiftTimmings = shiftTimmings;

	}

	public void work() {
		System.out.println(name + " is assisting in " + shiftTimmings + " Shift");
	}

	public String toString() {
		return super.toString() + " , Shift Timmings : " + shiftTimmings;
	}

}
