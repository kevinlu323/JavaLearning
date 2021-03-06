package com.linkui.treeproblems;

import java.util.*;

public class MyTree {
	public static void main(String[] args){
		/* Basic Binary Tree
		        1  
		       / \  
		      2   3  
		     / \   \  
		    4   5   6      
		   /
		  7
		         		*/  
		TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r4.left = r7;
        System.out.println("Tree has " + getNodeNumRec(r1) + " Nodes");
        System.out.println("Tree depth is " + getDepth(r1));
        System.out.println("Pre order Traversal: ");
        preorderTraversal(r1);
        System.out.println();
        System.out.println("In order Traversal: ");
        inorderTraversal(r1);
        System.out.println();
        System.out.println("Post order Traversal: ");
        postorderTraversal(r1);
        System.out.println();
        System.out.println("Level order Traversal: ");
        levelTraversal(r1);
        System.out.println();
        System.out.println("All paths in tree r1:");
        printPathRec(r1);
        System.out.println();
        System.out.println("r1 has path sum of 8? " + hasPathSum(r1,8));
        System.out.println("The 3rd level has: " + getNodeNumNth(r1, 3) + " nodes");
        System.out.println("The tree has: " + getLeafCount(r1) + " leaf nodes");
        System.out.println("r1 is balanced? "+ isBalanced(r1));
        TreeNode mirror = getCopyMirror(r1);
        System.out.println("Level order Traversal of bstr1 after mirroring: ");
        levelTraversal(mirror);
        System.out.println();
        System.out.println("r1 and r1mirror are mirror? " + isMirror(r1,mirror));
        System.out.println("The max distance in r1 is: " + findMaxDistance(r1));
        /* Binary Search Tree (BST)                 
		        10  
		        / \  
		       6   14  
		      / \   \  
		     4   8   16
		    /
		   0        
		 */ 

         TreeNode bstr1 = new TreeNode(10);
         TreeNode bstr2 = new TreeNode(6);
         TreeNode bstr3 = new TreeNode(14);
         TreeNode bstr4 = new TreeNode(4);
         TreeNode bstr5 = new TreeNode(8);
         TreeNode bstr6 = new TreeNode(16);
         TreeNode bstr7 = new TreeNode(0);
         bstr1.left = bstr2;
         bstr1.right = bstr3;
         bstr2.left = bstr4;
         bstr2.right = bstr5;
         bstr3.right = bstr6;
         bstr4.left = bstr7;
         
         System.out.println("Level order Traversal of bstr1: ");
         levelTraversal(bstr1);
         System.out.println();
         TreeNode mirror2 = getCopyMirror(bstr1);
         System.out.println("Level order Traversal of bstr1 after mirroring: ");
         levelTraversal(mirror2);
         System.out.println();
         System.out.println("bstr1 is balanced? "+ isBalanced(bstr1));
         System.out.println("r1 and bst are mirror? " + isMirror(r1,bstr1));
         System.out.println("bst and bstMirrot are mirror? " + isMirror(bstr1,mirror2));
         System.out.println("the LCA of bstr4 & bst5 is " + findLCA(bstr1, bstr4, bstr5).val);
         TreeNode newHead = convertBST2DLL(bstr1);
         System.out.println("After converting the BST to DLL: ");
         while (newHead != null){
        	 System.out.print(newHead.val + " ");
        	 newHead = newHead.right;
         }
         System.out.println();
         System.out.println("r1 and r1 is the same? " + isSame(r1,r1));
         System.out.println("r1 and bst is the same? " + isSame(r1,bstr1));
         
	}
	
	/**
	 * get Node count, using recursive method.
	 * @param root
	 * @return
	 */
	public static int getNodeNumRec (TreeNode root){
		if (root == null) return 0;
		int nodeNum = 0;
		nodeNum = getNodeNumRec(root.left) + getNodeNumRec(root.right) +1;
		return nodeNum;
	}
	
	/**
	 * Recursively get depth of the tree;
	 * @param root
	 * @return
	 */
	public static int getDepth(TreeNode root){
		if (root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) +1 ;
	}
	
