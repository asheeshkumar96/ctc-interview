package ds.stackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	private Stack getLastStack() {
		if(stacks.isEmpty()) return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int v) {
		Stack last = getLastStack();
		if(last != null && !last.isFull()) { // add to last stack
			last.push(v);
		} else { // must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		if(last == null) throw new EmptyStackException();
		int v = (int) last.pop();
		if(last.isEmpty()) stacks.remove(stacks.size() - 1);
		return v;
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removedItem;
		if(removeTop) removedItem = (int) stack.pop();
		else removedItem = stack.removeBottom();
		if(stack.isEmpty()) {
			stacks.remove(index);
		} else if(stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removedItem;
	}
}

class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	public Stack(int capacity) { this.capacity = capacity; }
	
	public boolean isFull() { return capacity == size; };
	
	public void join(Node above, Node below) {
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	public boolean push(int v) {
		if(size >= capacity) return false;
		size++;
		Node n = new Node(v);
		if(size == 1) bottom = n;
		join(n, top);
		top = n;
		return true;
	}
	
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below = null;
		size--;
		return b.value;
	}
}

class Node {
	int value;
	Node above;
	Node below;
	
	public Node(int value) {
		this.value = value;
	}
}
