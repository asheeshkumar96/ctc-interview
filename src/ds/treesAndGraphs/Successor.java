package ds.treesAndGraphs;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.TreeNode;

public class Successor {

	private static final Logger logger = Logger.getGlobal();
	
	private static TreeNode inorderSucc(TreeNode n) {
		if(n == null) return null;
		
		/* Found right children -> return leftmost node of right subtree. */
		if(n.right != null) {
			return leftMostChild(n.right);
		} else {
			// tricky part
			TreeNode q = n;
			TreeNode x = q.parent;
			// go up until we're on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	private static TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;

		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(10);
		TreeNode nodeWith5 = new TreeNode(5);
		tree.setLeftChildForcefully(nodeWith5);
		tree.setRightChildForcefully(new TreeNode(15));
		TreeNode nodeWith8 = new TreeNode(8);
		nodeWith5.setRightChildForcefully(nodeWith8);
		
		TreeNode inorderSucc = inorderSucc(nodeWith8);
		logger.log(Level.WARNING, "inorderSuccessor : {0}", inorderSucc.data);
	}
}
