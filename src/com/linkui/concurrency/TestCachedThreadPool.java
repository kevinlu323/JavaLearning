package com.linkui.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {
	public static void main(String[] args){
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++){
			es.execute(new TestRunnable());
			System.out.println("************* a" + i + " *************");
		}
		es.shutdown();
	}
}

class TestRunnable implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+ " thread is called.");
	}
}