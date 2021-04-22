package ds.linkedLists;

public class ReturnKthToLastRecursiveWrapper {
	
	static class Index {
		public int value = 0;
	}
	
	private static LinkedListNode kthToLast(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}
	
	// why it works ???
	private static LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if(head == null) {
			return null;
		}
		
		LinkedListNode node = kthToLast(head.next, k, idx);
		System.out.println("backtracking.... node=" + node + ", idx=" + idx.value);
		idx.value = idx.value + 1;
		if(idx.value == k) {
			System.out.println("index and k both are same and head="+ head.data);
			return head;
		}
		return node;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(12);
		head.next = new LinkedListNode(11);
		head.next.next = new LinkedListNode(12);
		head.next.next.next = new LinkedListNode(21);
		head.next.next.next.next = new LinkedListNode(41);
		head.next.next.next.next.next = new LinkedListNode(43);
		head.next.next.next.next.next.next = new LinkedListNode(21);
		
		LinkedListNode.printLinkedList(head);
		
		LinkedListNode node = kthToLast(head, 2);
		System.out.println(node.data);
	}
}
