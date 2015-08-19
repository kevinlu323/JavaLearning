package com.linkui.problems;

public class GetZeroCount {
	public static void main(String[] args){
		new GetZeroCount().start();
	}
	
	public void start(){
		int n1 = 1808548329;
		System.out.println(1808548329/5);
		System.out.println(trailingZeroes(n1));
	}
	
	public int trailingZeroes(int n) {
		int count = 0;
		while (n!= 0){
			count += n/5;
			n /= 5;
		}
		return count;
	}
}
