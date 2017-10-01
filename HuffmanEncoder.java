import java.util.*;

class HuffmanEncoder {
	public static LinkedList<Code> generateHuffmanCode(LinkedList<Double> pmf, int D) {
		LinkedList<Code> codes = new LinkedList<Code>();
		LinkedList<Node> nodes = new LinkedList<Node>();
		LinkedList<String> codeValueStrings = new LinkedList<String>();
		LinkedList<String> huffmanCodeStrings = new LinkedList<String>();

		for (int i = 0; i < pmf.size(); i++) {
			nodes.add(new Node(pmf.get(i)));
		}

		addDummyNodes(nodes, D);
		sortNodes(nodes);

		storeCodeValueStrings(nodes, codeValueStrings);

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

		huffmanCodeStrings = generateHuffmanCodeStrings(nodes.get(0));

		for (int i = 0; i < codeValueStrings.size(); i++) {
			codes.add(new Code(codeValueStrings.get(codeValueStrings.size() - 1 - i), huffmanCodeStrings.get(i)));
		}

		return codes;
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

	private static LinkedList<String> generateHuffmanCodeStrings(Node root) {
		LinkedList<String> codeStrings = new LinkedList<String>();
		LinkedList<Node> nodesToVisit = new LinkedList<Node>();

		nodesToVisit.add(root);

		while (!nodesToVisit.isEmpty()) {
			Node currentNode = nodesToVisit.get(0);
			nodesToVisit.remove(0);

			for (Node n: currentNode.getChildren()) {
				nodesToVisit.add(n);
			}

			Node expandedNode = currentNode;

			// Trace edge nodes upwards to root to obtain the code.
			if (expandedNode.getChildren().size() == 0) {
				StringBuilder codeBuilder = new StringBuilder();

				while (!expandedNode.equals(root)) {
					codeBuilder.insert(0, expandedNode.getIndex());
					expandedNode = expandedNode.getParent();
				}

				codeStrings.add(codeBuilder.toString());
			}
		}

		return codeStrings;
	}

	private static void addDummyNodes(LinkedList<Node> currentNodes, int D) {
		while (((currentNodes.size() - 1) / ((float) D - 1)) % 1 != 0) {
			currentNodes.add(new Node(0.0));
		}
	}

	private static void storeCodeValueStrings(LinkedList<Node> nodes, LinkedList<String> codeValueStrings) {
		for (Node node: nodes) {
			codeValueStrings.add(Double.toString(node.getNodeVal()));
		}
	}
}
