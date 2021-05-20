package RecursionLearn.permutationsAndSubsets.subsets;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfString {

    public static List<String> globalList = new ArrayList<>();

    public static void main(String[] args) {

        List<String> subsets = subsetsIterative("ABC");

        System.out.println(subsets);
       // RecursiveSubsets("ABC","",0);

        System.out.println();
        RecSubSets("ABC","");
    }



    public static void RecursiveSubsets(String str,String currentString, int index) {

        if(index == str.length()) {
            System.out.print(currentString + " ");
            return;
        }

            RecursiveSubsets(str,currentString,index+1);
            RecursiveSubsets(str,currentString+str.charAt(index),index+1);


    }

    public static void RecSubSets(String str, String output) {
        if(str.length() == 0) {
            System.out.print(output+ " ");
            return;
        }

        RecSubSets(str.substring(1),output+str.charAt(0));
        RecSubSets(str.substring(1),output);
    }


    public static List<String> subsetsIterative(String str) {
        List<String> result = new ArrayList<>();
        result.add("");
        if(str.isEmpty()) return result;

        while(!str.isEmpty()) {
            int size = result.size();
            for(int i=0;i<size;i++) {
                result.add(result.get(i)+str.charAt(0));
            }
            str = str.substring(1);
        }

        return result;
    }


}
