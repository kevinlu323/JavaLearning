package com.linkui.problems;

import java.util.*;
public class RomanToInt {
	public static void main(String[] args){
		String s = "CXCIX";
		System.out.println(romanToInt(s));
	}
	public static int romanToInt(String s) {
		if(s == null) return 0;
        Map<Character,Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int curr;
        int next;
        int sum = 0;
        sum = m.get(s.charAt(0));
        for (int i = 0; i<s.length()-1; i++){
        	curr = m.get(s.charAt(i));
        	next = m.get(s.charAt(i+1));
        	if(curr >= next){
        		sum += next;
        	} else {
        		sum -= curr- curr + next;
        	}
        }
        return sum;
    }
}
