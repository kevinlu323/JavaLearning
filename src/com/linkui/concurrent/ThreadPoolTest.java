package com.linkui.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(2);
		/*BlockingQueue<Runnable> bqueue = new SynchronousQueue<Runnable>();*/
		/**
		 * public ThreadPoolExecutor (int corePoolSize, int maximumPoolSize,
		 * long keepAliveTime, TimeUnit unit,BlockingQueue<Runnable> workQueue)
		 * corePoolSize：线程池中所保存的核心线程数，包括空闲线程�??
		 * 
		 * maximumPoolSize：池中允许的�?大线程数�?
		 * 
		 * keepAliveTime：线程池中的空闲线程�?能持续的�?长时间�??
		 * 
		 * unit：持续时间的单位�?
		 * 
		 * workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务�?
		 */
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 50, TimeUnit.MILLISECONDS, bqueue);

		Runnable t1 = new LightDuty();
		Runnable t2 = new HeavyDuty();
		Runnable t3 = new HeavyDuty();
		Runnable t4 = new HeavyDuty();
		Runnable t5 = new LightDuty();
		Runnable t6 = new HeavyDuty();
		Runnable t7 = new HeavyDuty();

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

class LightDuty implements Runnable {
	public void run() {
		System.out.println("Light duty thread: " + Thread.currentThread().getName() + " is running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class HeavyDuty implements Runnable{
	@Override
	public void run(){
		System.out.println("Heavy duty thread: " + Thread.currentThread().getName() + " is running");
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
