package com.aurionpro.solidpriciples.srp.hospitalrecordnotificatiosn;


import com.aurionpro.solidpriciples.srp.hospitalrecordsrorage.PatientRecord;

public class Notification{
	public void sendNotification(PatientRecord record) {
		// Dummy implementation — just simulating
		System.out.println("Sending email to: " + record.getEmail());
		System.out.println("Subject: Medical Record Update");
		System.out.println("Message: Dear " + record.getName() + ", your record has been updated.");
	}
}

