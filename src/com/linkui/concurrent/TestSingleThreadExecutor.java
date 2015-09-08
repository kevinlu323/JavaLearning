package com.linkui.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSingleThreadExecutor {
	private ExecutorService es;
	public volatile int count = 0;
	
	public synchronized void increment(){
		count += 1;
		System.out.print(count + " ");
		if(count % 40 == 0) System.out.println();
	}
	
	public static void main(String[] args){
		TestSingleThreadExecutor tste = new TestSingleThreadExecutor();
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<>(5);
		tste.es = Executors.newSingleThreadExecutor();
		//tste.es = new ThreadPoolExecutor(3,3,500,TimeUnit.MILLISECONDS, bqueue);
		tste.es.execute(new Adder1(tste));
		tste.es.execute(new Adder2(tste));
		tste.es.execute(new Adder2(tste));
		//System.out.println("main thread");
	}
}

class Adder1 implements Runnable{
	TestSingleThreadExecutor _main;
	Adder1(TestSingleThreadExecutor _main){
		this._main =  _main;
	}
	
	@Override
	public void run(){
		System.out.println("\nAdder1 is running");
		for(int i = 0 ; i < 100; i++){
			_main.increment();
		}
	}
}

class Adder2 implements Runnable{
	TestSingleThreadExecutor _main;
	
	Adder2(TestSingleThreadExecutor _main){
		this._main =  _main;
	}
	
	@Override
	public void run(){
		System.out.println("\nAdder2 is running");
		for(int i = 0 ; i < 300; i++){
			_main.increment();
		}
	}
}