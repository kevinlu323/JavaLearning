package com.linkui.problems;

public class Bit1Count {

	public static void main(String[] args){
		int n =11;
		System.out.println(hammingWeight(n));
	}
	public static int hammingWeight(int n) {
        Integer a = new Integer(n);
        int count = a.bitCount(n);
        return count;
    }
}
