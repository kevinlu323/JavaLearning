package com.linkui.problems;

public class ExcelColumnTitle {
	public static void main(String[] args){
		new ExcelColumnTitle().start();
	}
	
	public void start(){
		int n = 676;
		System.out.println(convertToTitle(n));
		//System.out.println((char)('A' + 25));
	}
	
	public String convertToTitle(int n) {
		if(n <= 0) return "";
		else return convertToTitle(--n / 26) + (char)('A' + (n % 26));
	}
}
