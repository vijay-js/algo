package BSTLearn.traversals.questions.binarysearchtree;

public class FindKthSmallest {

   static class Node {
        int val;
        Node left;
        Node right;
        int lCount;//Left Side Leaves Count

       Node(int val) {
           this.val = val;
           this.lCount = 0;
       }

       Node(int val,int lCount) {
           this.val = val;
           this.lCount = lCount;
       }

       Node() {}
    }

    static class BST {
        Node head;
    }

    public static void main(String args[]) {
        BST bst = new BST();
        Node head = new Node(12);
        bst.head = head;
        head.left = new Node(10);
        head.right = new Node(18);

        head.left.left = new Node(8);
        head.left.right = new Node(11);

        head.left.left.left = new Node(6);
        head.left.left.right = new Node(9);

        head.right.left = new Node(14);

        head.right.right = new Node(22);

        head.right.right.left = new Node(20);
        head.right.right.right = new Node(24);

        fillLCounts(head);
        printNodesInOrderWithLeftCount(head);
        System.out.println();

        findKthSmallest(head,3);

        System.out.println();

        findRank(head,24);
    }


    public static int fillLCounts(Node head) {

       if(head == null) return 0;

       int leftNodes = fillLCounts(head.left);
       int rightNodes = fillLCounts(head.right);
       head.lCount = leftNodes;

       return 1 + leftNodes + rightNodes;

    };


   public static void printNodesInOrderWithLeftCount(Node head) {
       if(head == null) return;

       printNodesInOrderWithLeftCount(head.left);
       System.out.print("[ "+head.val+", "+ head.lCount+" ]");
       printNodesInOrderWithLeftCount(head.right);
   }

   public static void findKthSmallest(Node head, int k) {
       if(head == null) return;

       Node current = head;

       while(current !=null) {
           if(current.lCount + 1 == k) {
               System.out.println(current.val);
               return;
           }
           if(current.lCount + 1 > k) {
               current = current.left;
           }
           else {
               k = k - current.lCount - 1;
               current = current.right;

           }
       }

   }

   public static int findRank(Node head, int val) {
       if(head == null) {
           return 0;
       }
       int rank = 0;
       Node current = head;
       while(current!=null) {
           if(current.val == val) {
               System.out.println(rank+1);
               return rank + 1;
           }
           else if(val> current.val) {
               rank = rank + current.lCount + 1;
               current = current.right;
           }
           else {
               current = current.left;
           }
       }
       System.out.println(rank);
       return rank;
   }


    public static Node InsertWithLcountUpdated(Node head, int val) {
       if(head == null) {
           return new Node(val,0);
       }
       Node prev = null, current = head;

       while(current != null) {
           prev = current;
           if(val > head.val) {
               current = current.right;
           }
           else if(val < head.val) {
               current.lCount = current.lCount + 1;
               current = current.left;
           }
           else {
               return head;
           }
       }

       if(val > prev.val) {
           prev.right = new Node(val,0);
       }
       else {
           prev.left = new Node(val, 0);
       }

       return head;
    }

    public static Node InsertWithLCountRecursive(Node head , int val) {
       if(head == null) {
           return new Node(val,0);
       }
       if(val > head.val) {
           head.right = InsertWithLCountRecursive(head.right,val);
       }
       else {
           head.lCount = head.lCount + 1;
           head.left = InsertWithLCountRecursive(head.left,val);
       }
       return head;
    }


}
