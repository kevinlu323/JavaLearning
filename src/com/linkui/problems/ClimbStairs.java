package com.linkui.problems;

public class ClimbStairs {
	public static void main(String[] args){
		new ClimbStairs().start();
	}
	
	public void start(){
		int n = 4;
		System.out.println(climbStairs(n));
	}
	
	public int climbStairs(int n) {
		if(n == 0 || n ==1) return n;
		int sN_1 = 1; // ways to climb to n-1 stairs, initial is 1 (climb 1 step to n=1)
		int sN_2 = 1; // ways to climb to n-2 stairs, initial is 1 (not climb, stay at 0)
		int result = 0;
		for(int i = 2; i <= n; i++){
			result = sN_1 + sN_2;
			sN_2 = sN_1;
			sN_1 = result;
		}
		return result;
	}
}