	/**
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path 
	 * from the root node down to the nearest leaf node.
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else if (root.right == null) return minDepth(root.left) + 1; //need to add 1 for root;
        else if (root.left == null) return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	/**
	 * Print out all root to leaf paths.
	 * @param root
	 */
	public static void printPathRec(TreeNode root){
		List<String> list = new ArrayList<>();
		if (root == null) return;
		String path = "";
		printPathHelper(root, path, list);
		for (int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}
	
	/**
	 * sub method for print paths
	 * @param root
	 * @param path
	 * @param list
	 */
	public static void printPathHelper(TreeNode root, String path, List<String> list){
		if(root.left == null && root.right == null){
			list.add(path + root.val);
		}
		if(root.left != null){
			printPathHelper(root.left, path + root.val + "->", list);
		}
		if (root.right != null){
			printPathHelper(root.right, path + root.val + "->", list);
		}
	}
	
	/**
	 * Check if tree has path sum
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false; //return false when tree root is null.
		List<Integer> sumList = new ArrayList<>();
		hasPathSumHelper(root, 0, sumList);
		System.out.println("Tree has path sum: ");
		for (int i = 0; i < sumList.size(); i++){
			System.out.print(sumList.get(i)+" ");
		}
		System.out.println();
		if (sumList.contains(sum)) return true;
		else return false;
	}
	
	/**
	 * Sub-method for hasPathSum
	 * @param root
	 * @param count
	 * @param sumList
	 */
	public static void hasPathSumHelper(TreeNode root, int count, List<Integer> sumList){
		if(root.left == null && root.right == null){
			sumList.add(count + root.val);
		}
		if(root.left != null) hasPathSumHelper(root.left, count + root.val, sumList);
		if(root.right != null) hasPathSumHelper(root.right, count + root.val, sumList);
	}
	
	/**
	 * Reference recursive solution for hasPathSum
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	/**
	 * Pre-order traversal using recursive method.
	 * @param root
	 */
	public static void preorderTraversal(TreeNode root){
		if (root == null) return;
		System.out.print(root.val + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	/**
	 * In-order traversal using recursive method
	 * @param root
	 */
	public static void inorderTraversal(TreeNode root){
		if(root == null) return;
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}
	
	/**
	 * Post-order traversal using recursive method
	 * @param root
	 */
	public static void postorderTraversal(TreeNode root){
		if (root == null) return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.val + " ");
	}
	
	/**
	 * Level traversal using Queue (LinkedList)
	 * @param root
	 */
	public static void levelTraversal(TreeNode root){
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()){
			TreeNode tmp = q.poll();
			System.out.print(tmp.val + " ");
			
			if (tmp.left != null) q.offer(tmp.left);
			if (tmp.right != null) q.offer(tmp.right);
		}
	}
	
	/**
	 * Level traversal and return a List<List<Integer>>
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> big = new ArrayList<>();
        if (root == null) return big;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
        	int levelNum = q.size();
        	List<Integer> small = new ArrayList<>();
        	TreeNode tmp;
        	for (int i = 0 ;i < levelNum; i++){
        		tmp = q.poll();
	            if (tmp.left != null) q.offer(tmp.left);
	            if (tmp.right != null) q.offer(tmp.right);
	            small.add(tmp.val);
        	}
        	big.add(small);
        }
        return big;
    }
	
	/**
	 * Convert a BST to a Doubly-linked list
	 * @param root of the BST
	 * @return head of the list
	 */
	public static TreeNode convertBST2DLL(TreeNode root){
		if (root == null) return null;
		TreeNode previous = null;
		TreeNode curr = root;
		TreeNode head = null;
		Stack<TreeNode> s = new Stack<>();
		while (true){
			while (curr != null){
				s.push(curr);
				curr = curr.left;
			}
			if(s.isEmpty()) break;
			curr = s.pop();
			if (head == null){ // find the list head;
				head = curr;
			}
			curr.left = previous;
			if (previous != null) previous.right = curr;
			
			previous = curr;
			curr = curr.right;
			
		}
		return head;
		
	}
	
	/**
	 * Get node count on k level	
	 * @param root
	 * @param k
	 * @return
	 */
	public static int getNodeNumNth(TreeNode root, int k){
		if (root == null || k<= 0) return 0;
		if(k == 1) return 1;
		return getNodeNumNth(root.left, k-1) + getNodeNumNth(root.right, k-1);
	}
	
	/**
	 * Find how many leaf nodes in the tree
	 * @param root
	 * @return
	 */
	public static int getLeafCount(TreeNode root){
		if(root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		return getLeafCount(root.left) + getLeafCount(root.right);
	}
	
	/**
	 * Check if 2 Trees are the same.
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isSame(TreeNode r1, TreeNode r2){
		if (r1 == null && r2 == null) return true;
		if (r1 == null || r2 == null) return false;
		return r1.val == r2.val && isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
	}
	
	/**
	 * Check if the tree is balanced: 1) both left & right tree are balanced. 2) The depth difference of left & right tree <= 1;
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root){
		if (root == null) return true;
		if(!isBalanced(root.left) || !isBalanced(root.right)) return false;
		int dif = Math.abs(getDepth(root.left) - getDepth(root.right));
		if(dif > 1) return false;
		return true;
	}
	
	/**
	 * Get the mirror tree;
	 * @param root
	 * @return
	 */
	public static TreeNode getMirror(TreeNode root){
		if (root == null) return null;
		TreeNode tmp;
		tmp = root.right;
		root.right = getMirror(root.left);
		root.left = getMirror(tmp);
		
		return root;
	}
	
	/**
	 * Get the mirror tree, has no effect to original tree
	 * @param root
	 * @return
	 */
	public static TreeNode getCopyMirror(TreeNode root){
		if (root == null) return null;
		
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = getCopyMirror(root.right);
		newRoot.right = getCopyMirror(root.left);
		
		
		return newRoot;
	}
	
	/**
	 * Check if 2 trees are mirror
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isMirror(TreeNode r1, TreeNode r2){
		if(r1 == null && r2 == null) return true;
		if (r1 == null || r2 == null) return false;
		return r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror (r1.right, r2.left);
	}
	
	/**
	 * Find the Least Common Ancestor (LCA) 	 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2){
		if (root == null || node1 == null || node2 == null)	return null;
		if(root == node1 || root == node2) return root; //find the node;
		
		TreeNode left = findLCA(root.left, node1, node2);
		TreeNode right = findLCA(root.right, node1, node2);
		
		if(left == null) return right;
		else if(right == null) return left;
		
		return root;
	}
	
	/**
	 * The Result class for findMaxDistance method
	 * @author linkui
	 *
	 */
	private static class Result{
		int depth;
		int maxDistance;
		Result(int depth, int maxDistance){
			this.depth = depth;
			this.maxDistance = maxDistance;
		}
	}
	
	/**
	 * Find the max distance, 3 situations, max distance is the max one among them:
	 * 1. Only has left tree, 
	 * 2. Only has right tree,
	 * 3. Cross root chain, is sum of depths of left, right and 2;
	 * @param root
	 * @return
	 */
	public static int findMaxDistance(TreeNode root){
		return findMaxDistanceSub(root).maxDistance;
	}
	
	public static Result findMaxDistanceSub(TreeNode root){
		Result rest = new Result(-1,-1);
		if(root == null) return rest;
		
		Result left = findMaxDistanceSub(root.left);
		Result right = findMaxDistanceSub(root.right);
		
		rest.depth = Math.max(left.depth, right.depth) + 1;
		
		int crosslen = left.depth + right.depth + 2;
		
		rest.maxDistance = Math.max(left.maxDistance, right.maxDistance);
		rest.maxDistance = Math.max(rest.maxDistance, crosslen);
		
		return rest;
	}
	
	
}

/*class MyTreeNode{
	int val;
	MyTreeNode left;
	MyTreeNode right;
	
	public MyTreeNode(int val){
		this.val = val;
		left = null;
		right = null;
	}
}*/