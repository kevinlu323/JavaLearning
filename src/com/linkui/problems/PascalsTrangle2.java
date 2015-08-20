package com.linkui.problems;

import java.util.*;

public class PascalsTrangle2 {

	public static void main(String[] args){
		new PascalsTrangle2().start();
	}
	
	public void start(){
		int n = 7;
		List<Integer> list = getRow(n);
		for (int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}
	
	/**
	 * Get the Trangle till rowIndex, then return list.get(rowIndex).
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++){
			List<Integer> lowerL = new ArrayList<>();
			for (int j = 0; j <= i; j++){
				if (j == 0) lowerL.add(1);
				else if (j == i) lowerL.add(1);
				else {
				lowerL.add(l.get(i-1).get(j-1) + l.get(i-1).get(j));
				}
			}
			l.add(lowerL);
		}
		return l.get(rowIndex);
	}
}
