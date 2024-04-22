import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

class BinaryTree{
    static Scanner sc = new Scanner(System.in);
    
    void buildBinaryTree(Node root){
       

    }
     void binaryTreeUsingLevelOrderTraversal(Node root){
        System.out.println("Enter the value: ");
        int val = sc.nextInt();
        root = new Node(val);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("Enter the left value of node");
            val = sc.nextInt();
            if(val != -1){
                node.left = new Node(val);
                queue.add(node.left);
            }

            System.out.println("Enter the right value of node");
            val = sc.nextInt();
            if(val != -1){
                node.right = new Node(val);
                queue.add(node.right);
            }
        }
     }
}

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = null;
        BinaryTree bt = new BinaryTree();
        bt.binaryTreeUsingLevelOrderTraversal(root);

        
    }
}
