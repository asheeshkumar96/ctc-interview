package ds.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import code.library.TreeNode;

public class ListOfDepths {

	private static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode rootNode ) {
		List<LinkedList<TreeNode>> lists = new ArrayList<>();
		crateLevelLinkedListRecursiveDFS(rootNode, lists, 0);
		return lists;
	}
	
	private static void crateLevelLinkedListRecursiveDFS(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
		if(root == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 to i - 1. We can therefore safely
			 * add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		crateLevelLinkedListRecursiveDFS(root.left, lists, level + 1);
		crateLevelLinkedListRecursiveDFS(root.right, lists, level + 1);
	}
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(3);
	
		List<LinkedList<TreeNode>> levelLinkedList = createLevelLinkedList(treeNode);
		for(LinkedList<TreeNode> list: levelLinkedList) {
			System.out.println(list);
		}
	}
}
