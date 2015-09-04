package com.linkui.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args){
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<String>> resultList = new ArrayList<>();
		
		for (int i = 0; i<10; i++){
			Future<String> future = es.submit(new TaskWithResult(i));
			resultList.add(future);
		}
		
		for(Future<String> fs : resultList){
			try {
				while(!fs.isDone());
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				es.shutdown();
			}
		}
	}
}

class TaskWithResult implements Callable<String>{
	private int id;
	
	public TaskWithResult(int id){
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		System.out.println("call() method is called by " + Thread.currentThread().getName());
		return "call method returned result: " +id +" " + Thread.currentThread().getName();
	}
		
}