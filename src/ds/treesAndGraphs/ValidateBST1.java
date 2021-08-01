package ds.treesAndGraphs;

import code.library.TreeNode;

public class ValidateBST1 {
	
	static int index = 0;
	
	private static void copyBST(TreeNode root, int[] array) {
		if(root == null) return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}
	
	// It assumes that the tree don't have duplicate values otherwise this solution won't work
	private static boolean checkBST(TreeNode root) {
		int[] array = new int[root.size];
		copyBST(root, array);
		for(int i = 1; i < array.length; i++) {
			if(array[i] <= array[i - 1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100);
		root.setLeftChildForcefully( new TreeNode(80));
		root.setRightChildForcefully(new TreeNode(120));
		
		System.out.println(checkBST(root));
	}
}
