package com.linkui.problems;

public class AddBinary {
	public static void main(String[] args){
		new AddBinary().start();
	}
	
	public void start(){
		String s1 = "1";
		String s2 = "1110";
		System.out.println(addBinary2(s1,s2));
	}
	
	public String addBinary(String a, String b) {
		if(a == null) return b;
		if(b == null) return a;
		int sum = 0;
		int carryIn = 0;
		int lenA = a.length();
		int lenB = b.length();
		String rest = "";
		if (lenA < lenB){
			for (int i = 0; i< lenB - lenA; i++){
				a = "0" +a;
			}
		}
		if (lenA > lenB){
			for (int i =0; i< lenA - lenB; i++){
				b = "0" +b;
			}
		}
		for (int i = a.length()-1; i>=0; i--){
			if ((sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carryIn)>1){
				sum = sum -2;
				carryIn = 1;
			}
			else carryIn = 0;
			rest = sum + rest;
			System.out.println("Sum: "+ sum + " carryIn: " + carryIn);
			System.out.println(rest);
		}
		if(carryIn == 1) rest = carryIn + rest;
		return rest;
	}
	
	public String addBinary2(String a, String b) {
		StringBuffer result = new StringBuffer();
		int sum = 0;
		int carryIn = 0;
		for (int i = a.length() -1, j = b.length()-1; i >= 0 ||  j >= 0; i--, j--){
			int v1 = (i < 0)? 0:(a.charAt(i) - '0');
			int v2 = (j < 0)? 0:(b.charAt(j) - '0');
			
			sum = v1 + v2 + carryIn;
			carryIn = sum > 1? 1 : 0; 
			sum = sum  > 1? sum-2:sum;
			
			System.out.println("v1: " + v1 + " v2: " + v2 + " sum: " + sum + " carryIn: " + carryIn);
			result.insert(0, sum);
		}
		if(carryIn == 1) result.insert(0, '1');
		return result.toString();
	}
}
