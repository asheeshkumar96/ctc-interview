package ds.linkedLists;

import java.util.Stack;

public class PalindromeV2 {
	
	private static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<>();
		// push elements from first half of linked list onto stack. when fast runner (which is moving at 2x speed) reaches
		// the end of the linked list, the we know we're at the middle
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next; 
			fast = fast.next.next;
		}
		
		/** Important point **/
		// has odd number of elements, so skip the middle element
		if(fast != null) {
			slow = slow.next; 
		}
		
		while(slow != null) {
			int top = stack.pop();
			// if values are different, then it's not a palindrome
			if(top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(5);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(8);
		head.next.next.next = new LinkedListNode(2);
		head.next.next.next.next = new LinkedListNode(2);
		head.next.next.next.next.next = new LinkedListNode(8);
		head.next.next.next.next.next.next = new LinkedListNode(1);
		head.next.next.next.next.next.next.next = new LinkedListNode(5);
		
		System.out.println(isPalindrome(head));
	}
}
