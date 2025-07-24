package com.aurionpro.solidpriciples.srp.hospitalrecordsrorage;

public class PatientRecord {
	public  String name;
	public int age;
	public  String diagnosis;
	public String email;

	public PatientRecord(String name, int age, String diagnosis, String email) {
		this.name = name;
		this.age = age;
		this.diagnosis = diagnosis;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getEmail() {
		return email;
	}
}
