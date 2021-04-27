package ds.stackAndQueues;

public class StackMin {

	public static void main(String[] args) {
		StackWithMin stackWithMin = new StackWithMin();
		System.out.println(stackWithMin.min());
		stackWithMin.push(3);
		System.out.println(stackWithMin.min());
		
		stackWithMin.push(2);
		System.out.println(stackWithMin.min());
		stackWithMin.push(0);
		System.out.println(stackWithMin.min());
		stackWithMin.push(-1);
		System.out.println(stackWithMin.min());
		stackWithMin.pop();
		stackWithMin.pop();
		System.out.println(stackWithMin.min());
		
		
		System.out.println("-------------------------------------");
		StackWithMin2 stackWithMin2 = new StackWithMin2();
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(5);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(0);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(-1);
		System.out.println(stackWithMin2.min());
		stackWithMin2.pop();
		System.out.println(stackWithMin2.min());
		stackWithMin2.pop();
		System.out.println(stackWithMin2.min());
		
	}
}
