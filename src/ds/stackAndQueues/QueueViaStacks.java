package ds.stackAndQueues;

public class QueueViaStacks {

	public static void main(String[] args) {
		MyQueue<Integer> integerQueue = new MyQueue<>();
		integerQueue.add(10);
		integerQueue.add(20);
		integerQueue.add(30);
		System.out.println(integerQueue.remove());
		integerQueue.add(40);
		System.out.println(integerQueue.remove());
	}
}
