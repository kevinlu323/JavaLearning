package com.linkui.basic;

public class TestDeadLock {
	public static void main(String[] args){
		A a = new A();
		B b = new B();
		TestThread1 t1 = new TestThread1(a, b);
		TestThread2 t2 = new TestThread2(a, b);
		new Thread(t1).start();
		new Thread(t2).start();
	}
}

class TestThread1 implements Runnable{
	A a;
	B b;
	TestThread1(A a, B b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		a.func1(b);
	}
}

class TestThread2 implements Runnable{
	A a;
	B b;
	TestThread2(A a, B b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		b.fun2(a);
	}
}

class A {
	public synchronized void func1(B b){
		System.out.println("func1 in A class is called");
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		b.last();
	}
	
	public synchronized void last(){
		System.out.println("last() in A");
	}
}

class B {
	public synchronized void fun2(A a){
		System.out.println("func2 in B class is called");
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		a.last();
	}
	public synchronized void last(){
		System.out.println("last() in B");
	}
}