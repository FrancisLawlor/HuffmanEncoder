import java.util.*;

/**
 * This class contains the data and methods needed for constructing a tree needed
 * for generating the Huffman codes.
 *
 * @author Francis Lawlor
 */
public class Node implements Comparator<Node> {
	private LinkedList<Node> children = new LinkedList<Node>();
	private double val;
	private Node parent;
	private int index;

	public Node(double val) {
		this.val = val;
	}

	public Node() {

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

	public int compare(Node node1, Node node2) {
		return Double.compare(node1.getNodeVal(), node2.getNodeVal());
	}

	public void sortChildren() {
		Collections.sort(this.children, new Node());
	}
}
