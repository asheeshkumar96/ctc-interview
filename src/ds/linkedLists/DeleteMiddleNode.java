package ds.linkedLists;

public class DeleteMiddleNode {
	
	// also official
	private static boolean deleteNode(LinkedListNode n) {
		if(n == null || n.next == null) {
			System.out.println("either last, null or empty node passed");
			return false;
		}
		
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
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
		boolean status = deleteNode(head.next.next);
		System.out.println("operation status=" + status);
		LinkedListNode.printLinkedList(head);
	}
}
