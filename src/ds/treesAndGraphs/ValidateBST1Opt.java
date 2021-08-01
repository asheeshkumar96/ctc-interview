package ds.treesAndGraphs;

import code.library.TreeNode;

public class ValidateBST1Opt {

	static Integer lastPrinted = null;

	// It assumes that the tree don't have duplicate values otherwise this solution
	// won't work
	private static boolean checkBST(TreeNode n) {
		if (n == null) {
			return true;
		}

		// check / recurse left
		if (!checkBST(n.left)) {
			return false;
		}
		// check current
		if (lastPrinted != null && n.data <= lastPrinted) {
			return false;
		}
		lastPrinted = n.data;
		// check / recurse right
		if (!checkBST(n.right)) {
			return false;
		}

		return true; // all good
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100);
		root.setLeftChildForcefully(new TreeNode(80));
		root.setRightChildForcefully(new TreeNode(120));

		System.out.println(checkBST(root));
	}
}
