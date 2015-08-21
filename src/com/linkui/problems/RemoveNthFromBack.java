package com.linkui.problems;

public class RemoveNthFromBack {
	public static void main(String[] args){
		new RemoveNthFromBack().start();
	}
	
	public void start(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode head = removeNthFromEnd(n1, 2);
		while (head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;
		dummyHead.next = head;
		for (int i = 0; i <= n; i++){
			fast = fast.next;
		}
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		System.out.println(slow.val);
		return dummyHead.next;
	}
}
