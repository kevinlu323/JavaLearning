package com.linkui.treeproblems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * REFS:  
 * http://blog.csdn.net/fightforyourdream/article/details/16843303 ���Դ��ܽ�֮����Java�㶨�����еĶ�������Ŀ
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888          ���ɸ㶨�����еĶ�������Ŀ 
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html           �㷨��ȫ��3�� ������ 
 *  
 * 1. ��������еĽڵ����: getNodeNumRec���ݹ飩��getNodeNum�������� 
 * 2. ������������: getDepthRec���ݹ飩��getDepth  
 * 3. ǰ�����������������������: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec 
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2) 
 * 4.�ֲ����������������δ������£��������ң�: levelTraversal, levelTraversalRec���ݹ�ⷨ�� 
 * 5. �������������Ϊ�����˫������: convertBST2DLLRec, convertBST2DLL 
 * 6. ���������K��Ľڵ������getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. ���������Ҷ�ӽڵ�ĸ�����getNodeNumLeafRec, getNodeNumLeaf 
 * 8. �ж����ö������Ƿ���ͬ������isSameRec, isSame
 * 9. �ж϶������ǲ���ƽ���������isAVLRec 
 * 10. ��������ľ����ƻ��Ͳ��ƻ�ԭ�����������������
 *     mirrorRec, mirrorCopyRec
 *     mirror, mirrorCopy 
 * 10.1 �ж��������Ƿ��ྵ��isMirrorRec isMirror
 * 11. ��������������ڵ����͹������Ƚڵ㣺
 *      LAC        �����С��������, ʹ��list���洢path.
 *      LCABstRec  �ݹ����BST��.
 *      LCARec     �ݹ��㷨 .
 * 12. ��������нڵ�������룺getMaxDistanceRec 
 * 13. ��ǰ��������к�������������ؽ���������rebuildBinaryTreeRec
 * 14. �ж϶������ǲ�����ȫ��������isCompleteBinaryTree, isCompleteBinaryTreeRec
 * 15. �ҳ���������������Ӵ�(��ȫ������������ڵ㣬����ȫ�����ҵ������ڵ㣩findLongest
 */  

public class TreeDemo {
    /* 
            1  
           / \  
          2   3  
         / \   \  
        4   5   6      
    */  
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        
/*                    
       10  
       / \  
      6   14  
     / \   \  
    4   8   16
   /
  0        
*/ 
        /* 
        1  
       / \  
      2   3  
     / \   \  
    4   5   6      
*/  
//        TreeNode r1 = new TreeNode(10);
//        TreeNode r2 = new TreeNode(6);
//        TreeNode r3 = new TreeNode(14);
//        TreeNode r4 = new TreeNode(4);
//        TreeNode r5 = new TreeNode(8);
//        TreeNode r6 = new TreeNode(16);
        
        TreeNode r7 = new TreeNode(0);
        
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        
        r4.left = r7;

        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(16);
        
        TreeNode t7 = new TreeNode(0);
        
        TreeNode t8 = new TreeNode(0);
        TreeNode t9 = new TreeNode(0);
        TreeNode t10 = new TreeNode(0);
        TreeNode t11 = new TreeNode(0);
        
        
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        
        t4.left = t8;
        //t4.right = t9;
        t5.right = t9;
        
        
        // test distance
//        t5.right = t8;
//        t8.right = t9;
//        t9.right = t10;
//        t10.right = t11;
        
        /* 
        10  
        / \  
       6   14  
      / \   \  
     4   8   16
    /
   0        
 */ 
//        System.out.println(LCABstRec(t1, t2, t4).val);
//        System.out.println(LCABstRec(t1, t2, t6).val);
//        System.out.println(LCABstRec(t1, t4, t6).val);
//        System.out.println(LCABstRec(t1, t4, t7).val);
//        System.out.println(LCABstRec(t1, t3, t6).val);
//        
//        System.out.println(LCA(t1, t2, t4).val);
//        System.out.println(LCA(t1, t2, t6).val);
//        System.out.println(LCA(t1, t4, t6).val);
//        System.out.println(LCA(t1, t4, t7).val);
//        System.out.println(LCA(t1, t3, t6).val);
//        System.out.println(LCA(t1, t6, t6).val);
        
        //System.out.println(getMaxDistanceRec(t1));
        
        //System.out.println(isSame(r1, t1));
        
//        System.out.println(isAVLRec(r1));
//        
//        preorderTraversalRec(r1);
//        //mirrorRec(r1);
//        //TreeNode r1Mirror = mirror(r1);
//        
//        TreeNode r1MirrorCopy = mirrorCopy(r1);
//        System.out.println();
//        //preorderTraversalRec(r1Mirror);
//        preorderTraversalRec(r1MirrorCopy);
//        
//        System.out.println();
//        
//        System.out.println(isMirrorRec(r1, r1MirrorCopy));
//        System.out.println(isMirror(r1, r1MirrorCopy));
        
        
        //System.out.println(getNodeNumKthLevelRec(r1, 5));
        
        //System.out.println(getNodeNumLeaf(r1));
        
//      System.out.println(getNodeNumRec(null));
//      System.out.println(getNodeNum(r1));
        //System.out.println(getDepthRec(null));
//        System.out.println(getDepth(r1));
//        
//        preorderTraversalRec(r1);
//        System.out.println();
//        preorderTraversal(r1);
//        System.out.println();
//        inorderTraversalRec(r1);
//        
//        System.out.println();
//          inorderTraversal(r1);
//        postorderTraversalRec(r1);
//        System.out.println();
//        postorderTraversal(r1);
//        System.out.println();
//        levelTraversal(r1);
//        
//        System.out.println();
//        levelTraversalRec(r1);
        
//        TreeNode ret = convertBST2DLLRec(r1);
//        while (ret != null) {
//            System.out.print(ret.val + " ");
//            ret = ret.right;
//        }
        
//        TreeNode ret2 = convertBST2DLL(r1);
//        while (ret2.right != null) {
//            ret2 = ret2.right;
//        }
//        
//        while (ret2 != null) {
//            System.out.print(ret2.val + " ");
//            ret2 = ret2.left;
//        }
//        
//        TreeNode ret = convertBST2DLL(r1);
//        while (ret != null) {
//            System.out.print(ret.val + " ");
//            ret = ret.right;
//        }
        
//        System.out.println();
//        System.out.println(findLongest(r1));
//        System.out.println();
//        System.out.println(findLongest2(r1));
        
        // test the rebuildBinaryTreeRec.
        //test_rebuildBinaryTreeRec();
        
        System.out.println(isCompleteBinaryTreeRec(t1));
        System.out.println(isCompleteBinaryTree(t1));
    }
    
    public static void test_rebuildBinaryTreeRec() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(5);
        list1.add(3);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(2);
        list2.add(5);
        list2.add(1);
        list2.add(3);
        list2.add(7);
        list2.add(6);
        list2.add(8);
        
        TreeNode root = rebuildBinaryTreeRec(list1, list2);
        preorderTraversalRec(root);
        System.out.println();
        postorderTraversalRec(root);
    }
    
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;                    
        }
    }
    
    /*
     * null����0��Ȼ�������������size���ϼ��ɡ�
     * */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
                
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /** 
     *  ��������еĽڵ���������ⷨO(n)������˼��ͬLevelOrderTraversal�� 
     *  ����һ��Queue����Java���������LinkedList��ģ��  
     */  
    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
        q.offer(root);
        
        int cnt = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            
            if (node.right != null) {
                q.offer(node.right);
            }
            
            cnt++;
        }
        
        return cnt;
    }
    
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }
    
    /*
     * ������ level LevelOrderTraversal ��ʵ�֣�������һ��dummyNode���ָ���ͬ�Ĳ㣬�������ɼ����ʵ�ʵ�depth.
     *      1  
           / \  
          2   3  
         / \   \  
        4   5   6
     * 
     * �ڶ�����������У� 1, dummy, 2, 3, dummy, 4, 5, 5, dummy  
     * 
    */  
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        TreeNode dummy = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(dummy);
        
        int depth = -1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == dummy) {
                depth++;
                if (!q.isEmpty()) {  // ʹ��DummyNode�����ֲ�ͬ�Ĳ㣬 �����һ�㲻��Ϊ�գ���Ӧ����β����DummyNode.
                    q.offer(dummy);
                }
            }
            
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        
        return depth;
    }
    
    /*
     * 3. ǰ�����������������������: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec 
     * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
     * */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }
    
    /*
     * ǰ�������Iteration �㷨. �Ѹ��ڵ����stack�С�
     * */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.print(node.val + " ");
            if (node.right != null) { //
                s.push(node.right);
            }
            
            // ������Ҫ��ѹ���ҽڵ㣬��ѹ����ڵ㣬�����Ϳ����ȵ�����ڵ㡣 
            if (node.left != null) {
                s.push(node.left);
            }                       
        }
    }
    
    /*
     * �������
     * */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }
    
    /** 
     * ������������ⷨ ����ջ�ȰѸ��ڵ���������Ӷ���ӵ�ջ�ڣ� 
     * Ȼ�����ջ��Ԫ�أ��ٴ���ջ��Ԫ�ص������� 
     * http://www.youtube.com/watch?v=50v1sJkjxoc 
     *  
     * ����һ�ַ����ܲ��õݹ��ջ�����������������ķ��������鷳�Ժ��� 
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/ 
     */  
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while(true) {
            // �ѵ�ǰ�ڵ����ڵ㶼push��ջ��.
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (s.isEmpty()) {
                break;
            }
            
            // ��Ϊ��ʱ�Ѿ�û�������ˣ��������ջ��Ԫ�� 
            cur = s.pop();
            System.out.print(cur.val + " ");
            
            // ׼������������  
            cur = cur.right;            
        }
    }
    
    // �������
    /*
     *      1  
           / \  
          2   3  
         / \   \  
        4   5   6
        
        if put into the stack directly, then it should be:
        1, 2, 4, 5, 3, 6 in the stack.
        when pop, it should be: 6, 3, 5, 4, 2, 1
        
        if I 
     * */
    
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }
    
    /** 
     *  ������������ⷨ 
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU 
     *  http://blog.csdn.net/tang_jin2015/article/details/8545457
     *  �����ҵĺ��� ����ҵ����ǰ���������һ���ģ����Ծͼ�ඣ� ����
     *  ������һ��ջ���з�ת����� 
     */ 
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            out.push(cur);
            
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }
        
        while(!out.isEmpty()) {
            System.out.print(out.pop().val + " ");
        }
    }
    
    /*
     * �ֲ����������������δ������£��������ң����� 
     * ��ʵ���ǹ������������ʹ�ö���ʵ�֡����г�ʼ���������ڵ�ѹ����С������в�Ϊ�գ��������²���������һ���ڵ� 
     * �����ʣ������ӽڵ�����ӽڵ㲻Ϊ�գ�����ѹ����� 
     * */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
    
    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        levelTraversalVisit(root, 0, ret);
        System.out.println(ret);
    }
    
    /** 
     *  �ֲ�������������ݹ飩 
     *  �������˻��õݹ�ȥ��level traversal 
     *  ����˼������һ�����ArrayList�����������ÿһ���ArrayList�� 
     *  ���ArrayList��size��level�й�ϵ 
     *   
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543 
     */  
    public static void levelTraversalVisit(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) {
            return;
        }
        
        // ���ArrayList�Ĳ��������ã� �������һ��
        // when size = 3, level: 0, 1, 2
        if (level >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        
        // visit ��ǰ�ڵ�
        ret.get(level).add(root.val);
        
        // ���������� ��������ӵ���Ӧ�Ĳ㡣
        levelTraversalVisit(root.left, level + 1, ret);
        levelTraversalVisit(root.right, level + 1, ret);
    }
    
    /*
     * ��ĿҪ�󣺽����������ת���������˫���������ܴ����½ڵ㣬ֻ����ָ�롣
       �������Ľ�㶨�����£�
       ��Ȼ�������䶨�屾����ǵݹ�ģ���Ȼ�õݹ��㷨����ͺ����ס�����������������������ת��Ϊ�����˫������
       Ȼ����ڵ��leftָ��ָ����������������һ����㣬ͬʱ���������һ������rightָ��ָ����ڵ㣻
       ���ڵ��rightָ��ָ������������ĵ�һ����㣬
       ͬʱ��������һ������leftָ��ָ����ڵ㡣
     * */
    public static TreeNode convertBST2DLLRec(TreeNode root) {
        return convertBST2DLLRecHelp(root)[0];
    }
    
    /*
     * ret[0] ������ָ��
     * ret[1] ������ָ��
     * */
    public static TreeNode[] convertBST2DLLRecHelp(TreeNode root) {
        TreeNode[] ret = new TreeNode[2];
        ret[0] = null;
        ret[1] = null;
                
        if (root == null) {
            return ret;
        }
        
        if (root.left != null) {
            TreeNode left[] = convertBST2DLLRecHelp(root.left);
            left[1].right = root;  // ����������β�ڵ����ӵ���
            root.left = left[1];
            
            ret[0] = left[0];
        } else {
            ret[0] = root;   // ��ڵ㷵��root.
        }
        
        if (root.right != null) {
            TreeNode right[] = convertBST2DLLRecHelp(root.right);
            right[0].left = root;  // ����������ͷ�ڵ����ӵ���
            root.right = right[0];
            
            ret[1] = right[1];
        } else {
            ret[1] = root;  // �ҽڵ㷵��root.
        }
        
        return ret;
    }
    
    /** 
     * �������������Ϊ�����˫������ �����ⷨ 
     * ����inOrder traversal������ 
     */  
    public static TreeNode convertBST2DLL(TreeNode root) {
        while (root == null) {
            return null;
        }
        
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode head = null;       // ����ͷ
        
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            // if stack is empty, just break;
            if (s.isEmpty()) {
                break;
            }
            
            cur = s.pop(); 
            if (head == null) {
                head = cur;
            }

            // link pre and cur.
            cur.left = pre;
            if (pre != null) {
                pre.right = cur;
            }
            
            // ��ڵ��Ѿ��������ˣ������ҽڵ�
            cur = cur.right;
            pre = cur;
        }
        
        return root;
    }

