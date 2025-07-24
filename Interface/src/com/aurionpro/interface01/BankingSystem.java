package com.aurionpro.interface01;

import java.util.InputMismatchException;
import java.util.Scanner;

interface IAccountOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

class SavingsAccount implements IAccountOperations {
    private double balance;

    public SavingsAccount(double initial) {
        this.balance = initial;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Savings Account Balance: ₹" + balance);
    }
}

class CurrentAccount implements IAccountOperations {
    private double balance;

    public CurrentAccount(double initial) {
        this.balance = initial;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + balance);
    }
}

class LoanAccount implements IAccountOperations {
    private double loanBalance;
    private static final double MAX_LOAN_LIMIT = 10000;

    public LoanAccount(double initialLoan) {
        this.loanBalance = initialLoan;
    }

    public void deposit(double amount) {
        if (loanBalance == 0) {
            System.out.println(" No loan pending.");
        } else if (amount >= loanBalance) {
            System.out.println("Loan fully repaid. Extra ₹" + (amount - loanBalance) + " ignored.");
            loanBalance = 0;
        } else {
            loanBalance -= amount;
            System.out.println("Paid ₹" + amount + " towards loan.");
        }
    }

    public void withdraw(double amount) {
        if ((loanBalance + amount) > MAX_LOAN_LIMIT) {
            System.out.println("Loan limit exceeded! Max loan allowed is ₹" + MAX_LOAN_LIMIT);
        } else {
            loanBalance += amount;
            System.out.println("Loan taken ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Loan Outstanding: ₹" + loanBalance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavingsAccount savings = new SavingsAccount(0);
        CurrentAccount current = new CurrentAccount(0);
        LoanAccount loan = new LoanAccount(0);

        boolean running = true;

        while (running) {
            try {
                System.out.println("\n======= ATM Banking System =======");
                System.out.println("Choose Account Type:");
                System.out.println("1. Savings Account");
                System.out.println("2. Current Account");
                System.out.println("3. Loan Account");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int accChoice = sc.nextInt();

                switch (accChoice) {
                    case 1:
                        handleAccount(sc, savings, "Savings Account");
                        break;
                    case 2:
                        handleAccount(sc, current, "Current Account");
                        break;
                    case 3:
                        handleLoanAccount(sc, loan);
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine(); 
            }
        }

        sc.close();
    }

    static void handleAccount(Scanner sc, IAccountOperations account, String accountName) {
        boolean accountSession = true;

        while (accountSession) {
            try {
                System.out.println("\n--- " + accountName + " ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        double dep = getValidAmount(sc, "deposit");
                        account.deposit(dep);
                        break;
                    case 2:
                        double with = getValidAmount(sc, "withdraw");
                        account.withdraw(with);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        accountSession = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine(); // Clear input
            }
        }
    }

    static void handleLoanAccount(Scanner sc, LoanAccount loan) {
        boolean loanSession = true;

        while (loanSession) {
            try {
                System.out.println("\n--- Loan Account ---");
                System.out.println("1. Take Loan");
                System.out.println("2. Repay Loan");
                System.out.println("3. Check Loan Balance");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        double loanAmt = getValidAmount(sc, "loan");
                        loan.withdraw(loanAmt);
                        break;
                    case 2:
                        double repayAmt = getValidAmount(sc, "repay");
                        loan.deposit(repayAmt);
                        break;
                    case 3:
                        loan.checkBalance();
                        break;
                    case 4:
                        loanSession = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine();
            }
        }
    }
    //Validation for amount 
    static double getValidAmount(Scanner sc, String action) {
        double amount = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter amount to " + action + ": ");
                amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                } else if ((amount % 50 != 0) && (amount % 100 != 0) && (amount % 500 != 0)) {
                    System.out.println("Amount must be a multiple of ₹50, ₹100, or ₹500.");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric amount.");
                sc.nextLine(); 
            }
        }

        return amount;
    }
}
