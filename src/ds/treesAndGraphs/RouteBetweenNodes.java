package ds.treesAndGraphs;

import java.util.LinkedList;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		Graph graph = new Graph();
		Node node1 = new Node("A", null);
		Node node2 = new Node("B", null);
		Node node3 = new Node("C", null);

		Node node4 = new Node("D", null);
		Node node5 = new Node("E", null);
		node1.children = new Node[] { node2, node3 };
		node3.children = new Node[] { node4 };
		node2.children = new Node[] { node5 };

		graph.nodes = new Node[] { node1 };
		System.out.println(graph);

		System.out.println(search(graph, node2, node5));
	}

	private static boolean search(Graph g, Node start, Node end) {
		if (start == end)
			return true;

		// Operates as queue
		LinkedList<Node> q = new LinkedList<>();

//		for (Node u : g.nodes) {
//			u.state = State.UNVISITED;
//		}

		start.state = State.VISITING;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // dequeue
			if (u != null && u.children != null) {
				for (Node v : u.children) {
					if (v.state == State.UNVISITED) {
						if (v == end) {
							return true;
						} else {
							v.state = State.VISITING;
							q.add(v);
						}
					}
				}
				u.state = State.VISITED;
			}
		}
		return false;
	}
}

enum State {
	UNVISITED, VISITED, VISITING;
}
