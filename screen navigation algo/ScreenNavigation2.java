import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {
		x = 0;
		y = 0;
	}
}

class Board {
	int height;
	int width;
	String name;

	public Board(int height, int width, String name) {
		this.height = height;
		this.width = width;
		this.name = name;
	}

}

class Node {
	Point pos;
	Board data;

	Node(Point pos, Board data) {
		this.pos = pos;
		this.data = data;
	}

	Node() {
		data = null;
	}
}

class Quad {
	Point topLeft;
	Point botRight;
	Node n;
	Quad topLeftTree;
	Quad topRightTree;
	Quad botLeftTree;
	Quad botRightTree;

	// Default constructor
	public Quad() {
		this.topLeft = new Point(0, 0);
		this.botRight = new Point(0, 0);
		this.n = null;
		this.topLeftTree = null;
		this.topRightTree = null;
		this.botLeftTree = null;
		this.botRightTree = null;
	}

	// Parameterized constructor
	public Quad(Point topL, Point botR) {
		this.n = null;
		this.topLeftTree = null;
		this.topRightTree = null;
		this.botLeftTree = null;
		this.botRightTree = null;
		this.topLeft = topL;
		this.botRight = botR;
	}

	// Insert a node into the quadtree
	void insert(Node node) {
		if (node == null)
			return;

		// Check if the node is within the boundary of the quad
		if (!inBoundary(node.pos))
			return;

		// If the quad is a unit area, insert the node directly
		System.out.println(topLeft.x + " " + botRight.x + " " +topLeft.y + " " + botRight.y);
		if (Math.abs(topLeft.x - botRight.x) <= 1 && Math.abs(topLeft.y - botRight.y) <= 1) {
			// If there's no node already in this quad, insert the node
			if (n == null)
				n = node;
			return;
		}

		// If the node is within the top-left quadrant
		if ((topLeft.x + botRight.x) / 2 >= node.pos.x) {
			if ((topLeft.y + botRight.y) / 2 >= node.pos.y) {
				// Indicates topLeftTree
				if (topLeftTree == null)
					topLeftTree = new Quad(
							new Point(topLeft.x, topLeft.y),
							new Point((topLeft.x + botRight.x) / 2, (topLeft.y + botRight.y) / 2));
				topLeftTree.insert(node);
			} else {
				// Indicates botLeftTree
				if (botLeftTree == null)
					botLeftTree = new Quad(
							new Point(topLeft.x, (topLeft.y + botRight.y) / 2),
							new Point((topLeft.x + botRight.x) / 2, botRight.y));
				botLeftTree.insert(node);
			}
		} else {
			// If the node is within the top-right quadrant
			if ((topLeft.y + botRight.y) / 2 >= node.pos.y) {
				// Indicates topRightTree
				if (topRightTree == null)
					topRightTree = new Quad(
							new Point((topLeft.x + botRight.x) / 2, topLeft.y),
							new Point(botRight.x, (topLeft.y + botRight.y) / 2));
				topRightTree.insert(node);
			} else {
				// Indicates botRightTree
				if (botRightTree == null)
					botRightTree = new Quad(
							new Point((topLeft.x + botRight.x) / 2, (topLeft.y + botRight.y) / 2),
							new Point(botRight.x, botRight.y));
				botRightTree.insert(node);
			}
		}
	}

	// Search for a node in the quadtree
	Node search(Point p) {
		if (!inBoundary(p))
			return null;

		if (n != null)
			return n;

		if ((topLeft.x + botRight.x) / 2 >= p.x) {
			if ((topLeft.y + botRight.y) / 2 >= p.y) {
				// Indicates topLeftTree
				if (topLeftTree == null)
					return null;
				return topLeftTree.search(p);
			} else {
				// Indicates botLeftTree
				if (botLeftTree == null)
					return null;
				return botLeftTree.search(p);
			}
		} else {
			if ((topLeft.y + botRight.y) / 2 >= p.y) {
				// Indicates topRightTree
				if (topRightTree == null)
					return null;
				return topRightTree.search(p);
			} else {
				// Indicates botRightTree
				if (botRightTree == null)
					return null;
				return botRightTree.search(p);
			}
		}
	}

