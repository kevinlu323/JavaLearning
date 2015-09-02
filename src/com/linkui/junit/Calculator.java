package com.linkui.junit;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int square(int a) {
		return a * a;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int squareRoot(int a) {
		for (;;)
			; // simulate a endless for loop
	}

	public int divide(int a, int b) throws ArithmeticException {
		if (b == 0)
			throw new ArithmeticException("Divisor is 0");
		return a / b;
	}

	private String formulaStr(char sign, int... numbers) {
		StringBuilder formula = new StringBuilder(16);
		for (int num : numbers) {
			formula.append(num).append(sign);
		}
		formula.deleteCharAt(formula.length() - 1);
		formula.append('=');

		return formula.toString();
	}
	
	private String getBonus(String str){
		if(str == "I wanna bonus!") 
			return "you get the bonus!";
		return null;
	}
}
