import java.util.*;

/**
 * This class contains the data and methods needed for constructing a tree needed
 * for generating the Huffman codes.
 *
 * @author Francis Lawlor
 */
public class Node {
	private LinkedList<Node> children = new LinkedList<Node>();
	private double val;
	private Node parent;
	private int index;

	Node(double val) {
		this.val = val;
	}

	public Node getParent() {
		return this.parent;
	}

	private void setParent(Node parent) {
		this.parent = parent;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	public void addChild(Node child) {
		child.setParent(this);
		this.children.add(child);
	}

	public LinkedList<Node> getChildren() {
		return this.children;
	}

	public void setNodeVal(double val) {
		this.val = val;
	}

	public double getNodeVal() {
		return this.val;
	}

	public void sortChildren() {
		for (int i = 0; i < children.size(); i++) {
			for (int j = i + 1; j < children.size(); j++) {
				if (children.get(i).getNodeVal() < children.get(j).getNodeVal()) {
					double temp = children.get(j).getNodeVal();
					children.get(j).setNodeVal(children.get(i).getNodeVal());
					children.get(i).setNodeVal(temp);
				}
			}
		}
	}
}
