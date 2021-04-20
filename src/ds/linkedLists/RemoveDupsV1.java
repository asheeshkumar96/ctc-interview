package ds.linkedLists;


public class RemoveDupsV1 {
	
	// time -> O(n^2), space -> O(1)
	private static void deleteDups(LinkedListNode head) {
		if(head == null) 
			return;
		
		LinkedListNode current = head;
		while(current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
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
		deleteDups(head);
		LinkedListNode.printLinkedList(head);
	}
}
