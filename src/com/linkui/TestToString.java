package com.linkui;

public class TestToString {
	public static void main(String[] args){
		Dog d = new Dog();
		System.out.println("d= "+d);
	}
}

class Dog{
	//override toString() method
	public String toString(){
		return "toString test overwrite";
	}
}
