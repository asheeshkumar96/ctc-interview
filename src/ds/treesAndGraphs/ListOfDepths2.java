package ds.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import code.library.TreeNode;

public class ListOfDepths2 {
	
	private static List<LinkedList<TreeNode>> crateLevelLinkedListBFS(TreeNode root) {
		List<LinkedList<TreeNode>> result = new ArrayList<>();
		
		LinkedList<TreeNode> current = new LinkedList<>();
		if(root != null) {
			current.add(root);
		}
		
		while (!current.isEmpty()) {
			result.add(current); // Add previous level
			LinkedList<TreeNode> parents = current; // go to next level
			current = new LinkedList<>();
			for(TreeNode parent : parents) {
				// visit the children
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(3);
	
		List<LinkedList<TreeNode>> levelLinkedList = crateLevelLinkedListBFS(treeNode);
		for(LinkedList<TreeNode> list: levelLinkedList) {
			System.out.println(list);
		}
	}
}
