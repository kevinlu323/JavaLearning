package com.linkui.basic;

public class BubbleSort {
	public static void main(String[] args){
		int[] nums = {3,4,7,1,2,6,10,9};
		nums = bubbleSort(nums);
		for (int i = 0 ; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	public static int[] bubbleSort(int[] nums){
		int tmp;
		int len = nums.length;
		for (int i = 1; i < len; i++){
			for (int j = 0; j < len -i; j++){
				if(nums[j] > nums[j+1]){
					tmp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
}
