package com.linkui.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * REFS:
 * http://blog.csdn.net/fightforyourdream/article/details/16353519  
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7393134 ���ɸ㶨�����е�������Ŀ 
 * http://www.cnblogs.com/jax/archive/2009/12/11/1621504.html �㷨��ȫ��1�������� 
 *  
 * Ŀ¼�� 
 * 1. �������н��ĸ���: getListLength 
 * 2. ��������ת: reverseList����������reverseListRec���ݹ飩 
 * 3. ���ҵ������еĵ�����K���ڵ㣨k > 0��: reGetKthNode 
 * 4. ���ҵ�������м���: getMiddleNode 
 * 5. ��β��ͷ��ӡ������: reversePrintListStack��reversePrintListRec���ݹ飩 
 * 6. ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����: mergeSortedList, mergeSortedListRec 
 * 7. �ж�һ�����������Ƿ��л�: hasCycle 
 * 8. �ж������������Ƿ��ཻ: isIntersect 
 * 9. �������������ཻ�ĵ�һ���ڵ�: getFirstCommonNode 
 * 10. ��֪һ���������д��ڻ�������뻷�еĵ�һ���ڵ�: detectCycle, getFirstNodeInCycleHashMap 
 * 11. ����һ������ͷָ��pHead��һ�ڵ�ָ��pToBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�pToBeDeleted: delete 
 *  
 */  

public class LinkedListFromJiuzhang {
    
    // create the link Node class.
    // why use static:
    // http://duqiangcise.iteye.com/blog/697476
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(8);
        ListNode m3 = new ListNode(9);
        m1.next = m2;
        m2.next = m3;
        
        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(12);
        c1.next = c2;
        c2.next = n1;
        //c2.next = c1;
        
        ListNode mergeNode = mergeLink(m1, c1);
        //ListNode mergeNode2 = mergeLink(m1, c1);
        //ListNode mergeNode = mergeSortedList(m1, c1);
        printList(mergeNode);
        //printList(mergeNode2);
        
        System.out.println();
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        printList(n1);
        
        Delete(n1, n5);
        
        printList(n1);
        
        // create a cycle
        //n5.next = n3;
        //n5.next = n6;
        //n6.next = n4;
        
//        System.out.println(hasCycle(n1));
//        System.out.println(getListLength(n1));
//        printList(n1);
//        
//        //n1 = reverseList(n1);
//        n1 = reverseListRec(n1);
//        printList(n1);
        
//        ListNode ret = reGetKthNode(n1, 7);
//        if (ret != null) {
//            System.out.println(ret.val);
//        } else {
//            System.out.println("null");
//        }
        
        //reGetKthNodeRec(n1, 1);
//        reGetKthNodeRec2(n1, 3);
//        ListNode ret = getMiddleNode(n1);
//        
//        if (ret != null) {
//            System.out.println(ret.val);
//        }                
//        
//        reversePrintListStackRec(n1);
//        reversePrintListStack(n1);
//        reversePrintListRev(n1);
        
        //printList(n1);
        
        System.out.println(isIntersect(n1, c1));
        
        System.out.println("TEST the getFirstCommonNode:");
        ListNode cross = getFirstCommonNode(n1, c1);
        if (cross == null) {
            System.out.println("null");
        } else {
            System.out.println(cross.val);
        }
        
