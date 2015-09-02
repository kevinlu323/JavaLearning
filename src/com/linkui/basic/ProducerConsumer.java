package com.linkui.basic;

public class ProducerConsumer {
	public static void main(String[] args){
		Basket bst = new Basket();
		new Thread(new Producer(bst)).start();
		new Thread(new Consumer(bst)).start();
	}
}

class Bread{
	int id;
	public Bread(int id){
		this.id = id;
	}
	public String toString(){
		return "Bread id: "+ id;
	}
}

class Basket{
	int index;
	Bread[] brdList = new Bread[6];
	
	public synchronized void push (Bread b){
		while (index == brdList.length){
			try{
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		notify();
		brdList[index++] = b;
		System.out.println("new bread produced, now there are " + index + " bread(s) in the basket");
	}
	
	public synchronized Bread pop(){
		while (index == 0){
			try{
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		notify();
		index--;
		System.out.println("A bread is consumed, now there are "+ index + " bread(s) in the basket");
		return brdList[index];
	}
}

class Producer implements Runnable{
	Basket bst = null;
	public Producer(Basket bst){
		this.bst = bst;
	}
	public void run(){
		for (int i = 0; i < 20; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producing the " + i +"th bread");
			bst.push(new Bread(i));
			
		}
	}
}

class Consumer implements Runnable{
	Basket bst = null;
	Bread br = null;
	public Consumer(Basket bst){
		this.bst = bst;
	}
	public void run(){
		for (int i = 0 ; i < 18; i++){
			try{
				Thread.sleep(1300);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			br = bst.pop();
			System.out.println("Consuming the bread: " + br);
		}
	}
}