	// Check if a point is within the boundary of the quadtree
	boolean inBoundary(Point p) {
		return (p.x >= topLeft.x && p.x <= botRight.x && p.y >= topLeft.y && p.y <= botRight.y);
	}

	public List<Node> queryRange(double xMin, double xMax, double yMin, double yMax, QuadTreeNode node) {
		List<Node> result = new ArrayList<>();

		if (node == null)
			return result;

		if (xMax < node.xMin || xMin > node.xMax || yMax < node.yMin || yMin > node.yMax)
			return result;

		// for (Point point : node.points) {
		// if (point.x >= xMin && point.x <= xMax && point.y >= yMin && point.y <= yMax)
		// result.add(point);
		// }

		double xMid = (node.xMin + node.xMax) / 2;
		double yMid = (node.yMin + node.yMax) / 2;

		if (node.children[0] != null && xMin <= xMid && yMin <= yMid)
			result.addAll(queryRange(xMin, xMax, yMin, yMax, node.children[0]));
		if (node.children[1] != null && xMax >= xMid && yMin <= yMid)
			result.addAll(queryRange(xMin, xMax, yMin, yMax, node.children[1]));
		if (node.children[2] != null && xMin <= xMid && yMax >= yMid)
			result.addAll(queryRange(xMin, xMax, yMin, yMax, node.children[2]));
		if (node.children[3] != null && xMax >= xMid && yMax >= yMid)
			result.addAll(queryRange(xMin, xMax, yMin, yMax, node.children[3]));

		return result;
	}

	public void traverseQuadTree(Quad quad) {
		if (quad == null) {
			return;
		}

		if (quad.n != null) {
			System.out.println(
					"Node at position (" + quad.n.pos.x + ", " + quad.n.pos.y + ") has data: " + quad.n.data.name);
		} else {
			System.out.println("Empty Node at position (" + quad.topLeft.x + ", " + quad.topLeft.y + ")");
		}
		System.out.println(quad.topLeftTree);
		traverseQuadTree(quad.topLeftTree);
		traverseQuadTree(quad.topRightTree);
		traverseQuadTree(quad.botLeftTree);
		traverseQuadTree(quad.botRightTree);
	}
}

public class ScreenNavigation2 {
	public static void main(String[] args) {
		Quad quadTree = new Quad(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
				new Point(Integer.MAX_VALUE, Integer.MAX_VALUE));
		Node a = new Node(new Point(-46, 77), new Board(0, 0, "Board1"));
		Node b = new Node(new Point(403, 284), new Board(0, 0, "Board2"));
		Node c = new Node(new Point(403, -205), new Board(0, 0, "Board3"));
		Node d = new Node(new Point(696, 165), new Board(0, 0, "Board4"));
		Node e = new Node(new Point(174, 699), new Board(0, 0, "Board5"));
		Node f = new Node(new Point(-497, 212), new Board(0, 0, "Board6"));
		quadTree.insert(a);
		quadTree.insert(b);
		quadTree.insert(c);
		quadTree.insert(d);
		quadTree.insert(e);
		quadTree.insert(f);

		Map<Integer, Node> boards = new HashMap<>();
		boards.put(1, a);
		boards.put(2, b);
		boards.put(3, c);
		boards.put(4, d);
		boards.put(5, e);
		boards.put(6, f);
		// System.out.println("Node a: " + quadTree.search(new Point(1, 1)).data);
		// System.out.println("Non-existing node: " + quadTree.search(new Point(5, 5)));

		// Scanner sc = new Scanner(System.in);
		// // System.out.println("Enter Direction: ");
		// // String direction = sc.nextLine();
		// // System.out.println("Enter Current Board Number: ");
		// // int currentBoardNumber = sc.nextInt();
		// // Node currentBoard = boards.get(currentBoardNumber);
		// // List<Node> result = new ArrayList<>();

		// switch (direction) {
		// case "left":
		// result = quadTree.queryRange(Integer.MIN_VALUE, currentBoard.pos.x,
		// Integer.MIN_VALUE,
		// currentBoard.pos.y, null);
		// break;

		// case "right":

		// break;
		// case "up":

		// break;
		// case "down":

		// break;
		// }
		// sc.close();

		quadTree.traverseQuadTree(quadTree);
	}
}
