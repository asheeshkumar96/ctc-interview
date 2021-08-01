package ds.treesAndGraphs;

import code.library.TreeNode;

public class CheckBalancedOpt {
	
	private static int checkHeight(TreeNode root) {
		if(root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return leftHeight;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return rightHeight;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	private static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(3);
		rootNode.right = new TreeNode(8);
		rootNode.left.left = new TreeNode(1);
		rootNode.left.right = new TreeNode(2);
		System.out.println(isBalanced(rootNode));
		rootNode.left.left.left = new TreeNode(10);
		System.out.println(isBalanced(rootNode));
	}
}
