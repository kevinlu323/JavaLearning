package com.linkui.problems;

public class MergeSortedArray {
	public static void main(String[] args){
		new MergeSortedArray().start();
	}
	
	public void start(){
		int[] nums1 = new int[10];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		nums1[3] = 7;
		nums1[4] = 9;
		int nums2[] = {2,4,6,8,10};
		merge(nums1, 5, nums2, 5);
		for (int i = 0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0, tmpIndex = 0;
		int[] tmp = new int[nums1.length];
		while (i < m && j < n){
			if(nums1[i] < nums2[j]){
				tmp[tmpIndex++] = nums1[i++];
			}
			else {
				tmp[tmpIndex++] = nums2[j++];
			}
		}
		while (i < m){
			tmp[tmpIndex++] = nums1[i++];
		}
		while (j < n){
			tmp[tmpIndex++] = nums2[j++];
		}
		System.arraycopy(tmp, 0, nums1, 0, tmpIndex);
	}
}
