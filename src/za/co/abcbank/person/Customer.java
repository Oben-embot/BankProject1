package za.co.abcbank.person;

import java.util.Date;
import java.util.Scanner;
import za.co.abcbank.app.Application;
import za.co.abcbank.account.Account;
import za.co.abcbank.account.Card;
import za.co.abcbank.account.Transaction;

public class Customer {

	public Customer() {
	}

	public String surname;
	public String lastName;
	public String gender;
	public String email;
	public String dateOfBirth;
	public long accountNumber;
	public String idNumber;
	public Account account;
	public int pos = 0;

	public void openAccount(Scanner scan, Account account, Card card) {
		scan.nextLine();
		System.out.println("Enter surname: ");
		this.surname = scan.nextLine();
		System.out.println("Enter last name: ");
		this.lastName = scan.nextLine();
		System.out.println("Enter gender: ");
		this.gender = scan.nextLine();
		System.out.println("Enter email: ");
		this.email = scan.nextLine();
		System.out.println("Enter date of birth: ");
		this.dateOfBirth = scan.nextLine();
		System.out.println("Enter account number: ");
		account.accountNumber = scan.nextLong();
		System.out.println("Enter idNumber: ");
		this.idNumber = scan.nextLine();
		scan.nextLine();
		System.out.println("Enter account type: ");
		account.type = scan.nextLine();
		System.out.println("Enter card number: ");
		card.cardNumber = scan.nextLong();
		System.out.println("Enter pin: ");
		card.pin = scan.nextInt();
		account.card = card;
		this.account = account;
		System.out.println("Transaction Successful. Current balance R0.0");

	}

	public void deposit(Customer[] customers, long accountNumber, double amount) {
		double balance = 0;
		for (int i = 0; i < customers.length; i++) {
			Transaction transaction = new Transaction();
			if (customers[i].account.accountNumber == accountNumber) {
				customers[i].account.balance += amount;
				balance = customers[i].account.balance;
				if (customers[i].account.accountNumber == accountNumber) {
					System.out.println();
				}
				transaction.amount = amount;
				transaction.type = "deposit";
				transaction.date = null;

				System.out.println("Transaction successful. " + balance);
				customers[i].account.transactions[pos++] = transaction;
			}
			if (customers[i].account.accountNumber == accountNumber) {
				System.out.println(customers[i].surname);
			} else {
				System.out.println("Incorrect Account Number. ");
				i = 100;
			}
		}
	}

	public void withdraw(Customer[] customers, long accountNumber, int pin, double amount) {
		double withdraw = 0;
		String date;

		for (int j = 0; j < customers.length; j++) {
			if (customers[j].account.accountNumber == accountNumber && customers[j].account.card.pin == pin) {
				customers[j].account.balance -= amount;
				withdraw = customers[j].account.balance;

				Transaction transaction = new Transaction();
				transaction.amount = amount;
				transaction.type = "withdraw";
				transaction.date = "11/07/1997";
				customers[j].account.transactions[pos++] = transaction;
				System.out.println(withdraw);
				System.out.println("Transaction successful. please collect your money");
			} else {
				System.out.println("Insufficient balance. ");
				j = 100;
			}
		}
	}

	public void balance(Customer[] customers, long accountNmuber, int pin) {
		double balance = 0;
		for (int k = 0; k < customers.length; k++) {
			if (customers[k].account.accountNumber == accountNumber || customers[k].account.card.pin == pin) {
				balance = customers[k].account.balance;
				System.out.println("Balance: " + balance);
				k = 100;
			} else {
				System.out.println("Account not found.");
			}
		}
	}

	public void closeExistingAccount(Customer[] customers, long accountNumber, int pin) {
		for (int l = 0; l < customers.length; l++) {
			if (customers[l].account.accountNumber == accountNumber && customers[l].account.card.pin == pin) {
				customers[l] = null;
				System.out.println("Your account has been successfully closed.");
			} else {
				System.out.println("Account not found. ");
			}
		}
	}

	public void transaction(Customer[] customers, long accountNumber, int pin) {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].account.accountNumber == accountNumber && customers[i].account.card.pin == pin) {
				for (int a = 0; a < pos; a++) {
					System.out.println("Date : " + customers[i].account.transactions[a].date);
					System.out.println("Type : " + customers[i].account.transactions[a].type);
					System.out.println("Amount : " + customers[i].account.transactions[a].amount);
				}
				i = 1000;
			} else {
				System.out.println("account not found");
			}
		}
	}

}
