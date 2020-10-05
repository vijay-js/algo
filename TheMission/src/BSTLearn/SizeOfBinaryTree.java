package BSTLearn;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(15);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(9);
        bst.getHead().left.left.left = new Node(4);

        int h = findSize(bst.getHead());
        System.out.println(h);
    }

    private static int findSize(Node head) {
        if(head == null) return 0;

        return 1 + findSize(head.left) + findSize(head.right);

    }
}
