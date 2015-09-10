package com.linkui.concurrent;

import java.util.Date;

public class TestThreadSafe {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(1000);
		FamilyMember father = new Father(account);
		FamilyMember mother = new Mother(account);
		for (int i = 0; i < 5; i++) {
			new Thread((Runnable) father).start();
			new Thread((Runnable) mother).start();
		}
	}
}

class BankAccount {
	// volatile int balance; // volatile cannot garentee thread-safe
	int balance;

	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}

	public void deposit(int i) {
		synchronized (this) {
			balance += i;

			try {
				Thread.sleep(1500); // simulate time to deposit
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("at: " + new Date().toString() + ", deposit successfully, new balance: " + balance);
		}
	}

	public synchronized int withdraw(int i) {
		try {
			Thread.sleep(1500); // simulate time to deposit
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (i > balance) {
			System.out.println("at: " + new Date().toString() + ", insufficient balance");
			return -1;
		}
		balance -= i;
		System.out.println("at: " + new Date().toString() + ", withdraw successfully, new balance: " + balance);
		return i;
	}
}

class Father implements FamilyMember, Runnable {
	BankAccount account;

	public Father(BankAccount account) {
		this.account = account;
	}

	@Override
	public void depositMoney(int i) {
		account.deposit(i);
	}

	@Override
	public void getMoney(int i) {
		account.withdraw(i);
	}

	@Override
	public void run() {
		this.depositMoney(300);
	}

}

class Mother implements FamilyMember, Runnable {
	BankAccount account;

	public Mother(BankAccount account) {
		this.account = account;
	}

	@Override
	public void depositMoney(int i) {
		account.deposit(i);
	}

	@Override
	public void getMoney(int i) {
		account.withdraw(i);
	}

	@Override
	public void run() {
		this.getMoney(200);
	}

}

interface FamilyMember {
	public void depositMoney(int i);

	public void getMoney(int i);
}