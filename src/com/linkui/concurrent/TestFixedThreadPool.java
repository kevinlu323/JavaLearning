package com.linkui.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
	public static void main(String[] args){
		ExecutorService es = Executors.newFixedThreadPool(2);
		ExecutorService es2 = Executors.newFixedThreadPool(2);
		
		es.execute(new HeavyDuty());
		es.execute(new LightDuty());
		es.execute(new LightDuty());
		es.execute(new LightDuty());
		es.execute(new LightDuty());
		es.execute(new HeavyDuty());
		
		es2.execute(new HeavyDuty());
		es2.execute(new LightDuty());
		es2.execute(new LightDuty());
		es2.execute(new HeavyDuty());
		
		es.shutdown();
		es2.shutdown();
	}
}
