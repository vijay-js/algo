/*
       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6

* */

package BSTLearn.BFS;
import java.util.*;



public class TopView {
    private static class Node {
        int val;
        Node right;
        Node left;
        int vh;

        public Node(int val) {
            this.val = val;
            this.vh  =0;
            this.right = null;
            this.left = null;
        }
    }
    private static class BST {
        Node root;

        BST(Node root) {
            this.root = root;
        }
        BST(int val) {
            this.root = new Node(val);
        }
    }
    public static void main(String[] args) {
        BST bst = new BST(1);
        Node root = bst.root;
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);



        printTopView(root);
    }


    public static void printTopView(Node head) {

        if(head == null) return;
        Queue<Node> queue = new LinkedList<>();
        //Map of Height,Node
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        head.vh = 0;
        queue.add(head);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                Node curr = queue.poll();
                int height = curr.vh;

                if(!map.containsKey(height)) {
//                    System.out.print(curr.val +" ");
                    List<Node> list= new ArrayList<>();
                    list.add(curr);
                    map.put(height,list);
                }

                if(curr.left !=null) {
                    curr.left.vh = height -1;
                    queue.add(curr.left);
                }
                if(curr.right !=null) {
                    curr.right.vh = height + 1;
                    queue.add(curr.right);
                }

            }
        }

        //This is needed for printing in order of appearance from top

       for(Map.Entry<Integer,List<Node>> entry : map.entrySet()) {
                System.out.print(entry.getValue().get(0).val +" ");
       }


    }
}
