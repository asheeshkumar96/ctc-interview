package ds.treesAndGraphs;

import code.library.TreeNode;

public class MinimalTree {
	
	private static TreeNode createMinimalBST(int[] array) {
		return createMinimalBSTRecursive(array, 0, array.length - 1);
	}
	
	private static TreeNode createMinimalBSTRecursive(int[] array, int start, int end) {
		if(end < start) {
			return null;
		}
		int mid = start  + (end - start) / 2;
		TreeNode n = new TreeNode(array[mid]);
		n.left = createMinimalBSTRecursive(array, start, mid - 1);
		n.right = createMinimalBSTRecursive(array, mid + 1, end);
		return n;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		TreeNode treeNode = createMinimalBST(array);
		System.out.println(treeNode);
	}
}
