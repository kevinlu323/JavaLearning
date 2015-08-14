package com.linkui.problems;

import java.util.*;

public class ValidParentheses {
	public static void main(String[] args){
		String s = "{(())}";
		System.out.println(isValid(s));
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char c;
		for (int i = 0; i<s.length(); i++){
			c = s.charAt(i);
			if (c == '(' || c == '[' ||c =='{') stack.push(c);
			else if (c == ')'){
				if(stack.isEmpty() || stack.pop() != '(') return false;
			}
			else if (c ==']'){
				if (stack.isEmpty() || stack.pop() != '[') return false;
			}
			else if (c == '}'){
				if (stack.isEmpty() || stack.pop() != '{') return false;
			}
		}
		if (stack.isEmpty()) return true;
		else return false;
	}
}
