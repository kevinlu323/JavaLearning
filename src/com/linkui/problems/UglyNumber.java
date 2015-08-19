package com.linkui.problems;

public class UglyNumber {
	public static void main(String[] args){
		new UglyNumber().start();
	}
	
	public void start(){
		int n1 = -8;
		System.out.println(isUgly(n1));
	}
	
	public boolean isUgly(int num) {
		if(num == 0) return false;
		while (num % 5 == 0) num /= 5;
		System.out.println("/5: " + num);	
		while (num % 3 == 0) num /= 3;
		System.out.println("/3: " + num);
		while (num % 2 == 0) num /= 2;
		System.out.println("/2: " + num);
			
		if (num ==1) return true;
		else return false;
	}
}
