package ds.stackAndQueues;

import java.util.Stack;

public class SortStack {

	// Time complexity O(n^2), space complexity O(n)
	public static void sort(java.util.Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			// Insert each element in s in sorted order into r.
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		// Copy the elements from r back into s.
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<>();
		intStack.push(10);
		intStack.push(5);
		intStack.push(8);
		intStack.push(2);
		intStack.push(3);
		intStack.push(7);
		intStack.push(11);
		System.out.println("before sorting:" + intStack);
		sort(intStack);
		System.out.println("after sorting:" + intStack);
		System.out.println(intStack.pop());
	}
}
