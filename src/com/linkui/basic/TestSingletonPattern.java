package com.linkui.basic;

public class TestSingletonPattern {
	public static void main(String[] args){
		Singleton s = Singleton.getInstance();
		int result = s.getReturn();
		System.out.println(result);
	}
}

class Singleton{
	private volatile static Singleton instance = null;
	private Singleton(){}
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public int getReturn(){
		return 323;
	}
}