package ds.treesAndGraphs;

import java.util.Arrays;

public class Node {
	String name;
	Node[] children;
	State state;

	public Node(String name, Node[] children) {
		this.name = name;
		this.children = children;
		this.state = State.UNVISITED;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", children=" + Arrays.toString(children) + ", state=" + state + "]";
	}
}
