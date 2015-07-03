package com.linkui.ThreadLearning;

public class TT implements Runnable{
	int b = 100;
	
	public synchronized void m1() throws Exception{
		b=1000;
		Thread.sleep(5000);
		System.out.println("b= "+b);
	}
	
	public synchronized void m2() throws Exception {	
		Thread.sleep(2500);
		b=500;
		System.out.println(b);
	}
	
	public void run(){
		try{
			m1();
			System.out.println(b);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		TT tt = new TT();
		Thread t = new Thread(tt);
		t.start();
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		tt.m2();
		System.out.println("Final b= "+tt.b);
	}
}
