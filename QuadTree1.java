import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}

class QuadTreeNode {
    Point topLeft;
    Point botRight;
    List<Point> points; // Stores the coordinates of points
    QuadTreeNode[] children;
    int CAPACITY = 10; // Adjust capacity as needed

    QuadTreeNode(Point topLeft, Point botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
        this.points = new ArrayList<>();
        this.children = new QuadTreeNode[4];
    }

    public boolean inBoundary(Point p) {
        return (p.x >= topLeft.x && p.x <= botRight.x && p.y >= topLeft.y && p.y <= botRight.y);
    }

    public void insert(Point p) {
        if (!inBoundary(p)) {
            System.out.println("Not in boundary");
            return; // Ignore points outside the boundary
        }

        if (points.size() < CAPACITY) {
            System.out.println("Not in Capacity");
            points.add(p);
            return;
        }

        if (children[0] == null) {
            subdivide();
        }

        // Insert the point into the appropriate quadrant
        for (QuadTreeNode child : children) {
            if (child.inBoundary(p)) {
                child.insert(p);
                return;
            }
        }
    }

    private void subdivide() {
        int midX = (topLeft.x + botRight.x) / 2;
        int midY = (topLeft.y + botRight.y) / 2;

        children[0] = new QuadTreeNode(topLeft, new Point(midX, midY));
        children[1] = new QuadTreeNode(new Point(midX, topLeft.y), new Point(botRight.x, midY));
        children[2] = new QuadTreeNode(new Point(topLeft.x, midY), new Point(midX, botRight.y));
        children[3] = new QuadTreeNode(new Point(midX, midY), botRight);

        // Distribute existing points to children
        for (Point point : points) {
            for (QuadTreeNode child : children) {
                if (child.inBoundary(point)) {
                    child.insert(point);
                    break;
                }
            }
        }
        points.clear(); // Clear the points from the current node after distribution
    }

    public void traverse() {
        if (!points.isEmpty()) {
            System.out.println("Points at this node: " + points);
            return;
        }
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                children[i].traverse();
            }
        }
    }
}

public class QuadTree1 {
    QuadTreeNode root;

    public QuadTree1() {
        this.root = new QuadTreeNode(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), new Point(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public void insert(Point p) {
        root.insert(p);
    }

    public void traverse() {
        root.traverse();
    }

    public static void main(String[] args) {
        QuadTree1 qt = new QuadTree1();
        // Inserting nodes
        qt.insert(new Point(-46, 77));
        qt.insert(new Point(403, 284));
        qt.insert(new Point(403, -205));
        qt.insert(new Point(696, 165));
        qt.insert(new Point(174, 699));
        qt.insert(new Point(-497, 212));

        // Traversing the QuadTree to print the points
        qt.traverse();
    }
}