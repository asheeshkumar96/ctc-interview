package ds.linkedLists;

class PartialSum {
	public LinkedListNode sum = null;
	public int carry = 0;
}

public class SumListsFollowUp {
	
	// official
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		System.out.println("len1=" + len1 + ", len2=" + len2);
		// pad the shorter list with zeroes
		if(len1 < len2) {
			l1  = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		
		// add lists
		PartialSum sum = addListsHelper(l1, l2);
		// if there was a carry value left over, insert this at the front of the list, otherwise just return the linked list.
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		// add smaller digits recursively
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		// add carry to current data
		int val = sum.carry + l1.data + l2.data;
		
		// insert sum of current digits
		LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
		
		// return sum so far, and the carry value
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}
	
	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for(int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	// helper function to insert node in the front of a linked list
	private static LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if(list != null) {
			node.next = list;
		}
		return node;
	}
	
	private static int length(LinkedListNode ll) {
		int length = 0; 
		if(ll == null) return length;
		
		while (ll != null) {
			length++;
			ll = ll.next;
		}
		return length;
	}

	public static void main(String[] args) {
		LinkedListNode num1 = new LinkedListNode(6);
		num1.next = new LinkedListNode(1);
		num1.next.next = new LinkedListNode(7);
		
		LinkedListNode num2 = new LinkedListNode(2);
		num2.next = new LinkedListNode(9);
		num2.next.next = new LinkedListNode(5);
				
		LinkedListNode result = addLists(num1, num2);
		while(result != null) {
			System.out.print(result.data);
			result = result.next;
		}
	}
}


