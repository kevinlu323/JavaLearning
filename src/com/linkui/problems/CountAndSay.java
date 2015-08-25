package com.linkui.problems;

public class CountAndSay {
	public static void main(String[] args){
		new CountAndSay().start();
	}
	
	public void start(){
		int n = 5;
		System.out.println(countAndSay(n));
	}
	
	public String countAndSay(int n) {
		if (n < 1) return "";
		String rest = "1";
		//StringBuffer rest = new StringBuffer("1");
		for (int i = 2; i <= n; i++){
			int count = 1;
			char pre = rest.charAt(0);
			StringBuffer tmp = new StringBuffer();
			for (int j = 1; j < rest.length(); j++){
				if(rest.charAt(j) == pre){
					count++;
				}
				else{
					//tmp += count;
					tmp.append(count);
					//tmp += pre;
					tmp.append(pre);
					count = 1;
					pre = rest.charAt(j);
				}
			}
			//tmp += count;
			tmp.append(count);
			//tmp += pre;
			tmp.append(pre);
			rest = tmp.toString();
			
		}
		return rest;
	}
}
