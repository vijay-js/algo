package BSTLearn;

public class PrintNodesAtKDistanceFromRoot {
    public static void main(String[] args) {

        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(100);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(90);
        int k = 1;
        printNodesAtK(bst.getHead(),k);

    }

    private static void printNodesAtK(Node head, int k) {
        printNodesAtKHelper(head,k,0);
    }

    private static void printNodesAtKHelper(Node head, int k , int depth) {
        if(head == null) return;
        if(depth == k) {
            System.out.print(head.val + " ");
        }
        printNodesAtKHelper(head.left,k, depth + 1);
        printNodesAtKHelper(head.right,k, depth + 1);
    }

}
