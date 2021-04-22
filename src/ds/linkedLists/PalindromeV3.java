package ds.linkedLists;

public class PalindromeV3 {
	// very hard to understand this solution
	private static boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecursive(head, length);
		return p.result;
	}
	
	private static Result isPalindromeRecursive(LinkedListNode head, int length) {
		if(head == null || length <= 0) { // even number of nodes
			return new Result(head, true);
		} else if(length == 1) { // odd number of nodes
			return new Result(head.next, true);
		}
		
		
		// recurse on sublist
		Result res = isPalindromeRecursive(head.next, length - 2);
		// if child calls are not palindrome pass back a failure
		if(!res.result || res.node == null) {
			return res;
		}
		// check if matches corresponding node on other side
		res.result = (head.data == res.node.data);
		
		// return corresponding node
		res.node = res.node.next;
		
		return res;
	}
	
	private static int lengthOfList(LinkedListNode n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
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

class Result {
	public LinkedListNode node;
	public boolean result;
	
	public Result(LinkedListNode n, boolean result) {
		super();
		this.node = n;
		this.result = result;
	}
}
