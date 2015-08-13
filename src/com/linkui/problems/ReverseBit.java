package com.linkui.problems;

import java.util.*;

public class ReverseBit {
	public static void main(String[] args){
		int n = 1;
		System.out.println(reverseBits(n));
	}
	public static int reverseBits(int n) {
        int x = 0;
        for(int i=0; i<32; i++){
        	x = (x << 1) | (n & 1);
        	n = n>>1;
        }
        return x;
    }
}
