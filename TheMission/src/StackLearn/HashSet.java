package StackLearn;

class HashSet {
    final int bucket_size = 1000;
    Node[] buckets;
    /** Initialize your data structure here. */
    public HashSet() {
        buckets = new Node[bucket_size];
    }

    public void add(int key) {
        int bucketNumber = key%bucket_size;

        if(buckets[bucketNumber] == null) {
            Node n = new Node(key);
            buckets[bucketNumber] = n;
        }
        else {
            if(!contains(key)) {
                Node head = buckets[bucketNumber];
                Node newNode = new Node(key);
                newNode.next = head;
                buckets[bucketNumber] = newNode;
            }
        }

    }

    public void remove(int key) {
        int bucketNumber = key%bucket_size;
        if(buckets[bucketNumber] == null) {
            return;
        }

        if(contains(key)) {
            Node head = buckets[bucketNumber];
            if(head.val == key) {
                buckets[bucketNumber] = head.next;
                return;
            }
            Node prev = head;
            Node current = head.next;
            while(current!=null) {
                if(current.val == key) {
                    prev.next = current.next;
                }
                prev = current;
                current = current.next;
            }
        }


    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketNumber = key%bucket_size;

        if(buckets[bucketNumber] == null) {
            return false;
        }
        else {
            Node head = buckets[bucketNumber];
            return head.isPresent(head,key);
        }

    }

    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
            next = null;
        }

        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }

        public boolean isPresent(Node head, int val) {
            while(head !=null) {
                if(head.val == val) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        HashSet obj = new HashSet();
        obj.add(1);
        obj.add(2);
        obj.contains(2);

    }
}

/**
 * Your HashSet object will be instantiated and called as such:
 * HashSet obj = new HashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */