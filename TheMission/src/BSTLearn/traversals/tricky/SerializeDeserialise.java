package BSTLearn.traversals.tricky;

import BSTLearn.Node;

import java.util.List;

public class SerializeDeserialise {
    static int index =0;
    public static void main(String[] args) {

    }


    //Here we are traversing the tree in PreOrder Manner
    //We can traverse in any order just that both serialize and deserialize should have the
    public static void serialize(Node head, List<Integer> list) {

        if(head == null) {
            list.add(Integer.MIN_VALUE);
            return;
        }

        list.add(head.val);
        serialize(head.left,list);
        serialize(head.right,list);


    }

    //8,3,1, NULL

    public static Node deserialize(List<Integer> list) {
        if(list.get(index) == Integer.MIN_VALUE) {
            return null;
        }
        Node head = new Node(list.get(index++));
        head.left = deserialize(list);
        head.right = deserialize(list);

        return head;
    }
}
