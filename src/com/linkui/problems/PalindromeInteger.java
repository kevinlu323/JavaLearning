package com.linkui.problems;

public class PalindromeInteger {
	public static void main(String[] args) {
		new PalindromeInteger().start();
	}

	public void start() {
		int a = 1000000001;
		System.out.println(a%10000000);
		System.out.println(isPalindrome(a));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		long highDiv = 1;
		int length = 0;
		while (x / highDiv > 0) {
			highDiv *= 10;
			length++;
		}
		highDiv /= 10;
		for (int i = 0; i < length / 2; i++) {
			System.out.println(x % 10 +":" + x / highDiv % 10);
			if(x % 10 != x / highDiv % 10){
				return false;
			}
			x /= 10;
			highDiv /= 100;
		}
		return true;
	}
}
