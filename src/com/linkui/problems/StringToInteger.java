package com.linkui.problems;

public class StringToInteger {
	public static void main(String[] args){
		new StringToInteger().start();
	}
	
	public void start(){
		String s1 = " -234 asdf 2333";
		String s2 = "1";
		String s3 = "2147483648";
		String s4 = "9223372036854775809";
		System.out.println(myAtoi(s1));
		System.out.println(myAtoi(s2));
		System.out.println(myAtoi(s3));
		System.out.println(myAtoi(s4));
	}
	
	public int myAtoi(String str){
		boolean sign = false;
		double result = 0;
		str = str.trim();
		if(str.length() == 0 ) return 0;
		char c = str.charAt(0);
		if(c == '+' || Character.isDigit(c)) sign = false;
		else if (c == '-') sign = true;
		else return 0;
		for (int i = 0; i < str.length(); i++){
			c = str.charAt(i);
			if (i > 0 && !Character.isDigit(c)) break;
			if(Character.isDigit(c)){
				result = result * 10 + (c-'0'); 
			}
		}
		System.out.println(result);
		if(sign) result *= -1;
		System.out.println(result);
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		else return (int)result;
	}
}
