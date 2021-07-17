package ds.stackAndQueues;

public class StackOfPlates {

	public static void main(String[] args) {
		SetOfStacks setOfStacks = new SetOfStacks(3);
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
	}
}
