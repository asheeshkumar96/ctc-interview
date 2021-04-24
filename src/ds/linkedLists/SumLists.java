package ds.linkedLists;

public class SumLists {
	// official
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) return null;
		
		LinkedListNode result = new LinkedListNode();
		int value = carry; 
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		
		result.data = value % 10; /* Second digit of number */
		// recurse
		if(l1 != null || l2 != null) { // very imp
			LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value / 10); // very imp
			result.next = more;
		}
		
		return result;
	}
	
	private static int evaluateLinkedListNumber(LinkedListNode node) {
		if(node == null) 
			return 0;
		
		int sum = 0;
		int place = 0;
		while(node != null) {
			int placeValue = ((int) Math.pow(10, place++) ) * node.data;
			sum += placeValue;
			node = node.next;
		}
		return sum;
	}

	public static void main(String[] args) {
		LinkedListNode num1 = new LinkedListNode(7);
		num1.next = new LinkedListNode(1);
		num1.next.next = new LinkedListNode(6);
		
		LinkedListNode num2 = new LinkedListNode(5);
		num2.next = new LinkedListNode(9);
		num2.next.next = new LinkedListNode(2);
		
		LinkedListNode result = addLists(num1, num2, 0);
		System.out.println(evaluateLinkedListNumber(result));
	}
}
