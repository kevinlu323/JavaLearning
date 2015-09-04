package com.linkui.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		/**
		 * public ThreadPoolExecutor (int corePoolSize, int maximumPoolSize,
		 * long keepAliveTime, TimeUnit unit,BlockingQueue<Runnable> workQueue)
		 * corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
		 * 
		 * maximumPoolSize：池中允许的最大线程数。
		 * 
		 * keepAliveTime：线程池中的空闲线程所能持续的最长时间。
		 * 
		 * unit：持续时间的单位。
		 * 
		 * workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。
		 */
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 50, TimeUnit.MILLISECONDS, bqueue);

		Runnable t1 = new MyThread();
		Runnable t2 = new MyThread();
		Runnable t3 = new MyThread();
		Runnable t4 = new MyThread();
		Runnable t5 = new MyThread();
		Runnable t6 = new MyThread();
		Runnable t7 = new MyThread();

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);

		pool.shutdown();
	}
}

class MyThread implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}