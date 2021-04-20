package ds.linkedLists;

public class LinkedListNode {

	LinkedListNode next;
	int data;
	
	public LinkedListNode(int data) {
		super();
		this.data = data;
	}
	
	public static void printLinkedList(LinkedListNode head) {
		if(head == null) {
			return;
		}
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
