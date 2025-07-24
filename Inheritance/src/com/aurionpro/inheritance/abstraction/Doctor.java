package com.aurionpro.inheritance.abstraction;

public class Doctor  extends HospitalStaff{
	String specialization;
	String[] patients;
	
	public Doctor (int staffId, String name, String department,String specialization , String[] patients){
		super(staffId, name , department);
		this.specialization= specialization;
		this.patients= patients;
		

		
	}
	public void work() {
		System.out.println(name + "is treating patient " + specialization);
	}
	public String toString() {
		String patientList="";
		for (String p : patients) {
			patientList += p + " ";
		}
		
		return super.toString()+ " , Specialization: "+ specialization+ " , Patients: [" + patientList.trim()+"]";
	}
	

}
