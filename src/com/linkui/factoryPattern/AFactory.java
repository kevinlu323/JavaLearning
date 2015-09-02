package com.linkui.factoryPattern;

public class AFactory implements KitchenFactory{
	@Override
	public Food getFood(){
		return new Milk();
	}
	
	public TableWare getTableWare(){
		return new Spoon();
	}
}
