package ds.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BuildOrder2 {

	private static final Logger logger = Logger.getGlobal();
	
	private static Deque<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		GraphA graphA = buildGraph(projects, dependencies);
		return orderProjects(graphA.getNodes());
	}

	private static Deque<Project> orderProjects(List<Project> projects) {
		Deque<Project> stack = new ArrayDeque<>();
		for(Project project : projects) {
			if(project.getState() == State.BLANK) {
				if(!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	private static boolean doDFS(Project project, Deque<Project> stack) {
		if (project.getState() == State.PARTIAL) {
			return false; // cycle
		}

		if (project.getState() == State.BLANK) {
			project.setState(State.PARTIAL);
			List<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(State.COMPLETE);
			stack.push(project);
		}

		return true;
	}
	
	private static GraphA buildGraph(String[] projects, String[][] dependencies) {
		GraphA graphA = new GraphA();
		for (String project : projects) {
			graphA.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			graphA.addEdge(dependency[0], dependency[1]);
		}
		return graphA;
	}

	public static void main(String[] args) {
		String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
		String[][] depndencies = new String[][] { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" },
				{ "d", "c" } };
		logger.log(Level.INFO, "projects -> {}", projects);
		logger.log(Level.INFO, "dependencies -> {}", depndencies);
		Deque<Project> buildOrder = findBuildOrder(projects, depndencies);
		if(buildOrder != null) {
			while(!buildOrder.isEmpty()) {
				Project removedProject = buildOrder.pop();
				System.out.println(removedProject.getName());
			}
		} else {
			logger.log(Level.SEVERE, "no build order possible");
		}
	}

	private static class GraphA {
		private List<Project> nodes = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();

		public Project getOrCreateNode(String name) {

			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbour(end);
		}

		public List<Project> getNodes() {
			return nodes;
		}
	}

	private static class Project {
		private List<Project> children = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();
		private String name;

		public State state = State.BLANK;

		public Project(String n) {
			name = n;
		}

		public void addNeighbour(Project node) {
			if (!map.containsKey(node.name)) {
				children.add(node);
				map.put(node.name, node);
			}
		}

		public String getName() {
			return name;
		}

		public List<Project> getChildren() {
			return children;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

	}

	private enum State {
		COMPLETE, PARTIAL, BLANK
	};

}
