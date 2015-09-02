package com.linkui.factoryPattern;

public class Client {
	public void eat (KitchenFactory kf){
		System.out.println("A person is eating: " + kf.getFood().getEatable() + " with " + kf.getTableWare().getTool());
	}
	
	public static void main(String[] args){
		Client c = new Client();
		KitchenFactory kf1 = new AFactory();
		c.eat(kf1);
		KitchenFactory kf2 = new BFactory();
		c.eat(kf2);
	}
}
