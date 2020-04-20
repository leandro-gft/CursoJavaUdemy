package br.com.cursojava.exerciciofixacaom9.entities;

public class Holder {
	
	private int accountNumber;
	private String accountHolder;
	private double deposit;
	
	public Holder(int accountNumber, String accountHolder) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
	public Holder(int accountNumber, String accountHolder, double deposit) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.deposit = deposit;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getDeposit() {
		return deposit;
	}
	public double deposit (double deposit) {
		this.deposit += deposit;
		return this.deposit;
	}
	
	public double withdraw (double deposit){
		this.deposit -= deposit + 5.0;
		return this.deposit;	
	}
	
	public String toString() {
		return "Account "+accountNumber+", Holder: "+accountHolder+", Balance: $" +deposit;
	}
	
}
