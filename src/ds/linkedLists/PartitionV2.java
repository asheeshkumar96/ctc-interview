package ds.linkedLists;

public class PartitionV2 {
	
	private static LinkedListNode partition(LinkedListNode node, int x) {
		if(node == null) {
			return node;
		}
		
		LinkedListNode head = node;
		LinkedListNode tail = node;
		while (node != null) {
			LinkedListNode next = node.next;
			if(node.data < x) {
				/* insert node at head */
				node.next = head;
				head = node;
			} else {
				/* insert node at tail*/
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		// the head has changed, so we need to return it.
		return head;
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
