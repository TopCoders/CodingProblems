package com.ds.tree;


public class SortedList2BST {
	
	private static class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private static class ListNode {
		public ListNode next;
		public int val;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		ListNode midNode = partitionNode(head);
		TreeNode node = new TreeNode(midNode.val);
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(midNode.next);
		return node;
	}
	
	public ListNode partitionNode(ListNode head) {
		ListNode runner = head;
		ListNode last = null;
		while (runner != null && runner.next != null) {
			last = head;
			head = head.next;
			runner = runner.next.next;
		}
		if (last != null) {
			last.next = null;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode node1 = new ListNode(3);
		node.next = node1;
		SortedList2BST sol = new SortedList2BST();
		sol.sortedListToBST(node);

	}

}
