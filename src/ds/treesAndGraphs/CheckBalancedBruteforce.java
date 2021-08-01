package ds.treesAndGraphs;

import code.library.TreeNode;

public class CheckBalancedBruteforce {
	
	private static int getHeight(TreeNode root) {
		if(root == null) return -1; // base case
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	private static boolean isBalanced(TreeNode root) {
		if(root == null) return true; // base case
		int heightDiff  = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
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
