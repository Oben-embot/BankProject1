package za.co.abcbank.account;

import za.co.abcbank.person.Customer;
import za.co.abcbank.account.Transaction;

public class Account {

	public Account() {
	}

	public long accountNumber;
	public double balance;
	public Card card;
	public String type;
	public Transaction[] transactions = new Transaction[10];

}