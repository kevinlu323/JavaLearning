package com.linkui.ThreadLearning;

public class TestThread1 {
	public static void main (String[] args){
		Runner1 r = new Runner1();
		Thread t = new Thread(r);
		t.start();
		
		for (int i=0; i<100;i++){
			System.out.println("Main Thread:------" +i);
		}
	}
}

//class Runner1 implements Runnable {
class Runner1 extends Thread {  //The other way, use "r.start() is enough"
	public void run(){
		for(int i = 0;i<=100; i++){
			System.out.println("Runner1 :" + i);
		}
	}
}
