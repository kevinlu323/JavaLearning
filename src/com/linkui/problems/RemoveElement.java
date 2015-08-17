package com.linkui.problems;

public class RemoveElement {
	public static void main(String[] args){
		new RemoveElement().start();
	}
	
	public void start(){
		int[] nums = {1,2,3,4,5,6,7,8,6,10};
		System.out.println(removeElement(nums, 6));
	}
	
	public int removeElement(int[] nums, int val) {
		int len = 0;
		int deleteNo = 0;
		int[] newNums = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == val) {
				deleteNo ++;
				continue;
			}
			newNums[i-deleteNo] = nums[i];
			len++;
		}
		System.arraycopy(newNums, 0, nums, 0, len);
		return len;
	}
}
