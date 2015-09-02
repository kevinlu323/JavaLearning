package com.linkui.factoryPattern;

public class BFactory implements KitchenFactory{

	@Override
	public Food getFood() {
		return new Noodle();
	}

	@Override
	public TableWare getTableWare() {
		return new Chopsticks();
	}
	
}
