package com.linkui.problems;

import java.util.Stack;

public class LinkedListDemo {

	private static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(7);
		Node n5 = new Node(9);
		Node n6 = new Node(11);
		Node n7 = new Node(13);
		Node cn1 = new Node(1);
		Node cn2 = new Node(3);
		Node cn3 = new Node(5);
		Node cn4 = new Node(7);
		Node cn5 = new Node(9);
		Node cn6 = new Node(11);
		Node cn7 = new Node(13);
		Node i1 = new Node(3);
		Node i2 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		cn1.next = cn2;
		cn2.next = cn3;
		cn3.next = cn4;
		cn4.next = cn5;
		cn5.next = cn6;
		cn6.next = cn7;
		cn7.next = cn3;
		i2.next = i1;
		Node c1 = new Node (2);
		Node c2 = new Node (4);
		Node c3 = new Node (6);
		Node c4 = new Node (8);
		Node c5 = new Node (10);
		c1.next = c2;
		c2.next = c3;
		c3.next = c4;
		c4.next = c5;
		
		printList(n1);
		int k = 3;
		System.out.println("The " + k + "th value from back is: " + getRevKth(n1,3).val);
		System.out.println("The Middle value is: " + getMiddleNode(n1).val);
		System.out.println("Merging list n1 & c1: ");
		Node merged = merge2List(n1,c1);
		printList(merged);
		deleteNodeFrom(merged, n7);
		System.out.println("c2 is deleted from the merged list");
		printList(merged);
		Node cycleN = detectCycle(cn1);
		if(cycleN !=null) System.out.println("Cycle exist in cn1, the cycle start at value: " + cycleN.val);
		if(isIntersect(n1, cn1)) System.out.println("2 lists are intersected.");
		printRevList(n1);
		System.out.println(getLength(n1));
		Node r1 = reverseList2(n1);
		printList(r1);
		Node ii = getIntersectionNode(i1,i2);
		if(ii != null) System.out.println("Two list intesect at: " +ii.val);
	}
	
	public static void printList(Node head){
		if(head == null) return;
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	//get List length, need to pass the head node.
	public static int getLength(Node head){
		if(head == null) return 0;
		int len = 0;
		while(head != null){
			len ++;
			head = head.next;
		}
		return len;
	}
	
	//use more space
	public static Node reverseList(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node newNode = head;
		Node next = head.next;
		
		newNode.next = null;
		
		while(next != null){
			Node tmp = next.next;
			next.next = newNode;
			newNode = next;
			next = tmp;
		}
		return newNode;
	}
	
	//use 2 pointers
	public static Node reverseList2(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node p = head;
		Node q = head.next;
		p.next = null;
		while (q != null){
			Node r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		return p;
	}
	
	public static Node getRevKth(Node head, int k){
		if(null == head){
			return head;
		}
		Node fast = head;
		Node slow = head;
		
		while(k > 0){
			if(fast == null){
				return null; // k is larger than the list length
			}
			fast = fast.next;
			k--;
		}
		
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static Node getMiddleNode(Node head){
		if(null == head || null == head.next){
			return head;
		}
		
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void printRevList(Node head){
		if(null == head){
			return;
		}
		Stack<Integer> s = new Stack<Integer>(); //Use Stack, time complexity is O(n)
		while(head != null){
			s.push(head.val);
			head = head.next;
		}
		System.out.println("Printing List in reverse order: ");
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
		System.out.println();
	}
	
	public static Node merge2List(Node n1, Node n2){ // merge sort
		if(null == n1){
			return n2;
		} else if(null == n2){
			return n1;
		}
		
		Node dummyNode = new Node(0);
		Node curr = dummyNode;
		
		while (n1 != null && n2 != null){
			if(n1.val < n2.val){
				curr.next = n1;
				n1 = n1.next;
			} else{
				curr.next = n2;
				n2 = n2.next;
			}
			curr = curr.next;
		}
		
		if (n1 != null){
			curr.next = n1;
		} else {
			curr.next = n2;
		}
		
		return dummyNode.next;
	}
	
	public static boolean hasCycle(Node head){ //check if the list has cycle, use 2 pointers: fast & slow
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
	public static Node detectCycle(Node head){ // return the starting Node of the cycle if has cycle
		if (null == head || null == head.next){
			System.out.println("this list has Nodes less than 2");
			return head;
		}
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(slow == fast){
				Node n1 = head;
				while(true){
					if(n1 == slow){
						return n1;
					}
					n1 = n1.next;
					slow = slow.next; //
				}
			}
		}
		
		return null;
	}
	
	public static boolean isIntersect (Node n1, Node n2){
		if(null == n1 || null == n2){
			return false;
		}
		
		Node n1c = detectCycle(n1);
		Node n2c = detectCycle(n2);
		
		if(n1c != null && n2c != null){ //both n1 & n2 have cycle
			Node tmp = n1c;
			do{
				if(tmp == n2c){
					return true;
				}
			} while (tmp.next != n1c);
			return false;
		} else if(null == n1c && null == n2c){ //neither n1 or n2 has cycle
			while (n1.next != null){
				n1 = n1.next;
			}
			while (n2.next != null){
				n2 = n2.next;
			}
			if(n1 == n2){
				return true;
			} else{
				return false;
			}
		} else {
			return false; // one of n1 & n2 has cycle, the other one does not have.
		}
	}
	
	public static Node getIntersectionNode(Node headA, Node headB) {
		if(headA == headB) return headA;
		int lenA =0, lenB = 0;
		Node tmpA = headA;
		Node tmpB = headB;
		while (tmpA != null){
			lenA++;
			tmpA = tmpA.next;
		}
		while (tmpB != null){
			lenB++;
			tmpB = tmpB.next;
		}
		System.out.print(lenA +":" +lenB);
		tmpA = headA;
		tmpB = headB;
		if(lenA > lenB){
			for(int i =0; i<lenA-lenB; i++){
				tmpA = tmpA.next;
			}
		} 
		else if(lenA <lenB){
			for(int i =0; i<lenB-lenA; i++){
				tmpB = tmpB.next;
			}
		}
		while(tmpA != null){
			if(tmpA.val == tmpB.val){
				return tmpA;
			}
			tmpA = tmpA.next;
			tmpB = tmpB.next;
		}
		return null;
	}
	
	public static void deleteNodeFrom(Node head, Node toBeDeleted){ // With average time complexity O(1);
		if(null == head){
			return;
		}
		
		if(toBeDeleted.next != null){
			toBeDeleted.val = toBeDeleted.next.val;
			toBeDeleted.next = toBeDeleted.next.next;
		} else{
			while (head != null){
				if (head.next == toBeDeleted){
					head.next = toBeDeleted.next;
					return;
				}
				head = head.next;
			}
		}
		return;
	}
}
