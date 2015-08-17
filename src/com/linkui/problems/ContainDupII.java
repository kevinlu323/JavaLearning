package com.linkui.problems;

import java.util.*;

public class ContainDupII {
	public static void main(String[] args){
		new ContainDupII().start();
	}
	
	public void start(){
		int nums[] = {1,2,3,4,5,1,6,7,8,9,10};
		System.out.println(containsNearbyDuplicate(nums,4));
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> m = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if (m.get(nums[i])==null) {
				m.put(nums[i], i);
			} else {
				int tmp = m.get(nums[i]);
				if(i - tmp <= k){
					return true;
				}
				m.put(nums[i], i);
			}
		}
		return false;
	}
}
