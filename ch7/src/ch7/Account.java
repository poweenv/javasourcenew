package ch7;

public class Account {
	String account;
	String owner;
	int balance;
	public Account(String account, String owner, int balance) {
		super();
		this.account = account;
		this.owner = owner;
		this.balance = balance;
	}
	
	int deposit(int amount) {
		balance +=amount;
		return balance;
	}
	int withdraw(int amount) {
		if(balance<amount) {
			throw new BalanceInsufficientException("잔액부족");
		}
		balance-=amount;
		return balance;
	}
	
}














