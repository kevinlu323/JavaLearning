package com.linkui.problems;

import java.util.*;

public class CheckDup {

	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,3};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	int freq = m.get(nums[i])==null? 1:m.get(nums[i]);
        	if(freq >= 2){
        		return true;
        	}
        	m.put(nums[i], ++freq);
        }
        return false;
    }
}
