class QuadTreeNode {
    double x, y;
    QuadTreeNode nw;
    QuadTreeNode ne;
    QuadTreeNode sw;
    QuadTreeNode se;
    String val;

    public QuadTreeNode(double x, double y, String val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public QuadTreeNode() {

    }
}

class QuadTree {
    QuadTreeNode root;
    double minX, minY, maxX, maxY; // boundary values

    public QuadTree(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }


//              (-)
//               N
//               |
//               |
//               |
//  (-)W_________|__________ E (+)
//               |
//               |
//               |
//               |
//               S
//              (+)

    public void insert(double x, double y, String val) {
        root = insert(root, x, y, val, minX, minY, maxX, maxY);
    }

    private QuadTreeNode insert(QuadTreeNode node, double x, double y, String val, double minX, double minY,
            double maxX, double maxY) {
        // if node is null, create a new leaf node
        if (node == null) {
            return new QuadTreeNode(x, y, val);
        }

        // otherwise, sub-divide
        double midX = (minX + (maxX - minX) / 2);
        double midY = (minY + (maxY - minY) / 2);
        System.out.println("minX: " + minX + " minY: " + minY + "\nmidx: " + midX + " midY: " + midY + "\nmaxX: " + maxX + " maxY: " + maxY);

        if (x < midX) {
            if (y < midY) {
                node.sw = insert(node.sw, x, y, val, minX, minY, midX, midY);
            } else {
                node.nw = insert(node.nw, x, y, val, minX, midY, midX, maxY);
            }
        } else {
            if (y < midY) {
                node.se = insert(node.se, x, y, val, midX, minY, maxX, midY);
            } else {
                node.ne = insert(node.ne, x, y, val, midX, midY, maxX, maxY);
            }
        }
        return node;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(QuadTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("(" + node.x + ", " + node.y + ") " + node.val);
        if (node.nw != null) {
            System.out.println("in nw");
            traverse(node.nw);
        }
        if (node.ne != null) {
            System.out.println("in ne");
            traverse(node.ne);
        }
        if (node.sw != null) {
            System.out.println("in sw");
            traverse(node.sw);
        }
        if (node.se != null) {
            System.out.println("in se");
            traverse(node.se);
        }
    }

}

public class QuadTreeDemo {
    public static void main(String[] args) {
        QuadTree qt = new QuadTree(Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

        qt.insert(182, 129, "Board1");
        qt.insert(36, 352.5, "Board2");
        qt.insert(-288, 465, "Board3");
        qt.insert(773, -458, "Board4");
        qt.insert(488, -234.5, "Board5");
        qt.insert(822, 129, "Board6");

        System.out.println("Quad Tree: ");
        qt.traverse();
    }
}