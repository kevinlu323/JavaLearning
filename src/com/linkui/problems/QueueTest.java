package com.linkui.problems;

import java.util.*;

public class QueueTest {
	public static void main(String[] args){
		Queue<Integer> q = new LinkedList<>(); //FIFO
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("peek():" +q.peek());
		System.out.println("element():" +q.element()); //element gives Exception if no element
		System.out.println("poll():" +q.poll());
		System.out.println("remove():" +q.remove()); // throws exception
		MyStack ms = new MyStack();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		System.out.println(ms.empty());
		System.out.println(ms.top());
		ms.pop();
		System.out.println(ms.top());
		ms.pop();
		System.out.println(ms.top());
		ms.pop();
		//System.out.println(ms.top());
		System.out.println(ms.empty());
	}
}

class MyStack{
	Queue<Integer> q = new LinkedList<>();
	// Push element x onto stack.
    public void push(int x) {
    	Queue<Integer> tmp = new LinkedList<>();
        while(q.peek() != null){
        	tmp.add(q.poll());
        }
        q.add(x);
        while(tmp.peek() != null){
        	q.add(tmp.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.peek()==null;
    }
}