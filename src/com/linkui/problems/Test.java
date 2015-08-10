package com.linkui.problems;

import java.util.*;

public class Test {
	public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n5;
        printList(n1);
        //printList(rev(n1));
        System.out.println(isPalindrome2(n1));
    }
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow == fast){ // only 2 element in the list
            if(head.val != head.next.val) return false;
            else return true;
        }
        ListNode next = slow.next;
        ListNode right = slow;
        right.next = null;
        System.out.print(slow.val+" ");
        while(next != null){
            ListNode tmp = next.next;
            next.next = right;
            right = next;
            next = tmp;
        }
        System.out.println(right.val);
        while(head != slow){
            if(head.val != right.val){
                return false;
            }
            System.out.println(head.val + " " + right.val+"  ;");
            head = head.next;
            right = right.next;
        }
        if(right.next != null) return false;
        return true;
    }
	
	public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        int count =0;
        ListNode left = head;
        while(left != null){
        	count++;
        	left = left.next;
        }
        
        int center = count/2;
        ListNode right = head;
        count = 0;
        while (count++ < center) right=right.next;
        ListNode newNode = right;
        ListNode next = right.next;
        
        //if(count%2 == 1) right = right.next;
        while(next != null){
        	ListNode tmp = next.next;
        	next.next = newNode;
        	newNode = next;
        	next = tmp;
        }
        System.out.println(newNode.val);
        count = 0;
        while(count++ < center){
        	if(head.val != newNode.val) return false;
        	System.out.println(head.val + " " + newNode.val + "   ;");
        	head = head.next;
        	newNode = newNode.next;
        }
        return true;
    }
	public static ListNode rev(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode newNode = head;
		ListNode next = head.next;
		newNode.next = null;
		while(next != null){
			ListNode tmp = next.next;
			next.next = newNode;
			newNode = next;
			next = tmp;
		}
		return newNode;
	}
	
	public static void printList(ListNode head){
		while (head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}