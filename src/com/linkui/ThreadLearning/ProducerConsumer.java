package com.linkui.ThreadLearning;

public class ProducerConsumer {
	public static void main(String[] args){
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(p).start();
		new Thread(c).start();
	}
}

class WoTou{
	int id;
	WoTou(int _id){
		this.id=_id;
	}
	
	public String toString(){
		return "WoTou id: "+id;
	}
}

class SyncStack{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];
	
	public synchronized void push(WoTou wt){
		while (index==arrWT.length){ //wait if Stack is full
			try{
				this.wait();
			}catch (InterruptedException e){
				System.out.println("Error while Producer waiting");
				e.printStackTrace();
			}
		}
		this.notifyAll();
		arrWT[index]=wt;
		index++;
		System.out.println("Now there are: "+index+" WoTou in the basket");
	}
	
	public synchronized WoTou pop(){
		while (index==0){
			try{
				this.wait();
			} catch(InterruptedException e){
				System.out.println("Error while Consumer waiting");
				e.printStackTrace();
			}
		}
		this.notifyAll();
		System.out.println("Now there are: "+index+" WoTou in the basket");
		index--;
		return arrWT[index];
	}
}

class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack _ss){
		this.ss=_ss;
	}
	
	public void run(){
		for(int i=0;i<20;i++){
			WoTou wt = new WoTou(i);
			ss.push(wt);
			System.out.println("Produced: "+wt);
			try{
				Thread.sleep(500);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	SyncStack ss = null;
	Consumer(SyncStack _ss){
		this.ss=_ss;
	}
	
	public void run(){
		for (int i =0;i<40;i++){
			WoTou wt = ss.pop();
			System.out.println("Consumed: "+wt);
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}