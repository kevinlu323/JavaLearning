package com.linkui.problems;

import java.util.*;

public class MyMinStack {
	public static void main(String[] args){
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(0);
		ms.push(3);
		ms.push(0);
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
	}
}

class MinStack {
    List<Integer> list = new ArrayList<>();
    List<Integer> minList = new ArrayList<>();
    
    public void push(int x) {
        list.add(x);
        if(minList.size()==0) minList.add(x);
        else if(minList.get(minList.size()-1)>x) minList.add(x);
        else minList.add(minList.get(minList.size()-1));
    }

    public void pop() {
        list.remove(list.size()-1);
        minList.remove(minList.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }
}