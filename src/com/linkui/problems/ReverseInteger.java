package com.linkui.problems;

public class ReverseInteger {
	public static void main(String[] args){
		int a = 1000000003;
		System.out.println(reverse(a));
	}
	
	public static int reverse(int x) {
		boolean sign = x < 0? true : false;
		if(sign) x = x * -1;
		long revValue = 0;  //need to use long type here.
		while(x > 0){
			if(revValue * 10 > Integer.MAX_VALUE){
				return 0;
			}
			revValue = revValue * 10 + x%10;
			x = x/10;
		}
		if(sign) revValue = revValue * -1;
		return (int)revValue;
	}
}
