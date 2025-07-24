package com.aurionpro.solidpriciples.srp.hospitalrecordsrorage;

public class RecordFormat {
	public String formatForPrint(PatientRecord record) {
		StringBuilder sb = new StringBuilder();
		sb.append("----- Patient Medical Record -----\n");
		sb.append("Name      : ").append(record.getName()).append("\n");
		sb.append("Age       : ").append(record.getAge()).append("\n");
		sb.append("Diagnosis : ").append(record.getDiagnosis()).append("\n");
		sb.append("----------------------------------");
		return sb.toString();
	}
}
