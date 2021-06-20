package BSTLearn.BFS;

import BSTLearn.Node;

import java.util.*;

class NodeWithHeight {
    Node node;
    int height;

    NodeWithHeight(Node node,int height) {
        this.node = node;
        this.height =height;
    }

}

public class BottomView {
    public static void main(String[] args) {

    }


    public static void printBottomView(Node head) {

        if(head == null) return;

        Queue<NodeWithHeight> queue = new LinkedList<>();

        //Here we do not need to
        TreeMap<Integer, List<Node>> map = new TreeMap<>();

        queue.add(new NodeWithHeight(head,0));

        while(!queue.isEmpty()) {

            NodeWithHeight curr = queue.poll();
            int height = curr.height;

            map.getOrDefault(height,new ArrayList<>()).add(curr.node);

            if(curr.node.left!=null) {
                queue.add(new NodeWithHeight(curr.node.left,height -1));
            }

            if(curr.node.right!=null) {
                queue.add(new NodeWithHeight(curr.node.right,height +1));
            }

        }

      for(Map.Entry<Integer,List<Node>> entry : map.entrySet()) {
          List<Node> list = entry.getValue();
          for(int i=0;i<list.size();i++) {
              if(i == list.size() -1) {
                  System.out.print(list.get(i).val + " ");
              }
          }
      }
    }
}
