package com.linkui.problems;

public class FindPrimes {
	public static void main(String[] args){
		int n = 120;
		System.out.println("Count: " +countPrimes(n));
		
	}
	public static int countPrimes(int n) {
		boolean[] b = new boolean[n];
        int count = 0;
        for(int i = 2; i < n;i++){
	        for(int j = 2; i * j <n; j++){
	        	b[i*j] = true;
	        }
        }
        for(int i = 2; i<n;i++){
        	if(!b[i]){
        		System.out.print(i + " ");
        		count++;
        	}
        }
        return count;
    }
}
