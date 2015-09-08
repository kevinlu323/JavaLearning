package com.linkui.basic;

public class TestAbstract extends Transactions{

	@Override
	public void doSomething() {
		System.out.println("Doing something");
		
	}
	
	public static void main(String[] args){
		TestAbstract client = new TestAbstract();
		client.operate();
		String s1 = "123";
		String s2 = "123";
		String s3 = new String("123");
		String s4 = new String("123");
		System.out.println(s4 == s3);
	}
	
}

abstract class Transactions{
	int balance = 100;
	public void init(){
		System.out.println("init");
	}
	
	public abstract void doSomething();
	
	public void settleDown(){
		System.out.println("finish");
	}
	
	public final void operate(){
		this.init();
		this.doSomething();
		this.settleDown();
	}
}