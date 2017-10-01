import java.util.*;

class HuffmanEncoder {
	public static LinkedList<String> generateHuffmanCode(LinkedList<Double> pmf, int D) {
		LinkedList<Node> nodes = new LinkedList<Node>();

		for (int i = 0; i < pmf.size(); i++) {
			nodes.add(new Node(pmf.get(i)));
		}

		addDummyNodes(nodes, D);

		while (nodes.size() != 1) {
			sortNodes(nodes);

			// Create new node and add D smallest elements as children.
			Node newParent = new Node(0.0);
			
			for (int i = 0; i < D; i++) {
				newParent.addChild(nodes.get(nodes.size() - 1));
				newParent.setNodeVal(newParent.getNodeVal() + nodes.get(nodes.size() - 1).getNodeVal());
				nodes.remove(nodes.size() - 1);
			}

			newParent.sortChildren();

			// Add indices to children for use in obtaining codes later.
			for (int i = 0; i < newParent.getChildren().size(); i++) {
				newParent.getChildren().get(i).setIndex(i);
			}

			nodes.add(newParent);
		}

		return depthFirstSearch(nodes.get(0));
	}

	private static void sortNodes(LinkedList<Node> nodes) {
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = i + 1; j < nodes.size(); j++) {
				if (nodes.get(i).getNodeVal() < nodes.get(j).getNodeVal()) {
					double temp = nodes.get(j).getNodeVal();
					nodes.get(j).setNodeVal(nodes.get(i).getNodeVal());
					nodes.get(i).setNodeVal(temp);
				}
			}
		}
	}

	private static LinkedList<String> depthFirstSearch(Node root) {
		LinkedList<Node> nodes_to_visit = new LinkedList<Node>();
		nodes_to_visit.add(root);
		LinkedList<String> output = new LinkedList<String>();

		while (!nodes_to_visit.isEmpty()) {
			Node currentnode = nodes_to_visit.get(0);
			nodes_to_visit.remove(0);
			for (Node n: currentnode.getChildren()) {
				nodes_to_visit.add(n);
			}

			Node presentNode = currentnode;

			// Trace edge nodes upwards to root to obtain the code.
			if (presentNode.getChildren().size() == 0) {
				StringBuilder code = new StringBuilder();
				while (!presentNode.equals(root)) {
					code.insert(0, presentNode.getIndex());
					presentNode = presentNode.getParent();
				}

				output.add(code.toString());
			}
		}

		return output;
	}

	private static void addDummyNodes(LinkedList<Node> currentNodes, int D) {
		while (((currentNodes.size() - 1) / ((float) D - 1)) % 1 != 0) {
			currentNodes.add(new Node(0.0));
		}
	}
}
