package com.linkui.basic;

public class TestAutoBoxing {
	public static void main(String[] args){
		int i = 5;
		Integer a1 = 6;
		Integer a2 = 5;
		int rest = a1 + a2; // can do operation using Integer, auto-unboxing
		System.out.println(i);
		System.out.println(rest);
	}
}
