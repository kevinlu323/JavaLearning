package com.linkui.basic;

public class Draft {
	public static void main(String[] args){
		StringBuffer sb1 = new StringBuffer("123");
		StringBuffer sb2 = new StringBuffer("123");
		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		String s1 = new String("123");
		String s2 = new String("123");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
