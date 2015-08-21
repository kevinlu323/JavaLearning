package com.linkui.problems;

public class ZigzagConversion {
	public static void main(String[] args){
		new ZigzagConversion().start();
	}
	
	public void start(){
		String s = "PAYPALISHIRING";
		int row = 3;
		System.out.println(convert(s, row));
	}
	
	public String convert(String s, int numRows) {
		if(numRows == 1) return s;
		String sb = "";
		int interval = (numRows<<1) -2;
		for (int i = 0; i < s.length(); i += interval){
			sb += s.charAt(i);
		}
		for (int i = 1; i < numRows -1; i++){
			for (int j = i; j < s.length(); j += interval){
				sb += s.charAt(j);
				if (j + interval - 2 * i < s.length())
					sb += s.charAt(j + interval - 2 * i);
			}
		}
		for (int i = numRows-1 ; i<s.length(); i+=interval){
			sb += s.charAt(i);
		}
		return sb.toString();
	}
}
