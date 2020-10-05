package BSTLearn;

public class BSTImpl {

    private Node head;

    private void Insert(Node head, int val) {

        if(head == null) {
            head = new Node(val);
            return;
        }

        if(val > head.getVal()) {
            Node newNode = new Node(val);
            if(head.getRight() !=null) {
                Insert(head.getRight(), val);
            }
            else {
                head.setRight(newNode);
                return;
            }

        }
        else  {
            Node newNode = new Node(val);
            if(head.getLeft() !=null) {
                Insert(head.getLeft(), val);
            }
            else {
                head.setLeft(newNode);
                return;
            }
        }

    }


    private Node InsertBetter(Node head, int val) {
        if(head == null) {
            head = new Node(val);
        }
        else if(val > head.getVal()) {
            head.setRight(InsertBetter(head.getRight(), val));
        }
        else {
            head.setLeft(InsertBetter(head.getLeft(),val));
        }
        return head;
    }

    private void InsertIter(Node head, int val) {
        Node temp = head;
        if(head == null) {
            head = new Node(val);
            return;
        }
        boolean notDone = true;
        while(notDone && temp!=null) {
            if(val > head.getVal()) {
                if(head.getRight() !=null) {
                    temp = temp.getRight();
                }
                else {
                    temp.setRight(new Node(val));
                    notDone = false;
                }
            }
            else {
                if(head.getLeft()!= null) {
                    temp = temp.getLeft();
                }
                else {
                    temp.setLeft(new Node(val));
                    notDone = false;
                }
            }
        }

    }

    private boolean Search(Node head, int val) {
        if(head == null) return false;
        else if(head.getVal() == val) return true;
        else if(val <= head.getVal()) return Search(head.getLeft(),val);
        else if(val > head.getVal()) return Search(head.getRight(),val);
        return false;
    }

    public void Print(Node head) {
        if(head != null) {
            System.out.print(head.getVal() + " ");
            Print(head.getLeft());
            Print(head.getRight());
        }
        else {
            return;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void log(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
            BSTImpl bst = new BSTImpl();
            BSTImpl bst1 = new BSTImpl();
            Node head = new Node(2);
            bst.setHead(head);
            bst.Insert(head,3);
            bst.Insert(head,1);
            bst.Insert(head,5);
            bst.Insert(head,0);
            bst.Print(head);

            Node head1 = null;
            bst1.setHead(head1);
            bst1.InsertBetter(head1,2);
            bst1.InsertBetter(head1,3);
            bst1.InsertBetter(head1,5);
            bst1.InsertBetter(head1,0);
            bst.Print(head);
    }
}