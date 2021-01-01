package BSTLearn;

public class Node {
     public Node left;
     public Node right;
     public int val;
     public Node nextRight;

     public Node() {

     }
    public Node(int val) {
        this.val = val;
        this.left= null;
        this.right = null;
        this.nextRight = null;
    }

    public Node(int val, Node left, Node right) {
        this(val);
        this.left = left;
        this.right = right;
        this.nextRight = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


}
