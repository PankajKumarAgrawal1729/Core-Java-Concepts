import java.util.ArrayList;
import java.util.List;

/*
 *  			N
 *  		W		E
 *  			S
 */

class Node {
    double x, y;
    String value;

    Node(double x, double y, String value) {
        this.x = x;
        this.y = y;
        this.value = value; /* some data */
    }
}

/* Using two podoubles of Rectangular (Top,Left) & (Bottom , Right) */
class Boundry {
    public double getxMin() {
        return xMin;
    }

    public double getyMin() {
        return yMin;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public Boundry(double xMin, double yMin, double xMax, double yMax) {
        super();
        /*
         * Storing two diagonal podoubles
         */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(double x, double y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    double xMin, yMin, xMax, yMax;

}

public class QuadTreeDemoGit {
    final double MAX_CAPACITY = 4;
    double level = 0;
    List<Node> nodes;
    QuadTreeDemoGit northWest = null;
    QuadTreeDemoGit northEast = null;
    QuadTreeDemoGit southWest = null;
    QuadTreeDemoGit southEast = null;
    Boundry boundry;

    QuadTreeDemoGit(double level, Boundry boundry) {
        this.level = level;
        nodes = new ArrayList<Node>();
        this.boundry = boundry;
    }


    /* Traveling the Graph using Depth First Search */
    public void dfs(QuadTreeDemoGit tree) {
        if (tree == null)
            return;

        // System.out.printf("\nLevel = %.2f [X1=%.2f Y1=%.2f] \t[X2=%.2f Y2=%.2f] ",
        // tree.level, tree.boundry.getxMin(), tree.boundry.getyMin(),
        // tree.boundry.getxMax(), tree.boundry.getyMax());
        System.out.printf("\nLevel = %.2f", tree.level);

        for (Node node : tree.nodes) {
            System.out.println(" \n\t  x= " + node.x + " y= " + node.y);
        }
        if (tree.nodes.size() == 0) {
            System.out.printf(" \n\t  Leaf Node.");
        }
        dfs(tree.northWest);
        dfs(tree.northEast);
        dfs(tree.southWest);
        dfs(tree.southEast);

    }

    void split() {
        double xOffset = this.boundry.getxMin()
                + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
        double yOffset = this.boundry.getyMin()
                + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        northWest = new QuadTreeDemoGit(this.level + 1, new Boundry(
                this.boundry.getxMin(), this.boundry.getyMin(), xOffset,
                yOffset));
        northEast = new QuadTreeDemoGit(this.level + 1, new Boundry(xOffset,
                this.boundry.getyMin(), xOffset, yOffset));
        southWest = new QuadTreeDemoGit(this.level + 1, new Boundry(
                this.boundry.getxMin(), xOffset, xOffset,
                this.boundry.getyMax()));
        southEast = new QuadTreeDemoGit(this.level + 1, new Boundry(xOffset, yOffset,
                this.boundry.getxMax(), this.boundry.getyMax()));

    }

    void insert(double x, double y, String value) {
        if (!this.boundry.inRange(x, y)) {
            return;
        }

        Node node = new Node(x, y, value);
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        // Exceeded the capacity so split it in FOUR
        if (northWest == null) {
            split();
        }

        // Check coordinates belongs to which partition
        if (this.northWest.boundry.inRange(x, y))
            this.northWest.insert(x, y, value);
        else if (this.northEast.boundry.inRange(x, y))
            this.northEast.insert(x, y, value);
        else if (this.southWest.boundry.inRange(x, y))
            this.southWest.insert(x, y, value);
        else if (this.southEast.boundry.inRange(x, y))
            this.southEast.insert(x, y, value);
        else
            System.out.printf("ERROR : Unhandled partition %.2f %.2f", x, y);
    }

    public static void main(String args[]) {
        QuadTreeDemoGit anySpace = new QuadTreeDemoGit(1,
                new Boundry(Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
        anySpace.insert(182, 129, "Board1");
        anySpace.insert(38, 352.5, "Board2");
        anySpace.insert(288, 465, "Board3");
        anySpace.insert(773, 458, "Board4");
        anySpace.insert(488, 234.5, "Board5");
        anySpace.insert(822, 129, "Board6");
        anySpace.insert(-234, -52, "Board7");
        anySpace.insert(-309, 343, "Board8");
        anySpace.insert(-794, 340, "Board9");
        anySpace.insert(-672, -609, "Board10");
        anySpace.insert(-171, -329, "Board11");
        anySpace.insert(-1587, -270, "Board12");
        anySpace.insert(-1458, -961, "Board13");
        // Traveling the graph
        anySpace.dfs(anySpace);
    }
}