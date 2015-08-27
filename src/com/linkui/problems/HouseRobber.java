package com.linkui.problems;

public class HouseRobber {
	public static void main(String[] args){
		new HouseRobber().start();
	}
	
	public void start(){
		int[] houses = {1,3,5,7,6,9,10,11};
		System.out.println(rob(houses));
	}
	
	public int rob(int[] nums) {
		int robbed = 0;
		int notRobbed = 0;
		
		for (int i = 0; i < nums.length; i++){
			//only when previous is not robbed can this one be robbed.
			int robIt = notRobbed + nums[i];
			//if not rob this one, get the maximum value of previous one.
			int notRobIt = Math.max(robbed, notRobbed);
			//update values;
			robbed = robIt;
			notRobbed = notRobIt;
		}
		
		return Math.max(robbed, notRobbed);
	}
}
