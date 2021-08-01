package ds.treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildOrder {

	private static final Logger logger = Logger.getGlobal();

	private static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		GraphA graphA = buildGraph(projects, dependencies);
		return orderProjects(graphA.getNodes());
	}

	/*
	 * Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a
	 * pair is listed in "build order". The pair (a, b) in dependencies indicates
	 * that b depends on a and a must be built before b.
	 */
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

	/* Return a list of the projects in correct build order */
	private static Project[] orderProjects(List<Project> projects) {
		Project[] order = new Project[projects.size()];

		/* add roots to the build order first */
		int endOfList = addNonDependent(order, projects, 0);

		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			// we have a circular dependency since there are no remaining projects with zero
			// dependencies
			if (current == null) {
				return null;
			}

			// remove current node as a dependency
			List<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}

			// add children that have no one depending on them
			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}

		return order;
	}

	private static int addNonDependent(Project[] order, List<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getDependencies() == 0) {
				order[offset] = project;
				logger.log(Level.SEVERE, "offset={0}", offset);
				offset++;
			}
		}
		return offset;
	}

	// the wrapping mechanism of GraphA and Project is hard to comprehend.
	public static void main(String[] args) {
		String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
		String[][] depndencies = new String[][] { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" },
				{ "d", "c" } };
		Project[] buildOrder = findBuildOrder(projects, depndencies);
		if (buildOrder != null) {
			logger.log(Level.INFO, "buidOrder={0}", buildOrder);
			Arrays.stream(buildOrder).map(a -> a.getName()).forEach(System.out::println);
		} else {
			logger.log(Level.SEVERE, "build order not possible because of circular dependency");
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
		private int dependencies = 0;

		public Project(String n) {
			name = n;
		}

		public void addNeighbour(Project node) {
			if (!map.containsKey(node.name)) {
				children.add(node);
				map.put(node.name, node);
				node.incrementDependencies();
			}
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}

		public String getName() {
			return name;
		}

		public List<Project> getChildren() {
			return children;
		}

		public int getDependencies() {
			return dependencies;
		}
	}

}
