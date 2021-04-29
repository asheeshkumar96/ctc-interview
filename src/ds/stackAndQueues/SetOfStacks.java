package ds.stackAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	public void push(int v) {
		Stack last = getLastStack();
		if(last != null && !(last.size()== capacity) ) { // add to last stack
			last.push(v);
		} else { // must create new stack
			Stack stack = new Stack<>();
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		
		return 0;
	}
	
	private Stack getLastStack() {
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}
}
