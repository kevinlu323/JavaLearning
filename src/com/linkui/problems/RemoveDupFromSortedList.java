package com.linkui.problems;

public class RemoveDupFromSortedList {
	public static void main(String[] args) {
		new RemoveDupFromSortedList().start();
	}

	public void start() {
		ListNodeForRemove n1 = new ListNodeForRemove(1);
		ListNodeForRemove n2 = new ListNodeForRemove(1);
		ListNodeForRemove n3 = new ListNodeForRemove(2);
		ListNodeForRemove n4 = new ListNodeForRemove(3);
		ListNodeForRemove n5 = new ListNodeForRemove(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNodeForRemove head = deleteDuplicates(n1);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public ListNodeForRemove deleteDuplicates(ListNodeForRemove head) {
		if (head == null)
			return head;
		ListNodeForRemove front = head;
		ListNodeForRemove back = head.next;
		while (back != null) {
			if (front.val == back.val) {
				back = back.next;
				if (back == null) // if the back pointer is out, need to do this
					front.next = back;
			} else {
				front.next = back;
				front = back;
				back = back.next;
			}
		}
		return head;
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNodeForRemove {
	int val;
	ListNodeForRemove next;

	ListNodeForRemove(int x) {
		val = x;
	}

}
