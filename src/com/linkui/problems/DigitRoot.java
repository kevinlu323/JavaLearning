package com.linkui.problems;

public class DigitRoot {
	public static void main (String[] args){
		new DigitRoot().start();
	}
	
	public void start(){
		int i1 = 2035;
		int i2 = 38;
		System.out.println(addDigits2(i1));
		System.out.println(addDigits2(i2));
		System.out.println(addDigits2(i2));
	}
	
	public int addDigits(int num){
		return num == 0? 0: (num % 9 == 0? 9: num %9);
	}
	
	public int addDigits2 (int num){
		int tmp = 0;
		if(num >= 10){
			while (num > 0){
				tmp = tmp + (num % 10);
				num /= 10;
			}
			System.out.println(tmp);
			if(tmp >= 10)
				tmp = addDigits2(tmp);
		}
		else tmp = num;
		return tmp;
	}
}
