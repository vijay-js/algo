package RecursionLearn.permutationsAndSubsets.permutations;

import java.util.*;

public class subset1 {
    static Set<List<Integer>> set = new TreeSet<>();
    public static void main(String[] args) {
        int arr[] = new int[] {1,2,2};
        subset(arr,0,"");
        List<String> iter = subsetIter(arr);
        System.out.println(iter);


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetList(arr,0,temp,result);
        System.out.println(result);


        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        set.add(list);

        List<Integer> list1 = new ArrayList<>();

        list1.add(2);
        list1.add(1);

        set.add(list1);

        System.out.println(set);



    }

    public static void subset(int arr[],int index,String output) {
        if(index == arr.length) {
            System.out.print(output + " ");
            return;
        }

        subset(arr,index+1,output);
        subset(arr,index+1,output+arr[index]);
    }


    public static void subsetList(int arr[],int index, List<Integer> temp, List<List<Integer>> result) {
        if(index == arr.length) {

            result.add(new ArrayList<>(temp));
            return;
        }

        subsetList(arr,index+1,temp,result);
        temp.add(arr[index]);
        subsetList(arr,index+1,temp,result);
        temp.remove(temp.size()-1);

    }

//    public static void subsetListWithoutDups(int arr[],int index, List<Integer> temp, List<List<Integer>> result) {
//
//        if(index == arr.length) {
//            if(set.contains())
//            result.add(new ArrayList<>(temp));
//        }
//
//    }

    public static List<String> subsetIter(int arr[]) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        result.add("");

        while(idx < arr.length) {
            int size=result.size();
            for(int i=0;i<size;i++) {
                String s = result.get(i);
                String s1 = s+ arr[idx];
                result.add(s1);
            }
            idx++;
        }

        return result;
    }
}
