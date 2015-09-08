package com.linkui.basic;

public class TestPrivate {
	public static void main(String[] args) {
		BB a  = new BB();
		System.out.println(a.getI());
		CC b = new CC();
		System.out.println(b.a123.getI());
		
	}
}

class AA{
	private int i = 20;
	
	private void addI(){
		i+= 10;
	}
	
	public int getI(){
		this.addI();
		return i;
	}
}
class BB extends AA{
	
}

class CC{
	public AA a123;

	public CC() {
		this.a123 = new AA();
	}
	
}