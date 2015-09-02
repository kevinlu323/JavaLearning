package com.linkui.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

public class ProducerConsumerWithCondition {
	Lock lock = new ReentrantLock();
	Condition fullCond = lock.newCondition();
	Condition emtCond = lock.newCondition();
	List<Goods> goods = new ArrayList<>();
	int goodsSize = 5;
	
	public static void main(String[] args){
		ProducerConsumerWithCondition pcwc = new ProducerConsumerWithCondition();
		new Thread(pcwc.new Producer(pcwc)).start();
		new Thread(pcwc.new Consumer(pcwc)).start();
		
	}
	
	private void makeGoods(Goods g){
		lock.lock();
		try{
			while(goods.size() == goodsSize){
				try {
					System.out.println("Producer is waiting for consumer");
					emtCond.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			goods.add(g);
			System.out.println("a good is produced, " + g);
			System.out.println("Now the number of goods in store: "+ goods.size());
			fullCond.signal();
		}
		finally{
			lock.unlock();
		}
	}
	
	private void consumeGoods(){
		lock.lock();
		try{
			while(goods.size() == 0){
				try{
					System.out.println("No goods in store, wait for producer");
					fullCond.await();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Goods g = goods.get(goods.size()-1);
			System.out.println(g + " is consumed!");
			goods.remove(g);
			System.out.println("Now the number of goods in store: "+ goods.size());
			emtCond.signal();
		}
		finally{
			lock.unlock();
		}
	}
	
	class Producer implements Runnable{
		ProducerConsumerWithCondition pcwc;
		public Producer(ProducerConsumerWithCondition pcwc){
			this.pcwc = pcwc;
		}
		public void run(){
			for (int i = 0; i < 10; i++){
				pcwc.makeGoods(new Goods(i));
			}
		}
	}
	
	class Consumer implements Runnable{
		ProducerConsumerWithCondition pcwc;
		public Consumer(ProducerConsumerWithCondition pcwc){
			this.pcwc = pcwc;
		}
		
		@Override
		public void run(){
			for (int i = 0; i < 8; i++){
				pcwc.consumeGoods();
			}
		}
	}
	
}

class Goods {
	int id;
	public Goods(int id){
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "Good id: " + id;
	}
}