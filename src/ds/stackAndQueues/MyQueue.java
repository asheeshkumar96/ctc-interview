package ds.stackAndQueues;

import java.util.Stack;

public class MyQueue<T> {

	Stack<T> stackOldest;
	Stack<T> stackNewest;
	
	public MyQueue() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		/* Push onto stackNewsest, which always has the newest element on top */
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.pop(); // pop the oldest item
	}
}
