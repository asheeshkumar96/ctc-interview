package ds.stackAndQueues;

import java.util.LinkedList;

public class AnimalShelter {

	public static void main(String[] args) throws InterruptedException {
		AnimalQueue animalQueue = new AnimalQueue();
		new Thread(() -> {
			animalQueue.enqueue(new Cat("cat1"));
			animalQueue.enqueue(new Cat("cat2"));
			animalQueue.enqueue(new Cat("cat3"));
		}).start();
		//Thread.sleep(10);
		animalQueue.enqueue(new Dog("animal4"));
		animalQueue.enqueue(new Dog("animal5"));
		animalQueue.enqueue(new Dog("animal6"));

		System.out.println(animalQueue.dequeueAny().name);
		System.out.println(animalQueue.dequeueCats().name);
		System.out.println(animalQueue.dequeueDogs().name);

	}
}

class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private long order = 0; // acts as timestamp

	public void enqueue(Animal a) {
		// order is used as a sort of timestamp, so that we can compare the insertion
		// order of a dog to a cat.
		a.setOrder(order);
		order++;

		if (a instanceof Dog)
			dogs.addLast((Dog) a);
		else if (a instanceof Cat)
			cats.addLast((Cat) a);
	}

	public Animal dequeueAny() {
		// Look at the tops of dog and cat queues, and pop the queue with the oldest value
		if(dogs.isEmpty()) {
			return dequeueCats();
		} else if (cats.isEmpty()) {
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}
}

abstract class Animal {

	private long order;

	protected String name;

	protected Animal(String n) {
		name = n;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}
