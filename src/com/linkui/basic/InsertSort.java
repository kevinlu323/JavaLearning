package com.linkui.basic;

public class InsertSort {
	public static void main(String[] args){
		int[] nums = {3,4,7,1,2,6,10,9};
		for (int i = 0 ; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("After insert sortion: ");
		insertSort(nums);
		for (int i = 0 ; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void insertSort(int[] nums){
		if (nums.length <= 1) return;
		for (int i = 1; i<nums.length; i++){
			int tmp = nums[i];
			int j = i-1;
			while (j>= 0 && tmp < nums[j]){
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = tmp;
		}
	}
}
