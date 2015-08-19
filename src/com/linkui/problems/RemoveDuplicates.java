package com.linkui.problems;

public class RemoveDuplicates {

	public static void main(String[] args){
		new RemoveDuplicates().start();
	}
	
	public void start(){
		int[] nums = {1,1,2,3,4,5,6,6,7,8,9,10};
		//int[] nums = {1,1,2,2};
		System.out.println("Original length: " + nums.length);
		System.out.println(removeDuplicates2(nums));
		for (int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	public int removeDuplicates(int[] nums) {
		int front = 0;
		int dupCount = 0;
		for (int i = 1; i < nums.length - dupCount; i++){
			if (nums[i] == nums[front]){
				dupCount ++;
				for (int j = front +1; j < nums.length -1 ; j++){
					nums[j] = nums[j+1];
					i = front;
				}
			}
			else {
				front = i;
			}
		}
		return nums.length - dupCount;
	}
	
	public int removeDuplicates2(int[] nums) {
		if (nums.length == 0 || nums.length == 1) return nums.length;
		int front = 0;
		int back = 1;
		while (back < nums.length){
			if (nums[front] == nums[back]){
				back ++;
			}
			else {
				front ++;
				nums[front] = nums[back];
				back ++;
			}
		}
		return ++front;
	}
}
