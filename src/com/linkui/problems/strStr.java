package com.linkui.problems;

public class strStr {
	public static void main(String[] args){
		new strStr().start();
	}
	
	public void start(){
		String h = "BBC ABCDAB ABCDABDDABDE";
		String n = "ABCDABD";
		System.out.println(strStr(h, n));
	}
	
	public int strStr(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		int i = 0, j = 0;
        char ch;
        char cn;
        while (i < hLen && j < nLen){
            ch = haystack.charAt(i);
            cn = needle.charAt(j);
        	if(ch == cn){
        		i++;
        		j++;
        	}
        	else{
        		i = i - j + 1;
        		j = 0;
        	}
        }
        if(j == nLen) return i - j;
        else return -1;
	}
}
