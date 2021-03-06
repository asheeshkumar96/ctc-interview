package ds.linkedLists;

import java.util.HashSet;

public class RemoveDups {
	
	// time -> O(N), space O(N)
	private static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<>();
		LinkedListNode previous = null;
		while(n != null) {
			if(set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
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
