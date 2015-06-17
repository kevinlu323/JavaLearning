package com.linkui;

public class FindMax {
	public static int findMaxValue(int[] a){
		int maxVal=a[0];
		for(int i=1;i<a.length;i++){
			if(maxVal<a[i]){
				maxVal=a[i];
			}
		}
		return maxVal;
	}
	
	public static void main (String[] args){
		int a[]={1,5,2,8,4,1,6,0};
		int maxValue = findMaxValue(a);
		System.out.println(maxValue);
	}
}
