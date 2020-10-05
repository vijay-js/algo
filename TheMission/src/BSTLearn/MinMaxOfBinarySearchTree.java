package BSTLearn;

public class MinMaxOfBinarySearchTree {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(15);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(9);
        int min = findMinRec(bst.getHead());
        int max = findMax(bst.getHead());
        System.out.println(min + " " + max);
    }


    private static int findMin(Node head) {
        if(head == null) {
            return -1;
        }
        Node temp = head;

        while(temp.left != null) {
            temp = temp.left;
        }
        return temp.val;
    }

    private static int findMinRec(Node head) {
        if(head == null) {
            return -1;
        }
        if(head.left == null) return head.val;
        else return findMinRec(head.left);
    }

    private static int findMax(Node head) {
        if(head == null) {
            return -1;
        }
        Node temp = head;

        while(temp.right != null) {
            temp = temp.right;
        }
        return temp.val;
    }
}
