package ds.linkedLists;

public class PartitionV1 {
	
	private static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data < x) {
				// insert node into end of before list 
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node; // beforeEnd.next;
				}
			} else {
				// insert node into end of after list
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node; // afterEnd.next
				}
			}
			node = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		/* merge before list and after list */
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(3);
		head.next = new LinkedListNode(5);
		head.next.next = new LinkedListNode(8);
		head.next.next.next = new LinkedListNode(5);
		head.next.next.next.next = new LinkedListNode(10);
		head.next.next.next.next.next = new LinkedListNode(2);
		head.next.next.next.next.next.next = new LinkedListNode(1);
		
		LinkedListNode.printLinkedList(head);
		LinkedListNode node = partition(head, 5);
		LinkedListNode.printLinkedList(node);
		
	}
}
