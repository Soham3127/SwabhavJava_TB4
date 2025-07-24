package com.aurionpro.staticc;

public class Account {
	static String bankName = " SBI";
	int accountNumber;

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;

	}

	public void display() {
		System.out.println("Bank Name: " + bankName + " Account Number: " + accountNumber);

	}

	public static void main(String[] args) {
		Account a1 = new Account(10001);
		a1.display();

		// Changing the static bank name

		Account.bankName = "HDFC";

		Account a2 = new Account(10002);
		a2.display();
	}

}
