package com.linkui.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * An example to use ReentrantLock & Condition to make sure multi-threads is
 * running in ordering. Three Threads A, B and C will increment the outerCounter
 * from 1 to 100 one by one, each Thread add 3 times
 * 
 * @author linkui
 *
 */
public class ThreadOrderWithCondition {
	private Lock lock = new ReentrantLock();

	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();

	private char concurrentThread = 'A';
	private int outerCounter = 0;

	public static void main(String[] args) {
		ThreadOrderWithCondition towc = new ThreadOrderWithCondition();
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.execute(new Thread(towc.new A()));
		es.execute(new Thread(towc.new B()));
		es.execute(new Thread(towc.new C()));

		es.shutdown();
	}

	class A implements Runnable {
		@Override
		public void run() {
			while (outerCounter < 100) {

				try {
					lock.lock();

					while (concurrentThread != 'A') {
						try {
							conditionA.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					for (int j = 0; j < 3; j++) {
						if (outerCounter >= 100)
							break;
						System.out.println("Thread A: " + ++outerCounter);
					}
					concurrentThread = 'B';
					conditionB.signal();
				} finally {
					lock.unlock();
				}
			}

		}
	}

	class B implements Runnable {
		@Override
		public void run() {
			while (outerCounter < 100) {
				try {
					lock.lock();

					while (concurrentThread != 'B') {
						try {
							conditionB.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < 3; j++) {
						if (outerCounter >= 100)
							break;
						System.out.println("Thread B: " + ++outerCounter);
					}
					concurrentThread = 'C';
					conditionC.signal();
				} finally {
					lock.unlock();
				}
			}
		}

	}

	class C implements Runnable {
		@Override
		public void run() {
			while (outerCounter < 100) {
				try {
					lock.lock();

					while (concurrentThread != 'C') {
						try {
							conditionC.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < 3; j++) {
						if (outerCounter >= 100)
							break;
						System.out.println("Thread C: " + ++outerCounter);
					}
					concurrentThread = 'A';
					conditionA.signal();
				} finally {
					lock.unlock();
				}
			}
		}

	}
}
