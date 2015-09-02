package com.linkui.ThreadLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * 题目：有三个线程分别打印A、B、C,请用多线程编程实现，在屏幕上循环打印10次ABCABC…
 * 
 * 本程序采用Lock和Condition来实现。
 * 
 * @author Eric
 * 
 */
public class TestCondition {

	private Lock lock = new ReentrantLock();

	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();

	/** 当前线程的名字 */
	private char currentThreadName = 'A';

	private static final Logger logger = Logger.getLogger("my.thread.test.OrderPrintTest");

	public static void main(String[] args) {

		TestCondition ce = new TestCondition();

		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(ce.new ThreadA());
		service.execute(ce.new ThreadB());
		service.execute(ce.new ThreadC());

		service.shutdown();
	}

	private class ThreadA implements Runnable {
		public void run() {

			for (int i = 0; i < 10; i++) {
				lock.lock();
				try {
					while (currentThreadName != 'A') {
						try {
							/*
							 * 如果当前线程名字不是A，那么ThreadA就处理等待状态
							 */
							conditionA.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * 打印出第几遍以及A信息
					 */
					System.out.println(String.format("第%d遍", i + 1));
					System.out.println("A");

					/*
					 * 将当前线程名置为B， 然后通知ThreadB执行
					 */
					currentThreadName = 'B';
					conditionB.signal();

				} finally {
					lock.unlock();
				}
			}
		}

	}

	private class ThreadB implements Runnable {
		public void run() {
			for (int i = 0; i < 10; i++) {
				lock.lock();
				try {
					while (currentThreadName != 'B') {
						try {
							/*
							 * 如果当前线程名字不是B，那么ThreadB就处理等待状态
							 */
							conditionB.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * 打印信息B
					 */
					System.out.println("B");

					/*
					 * 将当前线程值置为C 并通过ThreadC来执行
					 */
					currentThreadName = 'C';
					conditionC.signal();

				} finally {
					lock.unlock();
				}
			}

		}

	}

	private class ThreadC implements Runnable {

		public void run() {
			for (int i = 0; i < 10; i++) {
				lock.lock();
				try {
					while (currentThreadName != 'C') {
						try {
							/*
							 * 如果当前线程名字不是C，那么ThreadC就处理等待状态
							 */
							conditionC.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * 打印信息C
					 */
					System.out.println("C");
					System.out.println();

					/*
					 * 将当前线程值置为A 并通过ThreadA来执行
					 */
					currentThreadName = 'A';
					conditionA.signal();

				} finally {
					lock.unlock();
				}

			}
		}
	}
}