/*
 *  * 6. ���������K��Ľڵ������getNodeNumKthLevelRec, getNodeNumKthLevel 
 * */
    public static int getNodeNumKthLevel(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        
        int level = 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        TreeNode dummy = new TreeNode(0);
        int cnt = 0; // record the size of the level.
        
        q.offer(dummy);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if (node == dummy) {
                level++;
                if (level == k) {
                    return cnt;
                }
                cnt = 0; // reset the cnt;
                if (q.isEmpty()) {
                    break;
                }
                q.offer(dummy);
                continue;
            }
            
            cnt++;
            if (node.left != null) {
                q.offer(node.left);
            }
            
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        
        return 0;
    }
    
    /*
     *  * 6. ���������K��Ľڵ������getNodeNumKthLevelRec, getNodeNumKthLevel 
     * */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        
        if (k == 1) {
            return 1;
        }
        
        // ������������������K��Ľڵ�������.
        return getNodeNumKthLevelRec(root.left, k - 1) + getNodeNumKthLevelRec(root.right, k - 1);
    }
    
    /*
     * 7. getNodeNumLeafRec  ������������������Ҷ�ӽڵ����һ�𼴿�
     * */
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }
    
    /* 7. getNodeNumLeaf
     * ���ʹ��һ�ֱ������������ԣ����磬���������
     * inorderTraversal���ж��ǲ���Ҷ�ӽڵ㡣
     * */
    public static int getNodeNumLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int cnt = 0;
        
        // we can use inorderTraversal travesal to do it.
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (s.isEmpty()) {
                break;
            }
            
            // all the left child has been put into the stack, let's deal with the 
            // current node.
            cur = s.pop();
            if (cur.left == null && cur.right == null) {
                cnt++;
            }
            cur = cur.right;
        }
        
        return cnt;
    }
    
    /*
     * 8. �ж����ö������Ƿ���ͬ������ 
     * �ݹ�ⷨ��  
     * ��1��������ö�������Ϊ�գ������� 
     * ��2��������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ�  
     * ��3��������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ� 
     * */
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {
        // both are null.
        if (r1 == null && r2 == null) {
            return true;
        }
        
        // one is null.
        if (r1 == null || r2 == null) {
            return false;
        }
        
        // 1. the value of the root should be the same;
        // 2. the left tree should be the same.
        // 3. the right tree should be the same.
        return r1.val == r2.val && 
                isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right);
    }
    
    /*
     * 8. �ж����ö������Ƿ���ͬ������
     * �����ⷨ 
     * ����ֱ��������������ȽϾͺ��� 
     * */
    public static boolean isSame(TreeNode r1, TreeNode r2) {
        // both are null.
        if (r1 == null && r2 == null) {
            return true;
        }
        
        // one is null.
        if (r1 == null || r2 == null) {
            return false;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        TreeNode cur1 = r1;
        TreeNode cur2 = r2;
        
        while (true) {
            while (cur1 != null && cur2 != null) {
                s1.push(cur1);
                s2.push(cur2);
                cur1 = cur1.left;
                cur2 = cur2.left;
            }
            
            if (cur1 != null || cur2 != null) {
                return false;
            }
            
            if (s1.isEmpty() && s2.isEmpty()) {
                break;
            }
            
            cur1 = s1.pop();
            cur2 = s2.pop();
            if (cur1.val != cur2.val) {
                return false;
            }
            
            cur1 = cur1.right;
            cur2 = cur2.right;
        }
        
        return true;
    }
    
/*
 * 
 *  9. �ж϶������ǲ���ƽ���������isAVLRec
 *     1. ���������������ĸ߶Ȳ�ܳ���1
 *     2. ������������������ƽ��������� 
 *      
 */
    public static boolean isAVLRec(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // ����������������������ƽ��������� 
        if (!isAVLRec(root.left) || !isAVLRec(root.right)) {
            return false;
        }
        
        int dif = Math.abs(getDepthRec(root.left) - getDepthRec(root.right));
        if (dif > 1) {
            return false;
        }
        
        return true;
    }
    
    /** 
     * 10. ��������ľ��� �ݹ�ⷨ��
     * 
     *   (1) �ƻ�ԭ������
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     * */  
    public static TreeNode mirrorRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        // �Ȱ����������ֱ���,���ҽ�������
        TreeNode tmp = root.right;
        root.right = mirrorRec(root.left);
        root.left = mirrorRec(tmp);
        
        return root;
    }  
    
    /** 
     * 10. ��������ľ��� Iterator�ⷨ��
     * 
     *   (1) �ƻ�ԭ������
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     *      
     *  Ӧ�ÿ���ʹ���κ�һ��Traversal ������ 
     *  �������ڿ����Կ���ʹ����򵥵�ǰ�������
     * */  
    public static TreeNode mirror(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            
            // ������ǰ�ڵ�����ҽڵ�
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            
            // traversal ��ڵ㣬�ҽڵ㡣
            if (cur.right != null) {
                s.push(cur.right);
            }
            
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        
        return root;
    }  
    
    /** 
     * 10. ��������ľ��� Iterator�ⷨ��
     * 
     *   (2) ����һ���µ���
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     *      
     *  Ӧ�ÿ���ʹ���κ�һ��Traversal ������ 
     *  �������ڿ����Կ���ʹ����򵥵�ǰ�������
     *  ǰ��������ǿ������̰��½��õ����ҽڵ㴴���������ȽϷ��� 
     * */  
    public static TreeNode mirrorCopy(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> sCopy = new Stack<TreeNode>();
        s.push(root);
        
        TreeNode rootCopy = new TreeNode(root.val);
        sCopy.push(rootCopy);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            TreeNode curCopy = sCopy.pop();
            
            // traversal ��ڵ㣬�ҽڵ㡣
            if (cur.right != null) {
                
                // copy ���������ȽϺã���Ϊ���ǿ������׵��ҵ����ĸ��ڵ�
                TreeNode leftCopy = new TreeNode(cur.right.val);
                curCopy.left = leftCopy;
                s.push(cur.right);
                sCopy.push(curCopy.left);
            }
            
            if (cur.left != null) {
                // copy ���������ȽϺã���Ϊ���ǿ������׵��ҵ����ĸ��ڵ�
                TreeNode rightCopy = new TreeNode(cur.left.val);
                curCopy.right = rightCopy;
                s.push(cur.left);
                sCopy.push(curCopy.right);
            }
        }
        
        return rootCopy;
    }  
    
    /** 
     * 10. ��������ľ��� �ݹ�ⷨ��
     * 
     *   (1) ���ƻ�ԭ���������½�һ���� 
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     * */  
    public static TreeNode mirrorCopyRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        // �Ȱ����������ֱ���,���Ұ��������ӵ��½���root�ڵ㡣
        TreeNode rootCopy = new TreeNode(root.val);
        rootCopy.left = mirrorCopyRec(root.right);
        rootCopy.right = mirrorCopyRec(root.left);
        
        return rootCopy;
    }  
    
    /*
     * 10.1. �ж��������Ƿ��ྵ��
     *  (1) ������ͬʱΪ�գ�����ͬʱ��Ϊ��
     * 
     * �������Ϊ��:
     *  (1).����ֵһ��
     *  (2).r1��������r2�������ľ���
     *  (3).r1��������r2�������ľ���  
     * */
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){  
        // ���2�������ǿ���
        if (r1 == null && r2 == null) {
            return true;
        }
        
        // �������һ��Ϊ�գ��򷵻�false.
        if (r1 == null || r2 == null) {
            return false;
        }
        
        // If both are not null, they should be:
        // 1. have same value for root.
        // 2. R1's left tree is the mirror of R2's right tree;
        // 3. R2's right tree is the mirror of R1's left tree;
        return r1.val == r2.val 
                && isMirrorRec(r1.left, r2.right)
                && isMirrorRec(r1.right, r2.left);
    }
    
    /*
     * 10.1. �ж��������Ƿ��ྵ�� Iterator ����
     *  (1) ������ͬʱΪ�գ�����ͬʱ��Ϊ��
     * 
     * �������Ϊ��:
     * traversal ���������ж������ǲ��Ǿ���ÿ�ζ����շ�����traversal  
     * (1). ��ǰ�ڵ��ֵ���
     * (2). ��ǰ�ڵ�����ҽڵ�Ҫ����
     *    ��������ڵ㣬�����ҽڵ㣬��Ӧ����һ�����ľ���λ�ã�����ͬʱΪ�գ�����ͬʱ��Ϊ�գ����ǲ�����һ��Ϊ�գ�һ����Ϊ�ա�      
     * */
    public static boolean isMirror(TreeNode r1, TreeNode r2){  
        // ���2�������ǿ���
        if (r1 == null && r2 == null) {
            return true;
        }
        
        // �������һ��Ϊ�գ��򷵻�false.
        if (r1 == null || r2 == null) {
            return false;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        s1.push(r1);
        s2.push(r2);
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode cur1 = s1.pop();
            TreeNode cur2 = s2.pop();
            
            // �����Ľڵ��ֵ������� 
            if (cur1.val != cur2.val) {
                return false;
            }
            
            // tree1����ڵ㣬tree2���ҽڵ㣬����ͬʱ��Ϊ�գ�Ҳ����ͬʱΪ�գ����򷵻�false.
            TreeNode left1 = cur1.left;
            TreeNode right1 = cur1.right;
            TreeNode left2 = cur2.left;
            TreeNode right2 = cur2.right;
            
            if (left1 != null && right2 != null) {
                s1.push(left1);
                s2.push(right2);
            } else if (!(left1 == null && right2 == null)) {
                return false;
            }
            
            // tree1����ڵ㣬tree2���ҽڵ㣬����ͬʱ��Ϊ�գ�Ҳ����ͬʱΪ�գ����򷵻�false.
            if (right1 != null && left2 != null) {
                s1.push(right1);
                s2.push(left2);
            } else if (!(right1 == null && left2 == null)) {
                return false;
            }
        }
        
        return true;
    }  
    
    /*
     * 11. ��������������ڵ����͹������Ƚڵ㣺
     * Recursion Version:
     * LACRec 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LACRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        // if no node is in the node, just recursively find it in LEFT and RIGHT tree.
        TreeNode left = LACRec(root.left, node1, node2);
        TreeNode right = LACRec(root.right, node1, node2);
        
        if (left == null) {  // If didn't found in the left tree, then just return it from right.
            return right;
        } else if (right == null) { // Or if didn't found in the right tree, then just return it from the left side.
            return left;
        } 
        
        // if both right and right found a node, just return the root as the Common Ancestor.
        return root;
    }
    
    /*
     * 11. ��BST�������ڵ����͹������Ƚڵ㣺
     * Recursive version:
     * LCABst 
     * 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LCABstRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        int min = Math.min(node1.val, node2.val);
        int max = Math.max(node1.val, node2.val);
        
        // if the values are smaller than the root value, just search them in the left tree.
        if (root.val > max) {
            return LCABstRec(root.left, node1, node2);
        } else if (root.val < min) {
        // if the values are larger than the root value, just search them in the right tree.    
            return LCABstRec(root.right, node1, node2);
        }
        
        // if root is in the middle, just return the root.
        return root;
    }
    
    /*
     * �ⷨ1. ��¼��path,���ұȽ�֮:
     * LAC
     * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
     * */
    public static TreeNode LCA(TreeNode root, TreeNode r1, TreeNode r2) {
        // If the nodes have one in the root, just return the root.
        if (root == null || r1 == null || r2 == null) {
            return null;
        }
        
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        
        boolean find1 = LCAPath(root, r1, list1);
        boolean find2 = LCAPath(root, r2, list2);
        
        // If didn't find any of the node, just return a null.
        if (!find1 || !find2) {
            return null;
        }
        
        // ע��: ʹ��Iterator ����linkedlist����������ܡ�
        // ���� ͳһʹ��Iterator �����в�����
        Iterator<TreeNode> iter1 = list1.iterator();
        Iterator<TreeNode> iter2 = list2.iterator();
        
        TreeNode last = null;
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();
            
            if (tmp1 != tmp2) {
                return last;
            }
            
            last = tmp1;
        }
        
        // If never find any node which is different, means Node 1 and Node 2 are the same one.
        // so just return the last one.
        return last;
    }
    
    public static boolean LCAPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        // if didn't find, we should return a empty path.
        if (root == null || node == null) {
            return false;
        }
        
        // First add the root node.
        path.add(root);
        
        // if the node is in the left side.
        if (root != node 
                && !LCAPath(root.left, node, path)
                && !LCAPath(root.right, node, path)
                ) {
            // Didn't find the node. should remove the node added before.
            path.remove(root);
            return false;
        }
        
        // found
        return true;
    }
    
    /*
     *  * 12. ��������нڵ�������룺getMaxDistanceRec
     *  
     *  ��������������������룺
     *  ���붨��Ϊ�������ڵ��ߵ���Ŀ.
     *  �磺
     *     1
     *    / \
     *   2   3
     *        \
     *         4
     *   ���������붨��Ϊ2��4�ľ��룬Ϊ3.      
     * ��������нڵ�������� ���������������Զ�������ڵ�֮��ľ��롣 (distance / diameter) 
     * �ݹ�ⷨ��
     * ����ֵ��ƣ�
     * ����1. ��ȣ� 2. ��ǰ���������  
     * (1) ��������������ȣ���������ȣ��������������������ȣ���������������������
     * (2) ��󳤶�Ϊ����֮�
     *    a. ͨ�����ڵ������Ϊ�������+2
     *    b. ������������
     *    c. ��������������
     * 
     * (3)�ݹ��ʼ������
     *   ��root == null, depth = -1.maxDistance = -1;
     *   
     */  
    public static int getMaxDistanceRec(TreeNode root) {
        return getMaxDistanceRecHelp(root).maxDistance;
    }
    
    public static Result getMaxDistanceRecHelp(TreeNode root) {
        Result ret = new Result(-1, -1);
        
        if (root == null) {
            return ret;
        }
        
        Result left = getMaxDistanceRecHelp(root.left);
        Result right = getMaxDistanceRecHelp(root.right);
        
        // ���Ӧ��1�� the depth from the subtree to the root.
        ret.depth = Math.max(left.depth, right.depth) + 1;
        
        // ������������������ľ��붼Ҫ��1������ͨ�����ڵ��·��Ϊ�������+2
        int crossLen = left.depth + right.depth + 2;
        
        // ���cross����·���������������Ķ���·����������·�������ֵ��
        ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
        ret.maxDistance = Math.max(ret.maxDistance, crossLen);
        
        return ret;
    }

    
    private static class Result {
        int depth;
        int maxDistance;
        public Result(int depth, int maxDistance) {
            this.depth = depth;
            this.maxDistance = maxDistance;
        }
    }
    
    /*
     *  13. ��ǰ��������к�������������ؽ���������rebuildBinaryTreeRec 
     *  We assume that there is no duplicate in the trees.
     *  For example:
     *          1
     *         / \
     *        2   3
     *       /\    \
     *      4  5    6
     *              /\
     *             7  8  
     *             
     *  PreOrder should be: 1   2 4 5   3 6 7 8
     *                      ��   ������    ������  
     *  InOrder should be:  4 2 5   1   3 7 6 8
     *                       ������  ��  ������
     * */                   
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        
        // If the traversal is empty, just return a NULL.
        if (preOrder.size() == 0 || inOrder.size() == 0) {
            return null;
        }
        
        // we can get the root from the preOrder. 
        // Because the first one is the root.
        // So we just create the root node here.
        TreeNode root = new TreeNode(preOrder.get(0));
        
        List<Integer> preOrderLeft;
        List<Integer> preOrderRight;
        List<Integer> inOrderLeft;
        List<Integer> inOrderRight;
        
        // ����� inOrder�У�����λ��
        int rootInIndex = inOrder.indexOf(preOrder.get(0));
        preOrderLeft = preOrder.subList(1, rootInIndex + 1);
        preOrderRight = preOrder.subList(rootInIndex + 1, preOrder.size());
        
        // �õ�inOrder��ߵ�������
        inOrderLeft = inOrder.subList(0, rootInIndex);
        inOrderRight = inOrder.subList(rootInIndex + 1, inOrder.size());

        // ͨ�� Rec ��������������������
        root.left = rebuildBinaryTreeRec(preOrderLeft, inOrderLeft);
        root.right = rebuildBinaryTreeRec(preOrderRight, inOrderRight);
        
        return root;        
    }
    
    /*
     * 14. �ж϶������ǲ�����ȫ��������isCompleteBinaryTree, isCompleteBinaryTreeRec
     * ����level traversal, һ������һ���ڵ����ڵ�Ϊ�գ�����Ľڵ���ӽڵ㶼����Ϊ�ա����Ҳ�Ӧ������һ�У���ʵ���Ƕ��������е�
     * Ԫ�ض���Ӧ��������Ԫ�ء�
     * */
    
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        TreeNode dummyNode = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        q.offer(dummyNode);
        
        // if this is true, no node should have any child.
        boolean noChild = false;
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == dummyNode) {
                if (!q.isEmpty()) {
                    q.offer(dummyNode);
                }
                // Dummy node����Ҫ���� 
                continue;
            }
            
            if (cur.left != null) {
                // �����Ǳ����ã���Queue���κ�Ԫ�ز�Ӧ������Ԫ�ء�
                if (noChild) {
                    return false;
                }
                q.offer(cur.left);
            } else {
                // һ��ĳԪ��û����ڵ�����ҽڵ㣬��֮�����е�Ԫ�ض���Ӧ����Ԫ�ء�
                // ���Ҹ�Ԫ�ز��������ҽڵ�.
                noChild = true;
            }
            
            if (cur.right != null) {
                // �����Ǳ����ã���Queue���κ�Ԫ�ز�Ӧ������Ԫ�ء�
                if (noChild) {
                    return false;
                }
                q.offer(cur.right);
            } else {
                // һ��ĳԪ��û����ڵ�����ҽڵ㣬��֮�����е�Ԫ�ض���Ӧ����Ԫ�ء�
                noChild = true;
            }
        }
        
        return true;
    }
    
    /*
     * 14. �ж϶������ǲ�����ȫ��������isCompleteBinaryTreeRec
     * 
     * 
     *    ���ǿ��Էֽ�Ϊ��
     *    CompleteBinary Tree �������ǣ�
     *    1. ����������ΪPerfect binary tree, ��������Height��ͬ
     *    2. ������ΪCompleteBinaryTree, ������ΪPerfect binary tree����������Height��1
     *    3. ������ΪPerfect Binary Tree,������ΪCompleteBinaryTree, ����Height ��ͬ
     *    
     *    Base ������
     *    (1) root = null: Ϊperfect & complete BinaryTree, Height -1;
     *    
     *    �� Perfect Binary Tree��������
     *    ����������ΪPerfect Binary Tree,����Height ��ͬ��
     * */
    
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeRecHelp(root).isCompleteBT;
    }
    
    private static class ReturnBinaryTree {
        boolean isCompleteBT;
        boolean isPerfectBT;
        int height;
        
        ReturnBinaryTree(boolean isCompleteBT, boolean isPerfectBT, int height) {
            this.isCompleteBT = isCompleteBT;
            this.isPerfectBT = isPerfectBT;
            this.height = height;
        }
    }
    
    /*
     * ���ǿ��Էֽ�Ϊ��
     *    CompleteBinary Tree �������ǣ�
     *    1. ����������ΪPerfect binary tree, ��������Height��ͬ
     *    2. ������ΪCompleteBinaryTree, ������ΪPerfect binary tree����������Height��1
     *    3. ������ΪPerfect Binary Tree,������ΪCompleteBinaryTree, ����Height ��ͬ
     *    
     *    Base ������
     *    (1) root = null: Ϊperfect & complete BinaryTree, Height -1;
     *    
     *    �� Perfect Binary Tree��������
     *    ����������ΪPerfect Binary Tree,����Height ��ͬ��
     * */
    public static ReturnBinaryTree isCompleteBinaryTreeRecHelp(TreeNode root) {
        ReturnBinaryTree ret = new ReturnBinaryTree(true, true, -1);
        
        if (root == null) {
            return ret;
        }
        
        ReturnBinaryTree left = isCompleteBinaryTreeRecHelp(root.left);
        ReturnBinaryTree right = isCompleteBinaryTreeRecHelp(root.right);
        
        // ���ĸ߶�Ϊ�����߶ȣ������߶ȵ����ֵ+1
        ret.height = 1 + Math.max(left.height, right.height);
        
        // set the isPerfectBT
        ret.isPerfectBT = false;
        if (left.isPerfectBT && right.isPerfectBT && left.height == right.height) {
            ret.isPerfectBT = true;
        }
        
        // set the isCompleteBT.
        /*
         * CompleteBinary Tree �������ǣ�
         *    1. ����������ΪPerfect binary tree, ��������Height��ͬ(��ʵ���Ǳ�����perfect tree)
         *    2. ������ΪCompleteBinaryTree, ������ΪPerfect binary tree����������Height��1
         *    3. ������ΪPerfect Binary Tree,������ΪCompleteBinaryTree, ����Height ��ͬ
         * */
        ret.isCompleteBT = ret.isPerfectBT 
                || (left.isCompleteBT && right.isPerfectBT && left.height == right.height + 1)
                || (left.isPerfectBT && right.isCompleteBT && left.height == right.height);
        
        return ret;
    }

    /*
     * 15. findLongest
     * ��һ�ֽⷨ��
     * �����������ұ������������������������
     * */
    public static int findLongest(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        TreeNode l = root;
        int cntL = 0;
        while (l.left != null) {
            cntL++;
            l = l.left;
        }
        
        TreeNode r = root;
        int cntR = 0;
        while (r.right != null) {
            cntR++;
            r = r.right;
        }
        
        int lmax = findLongest(root.left);
        int rmax = findLongest(root.right);
        
        int max = Math.max(lmax, rmax);
        max = Math.max(max, cntR);
        max = Math.max(max, cntL);
        
        return max;
    }
    
    /*      1
     *    2   3
     *  3       4
     *         6  1
     *        7
     *       9
     *     11
     *    2
     *  14      
     * */
    public static int findLongest2(TreeNode root) {
        int [] maxVal = new int[1];
        maxVal[0] = -1;
        findLongest2Help(root, maxVal);
        return maxVal[0];
    }
    
    // ret:
    // 0: the left side longest,
    // 1: the right side longest.
    static int maxLen = -1;
    static int[] findLongest2Help(TreeNode root, int[] maxVal) {
        int[] ret = new int[2];
        if (root == null) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        
        ret[0] = findLongest2Help(root.left, maxVal)[0] + 1;
        ret[1] = findLongest2Help(root.right, maxVal)[1] + 1;
        //maxLen = Math.max(maxLen, ret[0]);
        //maxLen = Math.max(maxLen, ret[1]);
        maxVal[0] = Math.max(maxVal[0], ret[0]);
        maxVal[0] = Math.max(maxVal[0], ret[1]);

        return ret;
    }
} 