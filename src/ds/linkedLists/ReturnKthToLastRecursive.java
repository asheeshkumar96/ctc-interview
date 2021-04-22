package ds.linkedLists;

public class ReturnKthToLastRecursive {
	
	public static int printKthToLast(LinkedListNode head, int k) {
		if(head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if(index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
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
		
		printKthToLast(head, 2);
	}
}
