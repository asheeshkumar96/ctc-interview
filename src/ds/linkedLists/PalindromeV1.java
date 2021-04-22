package ds.linkedLists;

public class PalindromeV1 {
	
	private static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
	
	private static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while(node != null) {
			LinkedListNode n = new LinkedListNode(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	private static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while(one != null && two != null) {
			if(one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(5);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(2);
		head.next.next.next = new LinkedListNode(1);
		head.next.next.next.next = new LinkedListNode(5);
		
		System.out.println(isPalindrome(head));
	}
}
