package ds.linkedLists;

public class ReturnKthToLastIterativeTwoPointer {
	
	private static LinkedListNode kthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		/* moving p1 pointer k nodes into the list */
		for(int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		/* moving them at the same pace. when p1 hits the end, p2 will k nodes before the end i.e., kth from last */
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
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
		
		LinkedListNode node = kthToLast(head, 1);
		System.out.println(node.data);
	}
}
