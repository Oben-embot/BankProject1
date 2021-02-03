package za.co.abcbank.app;

import za.co.abcbank.account.Transaction;
import za.co.abcbank.account.Card;
import za.co.abcbank.account.Account;
import za.co.abcbank.person.Customer;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Customer[] customers = new Customer[1];
		Customer customer = null;
		Account account = null;
		Transaction transaction = null;
		Card card = null;

		for (int a = 0; a < 1; a--) {
			System.out.println("Welcom to abc bank. ");
			System.out.println("Selection from option below. ");
			System.out.println("1. Open new account: ");
			System.out.println("2. Deposit fuds: ");
			System.out.println("3. Withdraw fuds: ");
			System.out.println("4. Check balance: ");
			System.out.println("5. Transactions: ");
			System.out.println("6. Exit. ");
			System.out.println("7. Closed Existening account: ");

			int choice = scan.nextInt();
			if (choice == 1) {

				for (int i = 0; i < customers.length; i++) {
					customer = new Customer();
					account = new Account();
					card = new Card();
					transaction = new Transaction();
					customer.openAccount(scan, account, card);
					customers[i] = customer;
				}

				for (int j = 0; j < customers.length; j++) {
					System.out.println("-----------------------------------------");
					System.out.println("CUSTOMER'S NAME : " + customers[j].surname);
					System.out.println("ACCOUNT NUMBER : " + customers[j].account.accountNumber);
					System.out.println("CARD NUMBER : " + customers[j].account.card.cardNumber);
					System.out.println("ACCOUNT TYPE : " + customers[j].account.type);
					System.out.println("ACCOUNT BALANCE : " + customers[j].account.balance);
				}
				/*
				 * customer.deposit(customers, 1234567, 10000); for(int j = 0; j <
				 * customers.length; j++) {
				 * System.out.println("-----------------------------------------");
				 * System.out.println("CUSTOMER'S NAME : " + customers[j].surname);
				 * System.out.println("ACCOUNT NUMBER : " + customers[j].account.accountNumber);
				 * System.out.println("CARD NUMBER : " + customers[j].account.card.cardNumber);
				 * System.out.println("ACCOUNT TYPE : " + customers[j].account.type);
				 * System.out.println("ACCOUNT BALANCE : " + customers[j].account.balance); }
				 * 
				 * customer.withdraw(customers, 1234567, 2222, 500); for(int j = 0; j <
				 * customers.length; j++) {
				 * System.out.println("-----------------------------------------");
				 * System.out.println("CUSTOMER'S NAME : " + customers[j].surname);
				 * System.out.println("ACCOUNT NUMBER : " + customers[j].account.accountNumber);
				 * System.out.println("CARD NUMBER : " + customers[j].account.card.cardNumber);
				 * System.out.println("ACCOUNT TYPE : " + customers[j].account.type);
				 * System.out.println("ACCOUNT BALANCE : " + customers[j].account.balance); }
				 * 
				 * customer.balance(customers, 1234567, 1000); for(int j = 0; j <
				 * customers.length; j++) {
				 * System.out.println("-----------------------------------------");
				 * System.out.println("CUSTOMER'S NAME : " + customers[j].surname);
				 * System.out.println("ACCOUNT NUMBER : " + customers[j].account.accountNumber);
				 * System.out.println("CARD NUMBER : " + customers[j].account.card.cardNumber);
				 * System.out.println("ACCOUNT TYPE : " + customers[j].account.type);
				 * System.out.println("ACCOUNT BALANCE : " + customers[j].account.balance); }
				 */

			} else if (choice == 2) {
				System.out.println("Enter Account Number : ");
				long accountNo = scan.nextLong();
				System.out.println("Enter Deposit Amount : ");
				double depositAmount = scan.nextDouble();
				customer.deposit(customers, accountNo, depositAmount);

			}

			else if (choice == 3) {
				System.out.println("Enter Account Number : ");
				long accountNo = scan.nextLong();
				System.out.println("Enter Pin: ");
				int pinNo = scan.nextInt();
				System.out.println("Enter Withdraw Amount : ");
				double withdrawAmount = scan.nextDouble();
				customer.withdraw(customers, accountNo, pinNo, withdrawAmount);
			}

			else if (choice == 4) {
				System.out.println("Enter Account Number : ");
				long accountNo = scan.nextLong();
				System.out.println("Enter your Pin: ");
				int pinNo = scan.nextInt();
				customer.balance(customers, accountNo, pinNo);
			}

			else if (choice == 5) {
				System.out.println("Enter Account Number : ");
				long accountNo = scan.nextLong();
				System.out.println("Enter pin : ");
				int pin = scan.nextInt();
				customer.transaction(customers, accountNo, pin);

			}

			else if (choice == 6) {
				System.exit(0);
				a = 2;
			} else if (choice == 7) {
				System.out.println("Enter account number: ");
				long accountNo = scan.nextLong();
				System.out.println("Enter Pin: ");
				int pinNo = scan.nextInt();
				customer.closeExistingAccount(customers, accountNo, pinNo);
			}
		}
	}

}
