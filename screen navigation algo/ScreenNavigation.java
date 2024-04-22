
import java.util.ArrayList;
import java.util.List;

class Point {
    double x, y;
    String name;

    public Point(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}

class QuadTreeNode {
    double xMin, xMax, yMin, yMax;
    List<Point> points;
    QuadTreeNode[] children;

    public QuadTreeNode(double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.points = new ArrayList<>();
        this.children = new QuadTreeNode[4];
    }
}

class QuadTree {
    QuadTreeNode root;

    public QuadTree(double xMin, double xMax, double yMin, double yMax) {
        root = new QuadTreeNode(xMin, xMax, yMin, yMax);
    }

    public boolean insert(Point point, QuadTreeNode node) {
        if (point.x < node.xMin || point.x > node.xMax || point.y < node.yMin || point.y > node.yMax)
            return false; // Point does not belong to this node's region

        if (node.points.size() < 4 && node.children[0] == null) {
            node.points.add(point);
            return true;
        }

        double xMid = (node.xMin + node.xMax) / 2;
        double yMid = (node.yMin + node.yMax) / 2;
        int childIndex = (point.x > xMid ? 1 : 0) + (point.y > yMid ? 2 : 0);

        if (node.children[childIndex] == null) {
            // If child node does not exist, create it
            if (childIndex == 0)
                node.children[childIndex] = new QuadTreeNode(node.xMin, xMid, node.yMin, yMid);
            else if (childIndex == 1)
                node.children[childIndex] = new QuadTreeNode(xMid, node.xMax, node.yMin, yMid);
            else if (childIndex == 2)
                node.children[childIndex] = new QuadTreeNode(node.xMin, xMid, yMid, node.yMax);
            else // childIndex == 3
                node.children[childIndex] = new QuadTreeNode(xMid, node.xMax, yMid, node.yMax);
        }

        return insert(point, node.children[childIndex]);
    }

    public boolean insert(Point point) {
        return insert(point, root);
    }

    public List<Point> queryRange(double xMin, double xMax, double yMin, double yMax, QuadTreeNode node) {
        List<Point> result = new ArrayList<>();

        if (node == null)
            return result;

        if (xMax < node.xMin || xMin > node.xMax || yMax < node.yMin || yMin > node.yMax)
            return result;

        for (Point point : node.points) {
            if (point.x >= xMin && point.x <= xMax && point.y >= yMin && point.y <= yMax)
                result.add(point);
        }

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

    public List<Point> queryRange(double xMin, double xMax, double yMin, double yMax) {
        return queryRange(xMin, xMax, yMin, yMax, root);
    }

    public void traverse(QuadTreeNode node) {
        if (node == null)
            return;

        // Print points in this node
        System.out.println("Node Points:");
        for (Point point : node.points) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }

        // Traverse child nodes
        for (QuadTreeNode child : node.children) {
            traverse(child);
        }
    }

}

public class ScreenNavigation {

    public static void main(String[] args) {
        QuadTreeDemo quadTree = new QuadTreeDemo(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Insert points
        quadTree.insert(new Point(-46, 77, "Board1"));
        quadTree.insert(new Point(403, 284, "Board2"));
        quadTree.insert(new Point(403, -205, "Board3"));
        quadTree.insert(new Point(696, 165, "Board4"));
        quadTree.insert(new Point(174, 699, "Board5"));
        quadTree.insert(new Point(-497, 212, "Board6"));

        // Query points within a range
        // List<Point> result = quadTree.queryRange(2, 6, 3, 7);
        // System.out.println("Points within range:");
        // for (Point point : result) {
        // System.out.println("(" + point.x + ", " + point.y + ")");
        // }
        quadTree.traverse(quadTree.root);
    }

}

