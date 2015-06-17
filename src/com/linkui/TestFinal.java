package com.linkui;

public class TestFinal {
	public static void main(String[] args){
		T t = new T();
		t.i=9;
	}
}

class T{
	int i = 8;
	final public void m(){
		//j = 9;
	}
}

class TT extends T{
}