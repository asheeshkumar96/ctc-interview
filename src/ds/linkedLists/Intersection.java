package ds.linkedLists;

public class Intersection {
	
	static class Result {
		public LinkedListNode tail;
		public int size;
		
		public Result(LinkedListNode tail, int size) {
			super();
			this.tail = tail;
			this.size = size;
		}
	}
	
	private static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		if(list1 == null || list2 == null) return null;
		
		// get tail and sizes
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		// if different tail nodes, then there's no intersection
		if(result1.tail != result2.tail) {
			return null;
		}
		
		// set pointers to the start of each linked lists.
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
		// advance the pointer for the longer linkedlist by difference in lengths
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		// move both pointer until you have a collision
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		// return either one
		return longer;
	}
	
	private static Result getTailAndSize(LinkedListNode list) {
		if(list == null) return null;
		int size = 1;
		LinkedListNode current = list;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	private static LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while(k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

	public static void main(String[] args) {
		LinkedListNode list1 = new LinkedListNode(3);
		list1.next = new LinkedListNode(1);
		list1.next.next = new LinkedListNode(5);
		list1.next.next.next = new LinkedListNode(9);
		
		list1.next.next.next.next = new LinkedListNode(7);
		list1.next.next.next.next.next = new LinkedListNode(2);
		list1.next.next.next.next.next.next = new LinkedListNode(1);
		
		LinkedListNode list2 = new LinkedListNode(4);
		list2.next = new LinkedListNode(6);
		list2.next.next = list1.next.next.next.next;
		
		LinkedListNode result = findIntersection(list1, list2);
		if(result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("Not intersecting");
		}
	}
}
