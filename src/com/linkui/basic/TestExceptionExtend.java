package com.linkui.basic;

public class TestExceptionExtend {
	public static void main(String[] args){
		try{
			throw new ExampleB("new ExceptionB");
		} catch (ExampleC e){
			System.out.println("ExampleC");
		} catch (ExampleB e){
			System.out.println("ExampleB");
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

class ExampleC extends ExampleB{

	ExampleC(String s) {
		super(s);
	}
}