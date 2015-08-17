package com.linkui.problems;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		new LongestCommonPrefix().start();
	}

	public void start() {
		String s1 = "pre123";
		String s2 = "prefix123";
		String s3 = "pref123";
		String[] ss = new String[3];
		ss[0] = s1;
		ss[1] = s2;
		ss[2] = s3;
		System.out.println(longestCommonPrefix(ss));
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		int len = strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			if (len > strs[i].length())
				len = strs[i].length();
		}
		StringBuffer sb = new StringBuffer();
		char c;
		for (int i = 0; i < len; i++) {
			c = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					return sb.toString();
				}
					
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
