package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

import java.util.ArrayList;
import java.util.Collections;

public class LowestCommonAncestorOfTwoNodes {

    public static void main(String args[]) {

    }

    //Only 1 traversal required for efficient solution
    public static Node findLCAEfficient(Node head,int val1,int val2) {
        if(head == null) return null;

        if(head.val == val1 || head.val == val2) return head;

        Node leftLCA = findLCAEfficient(head.left,val1,val2);
        Node rightLCA = findLCAEfficient(head.right,val1,val2);


        if(leftLCA !=null && rightLCA!=null) return head;

        if(leftLCA !=null) return leftLCA;

        if(rightLCA !=null) return rightLCA;

        return null;
    }

    public static int findLCA1(Node head, Node node1, Node node2) {
        ArrayList<Integer> arrayList1= new ArrayList<>();
        ArrayList<Integer> arrayList2= new ArrayList<>();
        nodeToRootPath(head,node1.val,arrayList1);
        nodeToRootPath(head,node2.val,arrayList2);

        Collections.reverse(arrayList1);
        Collections.reverse(arrayList2);

        int  i;
        for( i=0;i<Math.min(arrayList1.size(),arrayList2.size());i++) {
            if(arrayList1.get(i) != arrayList2.get(i)) break;
        }

       if(i == 0) {
           throw new AssertionError("No common node");
       }
       return arrayList1.get(i-1);

    }

    //fills all the values from node to the root
    public static int nodeToRootPath(Node head,int val,ArrayList<Integer> arrayList) {
        if(head == null) return  -1;

        if(head.val == val) {
            arrayList.add(head.val);
            return 1;
        }
        int lh = nodeToRootPath(head.left,val,arrayList);
        int  rh = nodeToRootPath(head.right,val,arrayList);

        if(lh == 1|| rh == 1) {
            arrayList.add(head.val);
            return 1;
        }
        return -1;
    }


    public static int rootToNodePath(Node head, int val, ArrayList<Integer> arrayList) {
        if(head == null) return -1;

        arrayList.add(head.val);

        if(head.val == val) {
            return 1;
        }

        if(rootToNodePath(head.left,val,arrayList) == 1 || rootToNodePath(head.right,val,arrayList) == 1) {
            return 1;
        }
        arrayList.remove(arrayList.size() -1);
        return -1;
    }

}
