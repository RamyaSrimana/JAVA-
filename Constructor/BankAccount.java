//2.Write a Java program for a
//BankAccount class where each account
//has its own account number and balance using instance variables.


package com.java.basics;

public class BankAccount {
	String Account_number;
	int balance;
	
	BankAccount(String number,int balance){
		this.Account_number = number;
		this.balance = balance;
	}
	void display(String name) {
		System.out.println(name);
		System.out.println("Account_number: "+Account_number);
		System.out.println("Balance: "+balance);
		System.out.println();
	}
	
	public static void main(String[]args) {
		BankAccount person1 = new BankAccount("SBI12456",10000);
		BankAccount person2 = new BankAccount("SBI12445",20000);
		BankAccount person3 = new BankAccount("SBI12455",30000);
		person1.display("Person1");
		person2.display("Person2");
		person3.display("Person3");
	}
}
