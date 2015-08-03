package com.linkui.problems;

public class DifferentSort {
	public static void main(String[] args){
		int[] a = {4,8,1,2,9,10,3,5,7,6};
		System.out.println("Array length: "+ a.length);
		//bubbleSort(a);
		//insertSort(a);
		mergeSort(a, a.length);
		for (int i =0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	public static void bubbleSort (int[] a){ //O(n^2)
		if(a.length == 1){
			return;
		}
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a.length -i -1 ; j++){
				if(a[j] > a[j+1]){
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	
	public static void insertSort(int a[]){ // O(n^2)
		if(a.length == 1){
			return;
		}
		for(int i = 1; i < a.length; i++){
			int tmp = a[i];
			int j = i-1;
			while(j>=0 && tmp < a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = tmp;
		}
	}
	
	public static void mergeSort(int a[], int len){
		int[] tmp = new int[len];
		mergeSortSub(a, tmp, 0, len-1);
	}
	
	public static void mergeSortSub(int a[], int[] tmp, int left, int right){
		if(left >= right){
			return;
		} else{
			int center = (left + right)/2;
			System.out.print("mid: " + center +" ");
			mergeSortSub(a, tmp, left, center);
			mergeSortSub(a, tmp, center+1, right);
			merge(a, tmp, left, center, right);
		}
	}
	
	public static void merge(int[] a, int[] tmp, int left, int center, int right){
		int mid = center +1;
		int curr = left;
		int tmpLeft = left;
		while(left <= center && mid <= right){
			if(a[left] <= a[mid]){
				tmp[curr++] = a[left++];
			} else {
				tmp[curr++] = a[mid++];
			}
		}
		
		while (left <= center){
			tmp[curr++] = a[left++];
		}
		while (mid <= right){
			tmp[curr++] = a[mid++];
		}
		
		while(tmpLeft <= right){
			a[tmpLeft] = tmp[tmpLeft++];
		}
	}
}
