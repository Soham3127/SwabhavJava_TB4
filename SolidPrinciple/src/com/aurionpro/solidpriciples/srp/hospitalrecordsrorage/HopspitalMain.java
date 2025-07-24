package com.aurionpro.solidpriciples.srp.hospitalrecordmain;

import com.aurionpro.solidpriciples.srp.hospitalrecordsrorage.PatientRecord;


public class HopspitalMain {
	public static void main(String[] args) {
		PatientRecord record = new PatientRecord("Alice", 30, "Fever", "alice@example.com");

		RecordFormatter formatter = new RecordFormatter();
		System.out.println(formatter.formatForPrint(record));

		EmailNotifier notifier = new EmailNotifier();
		notifier.sendNotification(record);
	}
}
