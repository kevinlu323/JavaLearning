package com.linkui.basic;

public class TestExceptionExtend {
	public static void main(String[] args){
		try{
			throw new ExampleB("b");
		} catch (ExampleA e){
			System.out.println("ExampleA");
		} catch (Exception e){
			System.out.println("Exception"); // not execute
		}
	}
}

class ExampleA extends Exception{}

class ExampleB extends ExampleA{
	ExampleB(String s){
		System.out.println(s);
	}
}