package code.library;

public class TreeNode {
	public int data;
	public TreeNode left; 
	public TreeNode right; 
	public TreeNode parent;
	public int size = 0;
	
	public TreeNode(int d) {
		this.data = d;
		size = 1;
	}
	
	public void insertInOrder(int d) {
		if(d <= data) {
			if(left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if(right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public TreeNode find(int d) {
		if(d == data) {
			return this;
		} else if(d <= data) {
			return left != null ? left.find(d) : null;
		} else if(d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if(left != null) {
			left.parent = this;
		}
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if(right != null) {
			right.parent = this;
		}
	}
	
	public void setLeftChildForcefully(TreeNode left) {
		this.left = left;
		if(left != null) {
			left.parent = this;
		}
		size++;
	}
	
	public void setRightChildForcefully(TreeNode right) {
		this.right = right;
		if(right != null) {
			right.parent = this;
		}
		size++;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("TreeNode [data=").append(data).append(", left=").append(left)
				.append(", right=").append(right).append("]").toString();
	}
	
	
	
}
