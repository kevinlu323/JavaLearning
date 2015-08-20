package com.linkui.problems;

import java.util.*;

public class PascalsTriangle {
	public static void main(String[] args){
		new PascalsTriangle().start();
	}
	
	public void start(){
		int n = 5;
		List<List<Integer>> ptList = generate(n);
		for (int i = 0; i < ptList.size(); i++){
			for (int j = 0; j <= i; j++){
				System.out.print(ptList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < numRows; i++){
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
		return l;
	}
	
	/**
	 * reference
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate2(int numRows) {
        //1
        //2
        //3
        List<List<Integer>> pascal =new ArrayList<List<Integer>>();
        for(int i = 1; i <= numRows ; i++) {
            List<Integer> l=new ArrayList<Integer>();
            pascal.add(l);                
            for(int j=0;j<i;j++) {
                if (j==0)
                    l.add(1);
                else if (j==i-1) 
                    l.add(1);
                else if (j>0) 
                    l.add(pascal.get(i-2).get(j-1)+pascal.get(i-2).get(j));
            }
        }
        return pascal;
    }
}
