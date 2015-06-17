package com.linkui;

public class TestThread {
	public static void main(String[] args) throws InterruptedException{
		int tmp = 1;
		Thread1 t1 = new Thread1("t1");
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		Thread.sleep(4);
		t2.stopThread(t1);
		Thread.sleep(1000);
		t1.interrupt();
		System.out.println("Main Thread ends.");
	}
}

class Thread1 extends Thread{
	public Thread1(){}
	public Thread1(String name){
		super(name);
	}
	public void run(){
		int i =0;
		while(!isInterrupted()){
			System.out.println(this.getName()+" thread runs "+ i++ +" times.");
		}
	}
}

class Thread2 extends Thread {
	public void run(){
		try {
			Thread2.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("This is Thread2");
	}
	
	// polymorphism
	public void stopThread(Thread t1){
		t1.interrupt();
	}
}