package com.linkui.problems;

public class LengthOfLastWord {

	public static void main(String[] args){
		String s="a b   ";
		System.out.println(s.length());
		System.out.println(lengthOfLastWord(s));
	}
	public static int lengthOfLastWord(String s) {
        if (s == null) return 0;
		int i = 0;
		boolean wordFlag = false;
        for (int j = s.length()-1; j>=0; j--){
        	char c = s.charAt(j);
        	if (c == ' '){
        		if(!wordFlag) continue;
        		else break;
        	}
        	i++;
        	wordFlag = true;
        }
        return i;
    }
}
