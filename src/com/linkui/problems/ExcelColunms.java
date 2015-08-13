package com.linkui.problems;

import java.util.*;
public class ExcelColunms {
	public static void main(String[] args){
		String c = "BA";
		System.out.println(titleToNumber(c));
	}
	public static int titleToNumber(String s) {
		int col = 0;
        for(int i = 0; i<s.length(); i++){
        	col = col *26 + (int)(s.charAt(i)-'A'+1);
        }
        return col;
    }
	
	/**
	 * Another way
	 * @param s String needs to be analyzed
	 * @return Int value of the column number.
	 */
	/*public int titleToNumber2(String s) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
        	char c = s.charAt(i);
        	l.add(i, (int)c-'A'+1);
        }
        int col = 0;
        for(int i = 0; i<l.size(); i++){
        	System.out.print(l.get(i));
        	col = col *26 + l.get(i);
        }
        return col;
    }*/
}
