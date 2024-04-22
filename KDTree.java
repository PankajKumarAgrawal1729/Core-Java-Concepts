import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Node {
    int[] point;
    Node left;
    Node right;

    public Node(int[] point, Node left, Node right) {
        this.point = point;
        this.left = left;
        this.right = right;
    }
}

public class KDTree {
    public static Node buildKDTree(List<int[]> points, int depth) {
        if (points.isEmpty()) {
            return null;
        }

        int k = points.get(0).length; // dimensionality of points
        int axis = depth % k;

        points.sort(Comparator.comparingInt(a -> a[axis]));
        int median = points.size() / 2;

        return new Node(
                points.get(median),
                buildKDTree(points.subList(0, median), depth + 1),
                buildKDTree(points.subList(median + 1, points.size()), depth + 1)
        );
    }

    public static Node insertNode(Node root, int[] point, int depth) {
        if (root == null) {
            return new Node(point, null, null);
        }

        int k = point.length;
        int axis = depth % k;

        if (point[axis] < root.point[axis]) {
            root.left = insertNode(root.left, point, depth + 1);
        } else {
            root.right = insertNode(root.right, point, depth + 1);
        }

        return root;
    }

    public static List<int[]> queryRange(Node root, int xMin, int xMax, int yMin, int yMax, int depth) {
        List<int[]> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        int k = root.point.length;
        int axis = depth % k;

        if (xMin <= root.point[0] && root.point[0] <= xMax && yMin <= root.point[1] && root.point[1] <= yMax) {
            result.add(root.point);
        }

        if (axis == 0) {
            if (xMin <= root.point[0]) {
                result.addAll(queryRange(root.left, xMin, xMax, yMin, yMax, depth + 1));
            }
            if (xMax > root.point[0]) {
                result.addAll(queryRange(root.right, xMin, xMax, yMin, yMax, depth + 1));
            }
        } else {
            if (yMin <= root.point[1]) {
                result.addAll(queryRange(root.left, xMin, xMax, yMin, yMax, depth + 1));
            }
            if (yMax > root.point[1]) {
                result.addAll(queryRange(root.right, xMin, xMax, yMin, yMax, depth + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<int[]> points = new ArrayList<>();
        points.add(new int[]{2, 3});
        points.add(new int[]{5, 4});
        points.add(new int[]{9, 6});
        points.add(new int[]{4, 7});
        points.add(new int[]{8, 1});
        points.add(new int[]{7, 2});

        Node root = buildKDTree(points, 0);

        // Insert a new point
        int[] newPoint = new int[]{3, 5};
        root = insertNode(root, newPoint, 0);

        // Query points within a range
        List<int[]> result = queryRange(root, 2, 6, 3, 7, 0);
        System.out.println("Points within range:");
        for (int[] point : result) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}

