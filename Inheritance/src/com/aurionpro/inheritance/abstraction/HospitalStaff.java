package com.aurionpro.inheritance.abstraction;

public abstract class HospitalStaff {
	int staffId;
	String name;
	String department;

	public HospitalStaff(int staffId, String name, String department) {
		this.staffId = staffId;
		this.name = name;
		this.department = department;
	}

	public abstract  void work();

	public String toString() {
		return "Staff ID: " + staffId + " , Name: " + name + ", Deaprtment" + department;

	}
}
