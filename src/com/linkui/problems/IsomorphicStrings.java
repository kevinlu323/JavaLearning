package com.linkui.problems;

import java.util.*;

public class IsomorphicStrings {

	public static void main (String[] args){
		new IsomorphicStrings().start();
	}
	
	public void start(){
		String s1 = "paper";
		String s2 = "title";
		System.out.println(isIsomorphic(s1, s2));
	}
	
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false; 
		List<Character> l1 = new ArrayList<>();
		List<Character> l2 = new ArrayList<>();
		for (int i = 0; i < s.length(); i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(!l1.contains(c1) && !l2.contains(c2)){ // Do not add dupped char
				l1.add(c1);
				l2.add(c2);
			} 
			else if(l1.indexOf(c1) != l2.indexOf(c2)){ //check if index is equal
				return false;
			}
		}
		return true;
	}
}
