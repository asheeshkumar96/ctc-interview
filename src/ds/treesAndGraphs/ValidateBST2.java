package ds.treesAndGraphs;

import code.library.TreeNode;

public class ValidateBST2 {

	// The idea is understood, not the implementation.
	private static boolean checkBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.data <= min) || (max != null && root.data > max)) {
			return false;
		}

		if ( !checkBST(root.left, min, root.data) || !(checkBST(root.right, root.data, max)) ) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100);
		root.setLeftChildForcefully(new TreeNode(80));
		root.setRightChildForcefully(new TreeNode(120));

		System.out.println(checkBST(root, null, null));
	}

}
