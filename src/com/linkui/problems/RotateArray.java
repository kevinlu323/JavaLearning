package com.linkui.problems;

public class RotateArray {
	public static void main(String[] args){
		int[] nums = {1,2};
		rotate(nums,1);
		for (int i = 0; i<nums.length; i++){
        	System.out.print(nums[i] + " ");
        }
		
	}
	public static void rotate(int[] nums, int k) {
		k = k%nums.length;
		int[] tmp = new int[nums.length];
		System.arraycopy(nums, nums.length-k, tmp, 0, k);
		System.arraycopy(nums, 0, tmp, k, nums.length-k);
		System.arraycopy(tmp, 0, nums, 0, tmp.length);
		
        /*for (int i =0; i<k; i++){
        	int last = nums[nums.length-1];
        	for(int j = nums.length-1; j>0; j--){
        		nums[j] = nums[j-1];
        	}
        	nums[0] = last;
        }
        System.out.println();
        for (int i = 0; i<nums.length; i++){
        	System.out.print(nums[i] + " ");
        }*/
    }
}
