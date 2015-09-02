package com.linkui.ThreadLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * ��Ŀ���������̷ֱ߳��ӡA��B��C,���ö��̱߳��ʵ�֣�����Ļ��ѭ����ӡ10��ABCABC��
 * 
 * ���������Lock��Condition��ʵ�֡�
 * 
 * @author Eric
 * 
 */
public class TestCondition {

	private Lock lock = new ReentrantLock();

	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();

	/** ��ǰ�̵߳����� */
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
							 * �����ǰ�߳����ֲ���A����ôThreadA�ʹ���ȴ�״̬
							 */
							conditionA.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * ��ӡ���ڼ����Լ�A��Ϣ
					 */
					System.out.println(String.format("��%d��", i + 1));
					System.out.println("A");

					/*
					 * ����ǰ�߳�����ΪB�� Ȼ��֪ͨThreadBִ��
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
							 * �����ǰ�߳����ֲ���B����ôThreadB�ʹ���ȴ�״̬
							 */
							conditionB.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * ��ӡ��ϢB
					 */
					System.out.println("B");

					/*
					 * ����ǰ�߳�ֵ��ΪC ��ͨ��ThreadC��ִ��
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
							 * �����ǰ�߳����ֲ���C����ôThreadC�ʹ���ȴ�״̬
							 */
							conditionC.await();
						} catch (InterruptedException e) {
							logger.severe(e.getLocalizedMessage());
						}
					}

					/*
					 * ��ӡ��ϢC
					 */
					System.out.println("C");
					System.out.println();

					/*
					 * ����ǰ�߳�ֵ��ΪA ��ͨ��ThreadA��ִ��
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