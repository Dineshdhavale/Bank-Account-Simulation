package com.elevateLabs;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Transaction{
	private Date date;
	String type;
	double amount;
	double newBalance;
	
	public  Transaction(String type, double amount,double newBalance) {
		this.date = new Date();
		this.type = type;
		this.amount = amount;
		this.newBalance = newBalance;
	}
	
	public String toString() {
		 return "Date: " + date + ", Type: " + type + ", Amount: $" + String.format("%.2f", amount) + ", New Balance: $" + String.format("%.2f", newBalance);
	}
	
}	
	class Account{
		String accountNumber;
		double balance;
		String accountHolderName;
		List<Transaction> transactionHistory;
		
		public Account(String accountNumber, String accountHolderName, double balance) {
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.accountHolderName = accountHolderName;
			this.transactionHistory = new ArrayList<>();
			}

		public String getAccountNumber() {
			return accountNumber;
		}

		public double getBalance() {
			return balance;
		}

		public String getAccountHolderName() {
			return accountHolderName;
		}
		
		public void deposit(double amount) {
			  if (amount > 0) {
		            balance += amount;
		            transactionHistory.add(new Transaction("Deposit", amount, balance));
		            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", balance));
		        } else {
		            System.out.println("Deposit amount must be positive.");
		        }
		    }
		 
		public boolean withdraw(double amount) {
			if(amount > 0 && balance >= amount) {
				balance -= amount;
				transactionHistory.add(new Transaction ( "Withdrawal", amount,balance));
				System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", balance));
	            return true;
			}
			else if(amount <= 0){
				System.out.println("Withdraw balance must be positive");
				return false;
			}
			else {
				System.out.println("Insufficient funds. Current balance: $" + String.format("%.2f", balance));
	            return false;
			}
		}
		
		public void printTransactionhistory() {
			System.out.println("\n--- Transaction History for Account " + accountNumber + " ---");
			if(transactionHistory.isEmpty()) {
				System.out.println("No transaction yet");
			}else {
				for(Transaction transaction : transactionHistory) {
					System.out.println(transaction);
				}
			}
			System.out.println("-----------------");
		}
		
	}	
		
	
public class BankAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account myAccount = null;
		System.out.println("--Welcome to Bank Account--");
        System.out.println("Create Your Account");
        System.out.println("Enter the Account Holder name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter Your Account: ");
        String accNumber = sc.nextLine();
        
        double initialBalance = 0;
        boolean validInput = false;
        
        while(!validInput) {
        	 System.out.print("Enter Initial Balance: $");
             if (sc.hasNextDouble()) {
                 initialBalance = sc.nextDouble();
                 if (initialBalance >= 0) {
                     validInput = true;
                 } else {
                     System.out.println("Initial balance cannot be negative. Please try again.");
                 }
             } else {
                 System.out.println("Invalid input. Please enter a numeric value for balance.");
                 sc.next(); 
             }
         }
        sc.nextLine();
        
        myAccount = new Account(accNumber, name, initialBalance);
        System.out.println("\nAccount created successfully for " + myAccount.getAccountHolderName() + " (Account No: " + myAccount.getAccountNumber() + ")");
        System.out.println("Current Balance: $" + String.format("%.2f", myAccount.getBalance()));
        
        int choice;
        do {
        	System.out.println("\n--- Choose an Operation ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next(); 
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: $");
                double depositAmount = -1;
                validInput = false;
                while (!validInput) {
                    if (sc.hasNextDouble()) {
                        depositAmount = sc.nextDouble();
                        if (depositAmount > 0) {
                            validInput = true;
                        } else {
                            System.out.println("Deposit amount must be positive. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        sc.next(); 
                    }
                }  
                sc.nextLine(); 
                myAccount.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = -1;
                validInput = false;
                while (!validInput) {
                    if (sc.hasNextDouble()) {
                        withdrawAmount = sc.nextDouble();
                        if (withdrawAmount > 0) {
                            validInput = true;
                        } else {
                            System.out.println("Withdrawal amount must be positive. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        sc.next(); 
                    }
                }
                sc.nextLine(); 
                myAccount.withdraw(withdrawAmount);
                break;
                
            case 3:
                System.out.println("Current Balance: $" + String.format("%.2f", myAccount.getBalance()));
                break;
            case 4:
                myAccount.printTransactionhistory();
                break;
            case 5:
                System.out.println("Thank you for using the Bank Account Simulation. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
        	
        }while(choice != 5);
        sc.close();
        }
	
	}