        ListNode cross2 = getFirstNodeInCycleHashMap(c1);
        if (cross2 == null) {
            System.out.println("null");
        } else {
            System.out.println(cross2.val);
        }
    }
    
    public static void printList(ListNode head) {  
        while (head != null) {
            System.out.print(head.val + " ");         
            head = head.next;
        }
        
        System.out.println();
    } 
    
    // ���ListNode �ĳ���
    public static int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        int len = 0;        
        while (head != null) {
            len++;
            head = head.next;
        }
        
        return len;
    }
    
    /*
     * ��ת����
     * ���㷨�����ǣ�һ��ֻ��Ҫ�������һ���ڵ�ָ��curr��
     * ����ѭ���������������
     * */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode next = head.next;
        ListNode curr = head;
        
        // �Ȱ�ͷ�ڵ����һ��ָ��.
        curr.next = null;
        
        // ÿ��ֻ��Ҫ��curr��nextָ��curr���ɣ�
        // ��ֹ�����ǣ�next��null ��ʾ���ǽ����еĽڵ�����˷�ת
        while (next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        
        return curr;
    }
    
    // ��ת�ݹ飨�ݹ飩  
    // �ݹ�ľ����������Ĭ��reverseListRec�Ѿ��ɹ����������������ˣ�����ȥ����ν����  
    // ����ֻҪ����ǰnode��������֮��Ĺ�ϵ��������Բ������������⡣  
    /* 
         head 
            1 -> 2 -> 3 -> 4 
         
          head 
            1-------------- 
                                | 
                   4 -> 3 -> 2                    // Node reHead = reverseListRec(head.next); 
               reHead      head.next 
             
                   4 -> 3 -> 2 -> 1               // head.next.next = head; 
               reHead 
                
                    4 -> 3 -> 2 -> 1 -> null      // head.next = null; 
               reHead 
     */  
    public static ListNode reverseListRec(ListNode head) {
        // if there is no node, or only one node, just return;
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode reHead = reverseListRec(head.next); // ����������⡣
        head.next.next = head;  // ��head �뱻������Ӵ���β��������
        head.next = null;       // head����һ������ָ�� null����Ϊhead ���µ�β��.
        
        return reHead;
    }
    
    /** 
     * ���ҵ������еĵ�����K����㣨k > 0�� 
     * ���ձ�ķ����ǣ���ͳ�Ƶ������н��ĸ�����Ȼ�����ҵ��ڣ�n-k������㡣ע������Ϊ�գ�kΪ0��kΪ1��k���������нڵ����ʱ����� 
     * ��ʱ�临�Ӷ�ΪO��n���������ԡ� ������Ҫ��һ����һ��˼·������˼·��������Ŀ��Ҳ����Ӧ�á� 
     * ��Ҫ˼·����ʹ������ָ�룬����ǰ���ָ���ߵ������k����� 
     * ������ǰ������ָ��ľ������k��֮��ǰ������ָ��һ����ǰ�ߣ�ǰ���ָ���ߵ���ʱ������ָ����ָ�����ǵ�����k�����
     * when k = 1, it should be the last node. 
     */  
    public static ListNode reGetKthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }        
        
        ListNode fast = head;
        
        // ʹfast and slow֮��� k
        while (k > 0) {
            if (fast == null) {
                // �������������˵��k > sizeOfList.
                return null;
            }
            fast = fast.next;
            k--;            
        }
        
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }        
        
        return head;
    }
    
    /*
     * �ݹ��ӡ��������k���ڵ㡣
     * */
    static int level = 0;
    public static void reGetKthNodeRec(ListNode head, int k) {
        if (head == null) {
            return;
        }        
        
        reGetKthNodeRec(head.next, k);
        level++;
        if (level == k) {
            System.out.println(head.val);
        }        
    }
    
    /*
     * �ݹ��ӡ��������k���ڵ㡣
     * return: the length of the link.
     * ��Ϊ�Ľ��ĵݹ��㷨��ʹ�ô��㷨������Ҫ���븨��������
     * */
    public static int reGetKthNodeRec2(ListNode head, int k) {
        if (head == null) {
            return 0;
        }        
        
        int len = reGetKthNodeRec2(head.next, k);
        if (len == k - 1) {
            System.out.println(head.val);
        }
        
        return len + 1;
    }

    /** 
     * �ж�һ�����������Ƿ��л� 
     * ����Ҳ���õ�����ָ�롣���һ���������л���Ҳ����˵��һ��ָ��ȥ����������Զ�߲���ͷ�ġ���ˣ����ǿ���������ָ��ȥ������һ��ָ��һ�������� 
     * ��һ��ָ��һ����һ��������л�������ָ��϶����ڻ���������ʱ�临�Ӷ�ΪO��n�� 
     */  
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head; // ��ָ��ÿ��ǰ������  
        ListNode fast = head; // ��ָ��ÿ��ǰ��һ��  
        
        // ���fastû�е���β������ôslowҲ���ᡣ���Բ���Ҫ�ж�slow�ǲ���null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // ���������ڻ�
                return true;
            }
        }
        
        return false;
        
    }
        
    /*
     *  4. ���ҵ�������м���: getMiddleNode
     *     ����ֻ����n����Ϊ ���������
     *  ���ǿ�������2�� ָ�룬һ���죬һ����
     *  1-2-3-null
     *  ��fastǰ��2nʱ��������3����������2n + 1
     *  �м�ڵ�ӦΪ(2n+1)/2 + 1 = n + 1;
     *  ���ԣ�slow�ڵ�ǰ��nǡ�ÿ��Ե����м䡣
     *  
     *  �߽�:
     *  n = 1ʱ��һ��ʼ�Ϳ����˳�����Ȼ��������
     *  ���㷨�ص㣺
     *  1->2->3->4
     *  ����2
     */     
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;            
        }
        
        return slow;
    }
    
    /**
     * 5. ��β��ͷ��ӡ������: reversePrintListStack��reversePrintListRec���ݹ飩
     * @param head
     * @return
     */
    public static void reversePrintListStackRec(ListNode head) {
        if (head == null) {
            return;
        }
        
        // print the next first.
        reversePrintListStackRec(head.next);
        System.out.print(head.val + " ");
    }
    
    /** 
     * ��β��ͷ��ӡ������ 
     * �������ֵߵ�˳������⣬����Ӧ�þͻ��뵽ջ������ȳ������ԣ���һ��Ҫô�Լ�ʹ��ջ��Ҫô��ϵͳʹ��ջ��Ҳ���ǵݹ顣ע������Ϊ�յ���� 
     * ��ʱ�临�Ӷ�ΪO��n��
     * 
     * ����һ���������ǿ��԰�����ת������Ҳ���Դ�ͷ��β��ӡ��
     */  
    public static void reversePrintListStack(ListNode head) {
        if (head == null) {
            return;
        }
        
        System.out.println();
        
        Stack<Integer> s = new Stack<Integer>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        
        // print the next first.
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    
    /** 
     * ��β��ͷ��ӡ������ 
     * �ǿ��԰�����ת������Ҳ���Դ�ͷ��β��ӡ�� Ϊ�˲�Ӱ��ԭ�е����������ٷ�ת����
     */  
    public static void reversePrintListRev(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode rev = reverseList(head);
        
        System.out.println();
        
        // print the next first.
        ListNode curr = rev;
        while (curr != null) {
            System.out.print(rev.val + " ");
            curr = curr.next;
        }
                
        System.out.println();
        
        //printList(rev);
        reverseList(rev);
    }
    
    /*
     * 6. ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����: mergeSortedList, mergeSortedListRec
     * 
     * ��merge sort˼������.
     * */
    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        
        // ��Ϊͷ�ڵ��ǰһ���ڵ�
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            
            curr = curr.next;
        }
        
        // ��û��ȡ�����ֱ�ӽ��ڽ���ϼ��ɡ�
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        
        return dummyNode.next;
    } 
    
    static class Node {
        Node next;
        int val;
        Node (int val) {
            this.val = val;
        }
    } 
    
    public static ListNode mergeLink (ListNode aLink, ListNode bLink) {
        ListNode dummy = new ListNode(0);

        ListNode root = dummy;

        while (aLink != null && bLink != null) {
            if (aLink.val < bLink.val) {
                dummy.next = aLink;
                dummy = aLink;
                aLink = aLink.next;
                
            } else {
                dummy.next = bLink;
                dummy = bLink;
                bLink = bLink.next;
                
            }       
        }

        if (aLink != null) {
            dummy.next = aLink;
        } else {
            dummy.next = bLink;
        }

        return root.next;
    }
    
    /*
     * ����ɵ��㷨��Ӧ�û��һ�����
     * ��ֱ�����ŵ��㷨����̫���ˣ�ֻ���� Ϊʲô�Լ����������ô�����㷨�أ�
     * ��Ȼ�ݹ��ԭ��ÿ���˶���������д��Ư���ĵݹ�����ǿ��鹦���ء�
     * 
     * �������: ��ÿһ�ε�Merge�Ĵ���ʱ��ֻ��Ҫ����mergeһ��Ԫ�أ�Ҳ������ȡ��һ��Ԫ�أ�����һ����merge��������һ����recursion
     * ������
     */
    public static ListNode mergeSortedListRec(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        
        ListNode headMerge = null;
        if (head1.val < head2.val) {
            headMerge = head1;
            head1.next = mergeSortedListRec(head1.next, head2);
        } else {
            headMerge = head2;
            head2.next = mergeSortedListRec(head1, head2.next);
        }
        
        return headMerge;
    } 
    
    
    // http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
    // ����һ����Ѱ�һ�����㣬ʵ���ϣ�2�������������ٽ�ĳ��Ż���㣬��������X�ľ��루XΪ��㵽���Ľ���ľ��룩,
    // ������2�����ཻ�ڻ��ĵ㴦��
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode n1 = head;
                while (true) {
                    if (n1 == slow) { // ע�⣬Ҫѡ�жϣ����ƶ���
                        return n1;    // because ��������п��ܾ��ڿ�ʼ�ĵط���
                    }
                    n1 = n1.next;
                    slow = slow.next;
                }
            }
        }
        
        return null;        
    }
    
    /*
     *  * 8. �ж������������Ƿ��ཻ: isIntersect
     *  http://blog.csdn.net/yunzhongguwu005/article/details/11527675
     *  �������������Ƿ��ཻ�������������:
     *  1,�����������һ���л���һ���޻���һ�����ཻ  
     *  2.�����û�л������ж�������������ڵ��Ƿ���ͬ�������ͬ���ཻ������ͬ���ཻ��
     *  3.������л������ж�һ��������Ľڵ��Ƿ�����һ��������Ľڵ㡣��������ཻ������������ཻ��
     *    
     *  �������£�
     *  1. ���ж�2��������û�л���
     *  2. �����û�л��������ڵ��Ƿ���ͬ
     *  3. ������л�����b���Ļ��ڵ���һȦ���������A���еĽڵ㣬�򷵻�true    
     */
    public static boolean isIntersect(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        
        ListNode head1C = hasCycleRetNode(head1);
        ListNode head2C = hasCycleRetNode(head2);
        
        // �����������л��ġ�
        if (head1C != null && head2C != null) {
            ListNode tmp = head1C;
            do {
                // ����ǰ���жϣ���Ϊ�п��ܵ�ǰ�ڵ����Ҫ��Ľ��
                if (head1C == head2C) {
                    return true;
                }
                
                // ��һȦ�����ǲ���ͬһ��Ȧ��
                head1C = head1C.next;
            } while (tmp != head1C);
            
            return false;
        // ����������û�л���
        } else if (head1C == null && head2C == null){
            while (head1.next != null) {
                head1 = head1.next;
            }
            
            while (head2.next != null) {
                head2 = head2.next;
            }
            
            // �޻��Ļ���Ӧ�þ�����ͬ��β�ڵ�.
            return head1 == head2;
        } else {
            return false;
        }
    }
    
    /**
     * ����л��������ڻ��ڵ�ĳ�ڵ㡣���򷵻�null 
     */
    public static ListNode hasCycleRetNode(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode s = head;
        ListNode f = head;
        
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return f;
            }
        }
        
        return null;
    }
    
    /*
     * * 9. �������������ཻ�ĵ�һ���ڵ�: getFirstCommonNode
     * ��Ϊ2�������
     * 
     * 1. û�л������.
     * �������������ཻ�ĵ�һ���ڵ� �Ե�һ��������������㳤��len1��ͬʱ�������һ���ڵ�ĵ�ַ�� 
     * �Եڶ���������������㳤��len2��ͬʱ������һ���ڵ��Ƿ�͵�һ����������һ���ڵ���ͬ��������ͬ�����ཻ�������� 
     * �����������ͷ�ڵ㿪ʼ������len1����len2 
     * ����ô����һ�������ȱ���len1-len2���ڵ㣬��ʱ��������ǰ�ڵ㵽��һ���ཻ�ڵ�ľ��������ˣ�Ȼ��һ����������ֱ�������ڵ�ĵ�ַ��ͬ�� 
     * ʱ�临�Ӷȣ�O(len1+len2) 
     *  
     *              ----    len2 
     *                   |__________ 
     *                   | 
     *       ---------   len1 
     *       |---|<- len1-len2
     *       
     * 2. �л������
     *   ��1��. �����ڻ���
     *       �����ӵĻ���ʵ�������ǿ������2�����㡣����ֻҪ�ж�2�������ǲ�����ȡ�����ȣ���2�����㷵���κ�һ����
     *       ���Ҳ�Ƿ����κ�һ����
     *   ��2��. ���㲻�ڻ��ϣ����������Ľ��㣬Ȼ��len1 = ��������Ľ��㣬len2 = ��������Ľ��㣬Ȼ���緽��1��ͬ��������
     *       ��δ���ûд��           
     */  
    public static ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        
        ListNode cross1 = detectCycle(head1);
        ListNode cross2 = detectCycle(head2);
        
        // There is no CIRCLE
        if (cross1 == null && cross2 == null) {
            int len1 = getListLength(head1);
            int len2 = getListLength(head2);
            
            //���������ض�
            if (len1 > len2) {
                while (len1 > len2) {
                    head1 = head1.next;
                    len1--;
                }
            } else {
                while (len2 > len1) {
                    head2 = head2.next;
                    len2--;
                }
            }
            
            while (head1 != null && head2 != null) {
                if (head1 == head2) {
                    return head1;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            
            return null;
        } else if (cross1 != null && cross2 != null) {
            // ��һ��û��ôд�� 
            return cross1;
        }
        
        return null;
    }
    
    /** 
     * ����뻷�еĵ�һ���ڵ� ��HashSet�� һ���޻���������ÿ�����ĵ�ַ���ǲ�һ���ġ� 
     * ������л���ָ�����������ƶ��������ָ�����ջ�ָ��һ���Ѿ����ֹ��ĵ�ַ �Ե�ַΪ��ϣ��ļ�ֵ��ÿ����һ����ַ��
       ֻҪ�����ظ���Ԫ�أ����ҵ��˻��Ľ���.
     */ 
    public static ListNode getFirstNodeInCycleHashMap(ListNode head) {
        if (head == null) {
            return null;
        }
        
        HashSet<ListNode> h = new HashSet<ListNode>();
        while (head != null) {
            if (h.contains(head)) {
                return head;
            } else {
                h.add(head);
            }
            head = head.next;
        }
        
        return null;
    }
    
    /*
     * ����ɾ���ڵ㣬������ͨ��˼·�����øýڵ��ǰһ���ڵ�ָ��ýڵ����һ���ڵ㣬���������Ҫ�����ҵ��ýڵ��ǰһ���ڵ㣬
     * ʱ�临�Ӷ�ΪO(n)���������������е�ÿ���ڵ�ṹ����һ���ģ��������ǿ��԰Ѹýڵ����һ���ڵ�����ݸ��Ƶ��ýڵ㣬
     * Ȼ��ɾ����һ���ڵ㼴�ɡ�Ҫע�����һ���ڵ����������ʱ��ֻ���ó����ķ��������������ҵ�ǰһ���ڵ㣬
     * �������ƽ��ʱ�临�ӶȻ���O(1)���ο��������£�
     * */
    public static void Delete(ListNode head, ListNode toBeDeleted) {
        if (head == null) {
            return;
        }
        
        if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else {
            while (head != null) {
                if (head.next == toBeDeleted) {
                    head.next = toBeDeleted.next;
                    return;
                }
                head = head.next;
            }
        }
        
        return;
    }
}