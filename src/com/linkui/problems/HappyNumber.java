package com.linkui.problems;

import java.util.*;

public class HappyNumber {
	public static void main (String[] args){
		new HappyNumber().start();
	}
	
	public void start(){
		int i1 = 864;
		System.out.println("i1 " + 
				(isHappy(i1)? "is a Happy number": "is not a happy number"));
	}
	
	public boolean isHappy(int n) {
		int result = 0;
		Map<Integer, Integer> m = new HashMap<>();
		while (n != 1){
			result = 0;
			while (n > 0){
				result = result + (n % 10) * (n % 10);
				n /= 10;
			}
			System.out.println(result);
			if (m.get(result) == null){
				m.put(result, 1);
			}
			else {
				m.put(result, m.get(result) +1);
			}
			if (m.get(result) > 1) return false;
			n = result;
		}
		return true;
	}
}
