package com.linkui.problems;

import java.util.*;

public class PalindromeString {
	public static void main(String[] args){
		new PalindromeString().start();
	}
	
	public void start(){
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "1a2";
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
	}
	
	public boolean isPalindrome(String s) {
		if (s == "") return false;
		List<Character> list = new ArrayList<>();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) list.add(c);
		}
		for (int i = 0; i < list.size() / 2; i++){
			if(list.get(i) != list.get(list.size()-1-i)) return false;
		}
		return true;
	}
}
