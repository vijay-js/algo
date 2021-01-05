package Heaps;

public class MinHeap {
    int [] arr;
    int capacity;
    int size;

    MinHeap(int c) {
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    public int left(int i) {
        return 2*i +1;
    }
    public int right(int i) {
        return 2*i + 2;
    }

    public int parent(int i) {
        return (i-1)/2;
    }

    public void Insert(int val) {
        if(size == capacity) {
            throw  new AssertionError("Already the size of array is full. Cant insert");
        }
        size++;
        arr[size -1] = val;

        for(int i=size-1;i !=0 && arr[parent(i)] > arr[i];) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
//        int index = size -1;
//        while(index >= 0) {
//            int parentIndex = parent(index) >=0 ? parent(index) : 0;
//            if(arr[index] < arr[parentIndex]) {
//                int temp = arr[parentIndex];
//                arr[parentIndex] = arr[index];
//                arr[index] = temp;
//                index = parentIndex;
//            }
//            else {
//                return;
//            }
//        }
    }


    public void swap(int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //Heapify at an index where heap property might be violated
    public void minHeapify(int i){

        if(i > size -1 || i < 0) {
            throw new Error("Invalid INdex");
        }

        int lt = left(i), rt = right(i);

        int smallest = i;

        if(lt < size && arr[lt] < arr[i]) {
            smallest = lt;
        }

        if(rt < size && arr[rt] < arr[i]) {
            smallest = rt;
        }
        if(smallest !=i) {
            swap(i,smallest);
            minHeapify(smallest);
        }


//        if(left(i) < size && arr[i] < arr[left(i)]) {
//            swap(i,left(i));
//            minHeapify(left(i));
//        }
//        if(right(i) < size &&  arr[i] < arr[right(i)]) {
//            swap(i,right(i));
//            minHeapify(right(i));
//        }
//        else {
//            return;
//        }

    }


    public int getMinimum() {
        if(size > 0) return arr[0];
        throw new Error("No values in heap");
    }

    public int extractMinimum() {
        if(size <= 0) throw new Error("No values in heap");

        if(size ==1) {
            size--;
            return arr[0];
        }
        //Swap with last element;
        swap(0,size-1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    //decrease key changes the value at index i to newVal which is less than the prev value
    public void decreaseKey(int i, int newVal) {

        arr[i] = newVal;

        for(int j=i;j!=0 && arr[parent(j)] > arr[j];) {
            swap(j,parent(j));
            j = parent(j);
        }
//
//        while(i!=0 && arr[parent(i) > arr[i]]) {
//            swap(i,parent(i));
//            i = parent(i);
//        }

    }

    //deletes at index
    public void deleteAtIndex(int i) {

        //Replace root with element to be deleted and call heapfiy on root
        arr[0] = arr[i];
        size--;
        minHeapify(0);



//        OR

//        decreaseKey(i,Integer.MIN_VALUE);
//        extractMinimum();

    }

    private void sizeReducer(int newSize) {
        this.size = newSize;
    }

    //Build Heap operation takes an array and converts to binary heap

    public void buildHeap(){
        for(int i=(size-2)/2;i>=0;i--)
            minHeapify(i);
    }
//    public void buildHeap(int arr[]) {
//        for(int i=1;i<arr.length;i++) {
//            this.arr = arr;
//            sizeReducer(i+1);
//            minHeapify(0);
//        }
//
//    }
}
