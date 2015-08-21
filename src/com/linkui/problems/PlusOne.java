package com.linkui.problems;

public class PlusOne {
	public static void main(String[] args){
		new PlusOne().start();
	}
	
	public void start(){
		int[] num = {1,9,9,9};
		int[] newNum = plusOne(num);
		for (int i = 0 ; i< newNum.length; i++){
			System.out.print(newNum[i] + " ");
		}
	}
	
	public int[] plusOne(int[] digits) {
		int carryIn = 1;
		int sum = 0;
		for (int i = digits.length-1; i >= 0; i--){
			sum = digits[i] + carryIn;
			if(sum > 9){
				sum = sum - 10;
				carryIn = 1;
			}
			else carryIn = 0;
			digits[i] = sum;
		}
		if(digits[0] == 0){
			int[] newArray = new int[digits.length + 1];
			System.arraycopy(digits, 0, newArray, 1, digits.length);
			newArray[0] = 1;
			return newArray;
		}
		return digits;
	}
}
