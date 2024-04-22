import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
        left = null;
        right = null;
    }

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    static Node root;

    // BST CREATION
    public static Node insertNodeInBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data < val) {
            root.right = insertNodeInBST(root.right, val);
        } else {
            root.left = insertNodeInBST(root.left, val);
        }
        return root;
    }

    public static void createBST(Scanner sc) {
        System.out.println("Enter value to create BST");
        int val = sc.nextInt();

        while (val != -1) {
            root = insertNodeInBST(root, val);
            val = sc.nextInt();
        }
    }

    // BST TRAVERSAL

    // LEVEL ORDER TRAVERSAL
    public static void levelOrderTraversalBST(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Level Order Traversal of BST: ");

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    // PREORDER Traversal

    public static void preorderTraversalInBST(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversalInBST(root.left);
        preorderTraversalInBST(root.right);
    }

    // INORDER Traversal

    public static void inorderTraversalInBST(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversalInBST(root.left);
        System.out.print(root.data + " ");
        inorderTraversalInBST(root.right);
    }

    // POSTORDER Traversal

    public static void postorderTraversalInBST(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversalInBST(root.left);
        postorderTraversalInBST(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        root = null;
        Scanner sc = new Scanner(System.in);

        createBST(sc);
        levelOrderTraversalBST(root);

        // Inorder traversal of BST
        System.out.println("Inorder traversal of BST");
        inorderTraversalInBST(root);
        System.out.println();

        // Preorder traversal of BST
        System.out.println("Preorder traversal of BST");
        preorderTraversalInBST(root);
        System.out.println();

        // Postorder traversal of BST
        System.out.println("Postorder traversal of BST");
        postorderTraversalInBST(root);

        sc.close();
    }
}