package com.linkui.problems;

public class PowerOf2 {

	public static void main(String[] args){
		int n = 1073741825;
		System.out.println(isPowerOfTwo(n));
	}
	
	public static boolean isPowerOfTwo(int n){
		long i = 1;
		while(i < n){
			i <<= 1;
			System.out.println(i);
			if(i == n){
				return true;
			}
		}
		return false;
	}
}
