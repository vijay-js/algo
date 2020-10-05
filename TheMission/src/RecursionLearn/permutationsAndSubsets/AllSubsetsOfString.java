package RecursionLearn.permutationsAndSubsets;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfString {

    public static List<String> globalList = new ArrayList<>();

    public static void main(String[] args) {

        List<String> subsets = PrintSubsets("ABC");

        System.out.println(subsets);
        RecursiveSubsets("ABC","",0);
    }


    public static List<String> PrintSubsets(String str) {
        List<String> subsets = new ArrayList<>();

        subsets.add("");

        for(int i=0;i<str.length();i++) {

            int subSetSize = subsets.size();

            for(int j=0;j<subSetSize;j++) {
                //get Current Subset and add this character of string
                String currentString = subsets.get(j);
                String newOne = currentString + str.charAt(i);
                subsets.add(newOne);
            }
        }

        return subsets;
    }

    public static void RecursiveSubsets(String str,String currentString, int index) {

        if(index == str.length()) {
            System.out.print(currentString + " ");
            return;
        }

            RecursiveSubsets(str,currentString,index+1);
            RecursiveSubsets(str,currentString+str.charAt(index),index+1);


    }



}
