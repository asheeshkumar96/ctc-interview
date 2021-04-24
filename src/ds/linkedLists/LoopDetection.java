package ds.linkedLists;

public class LoopDetection {
	
	private static LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head; 
		LinkedListNode fast = head;
		
		// find metting point, 
		while(fast != null && fast.next != null) {
			slow = slow.next; 
			fast = fast.next.next;
			if(slow == fast) { // collision
				break;
			}
		}
		
		// error check - no meeting point, and therefore no loop
		if(fast == null || fast.next == null) return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next; 
			fast = fast.next;
		}
		return fast;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode('A');
		head.next = new LinkedListNode('B');
		head.next.next = new LinkedListNode('C');
		head.next.next.next = new LinkedListNode('D');
		head.next.next.next.next = new LinkedListNode('E');
		head.next.next.next.next.next = head.next.next;
		
		char result = (char) findBeginning(head).data;
		System.out.println(result);
	}
}
