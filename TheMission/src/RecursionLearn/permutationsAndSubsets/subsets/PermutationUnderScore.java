package RecursionLearn.permutationsAndSubsets.subsets;

import java.util.ArrayList;
import java.util.List;

//Add Underscores
public class PermutationUnderScore {
    public static void main(String[] args) {

        //Output
        //A_BC,AB_C,ABC,A
        withSpaces("ABC,","",1);

        List<String> result = withSpacesIterative("ABC");

        System.out.println();
        System.out.println(result);
        withSpaces2("BC","A");
    }


    private static void withSpaces(String str, String output,int index) {

        if(index == str.length()-1) {
            System.out.print(output + " ");
            return;
        }

        withSpaces(str,str.substring(0,index)+"_"+str.substring(index),index+1);
        withSpaces(str,str,index+1);
    }


    private static void withSpaces2(String str, String output) {
        if(str.length() ==0) {
            System.out.print(output + " ");
            return;
        }

        withSpaces2(str.substring(1),output+"_"+str.charAt(0));
        withSpaces2(str.substring(1),output+str.charAt(0));
    }

    private static List<String> withSpacesIterative(String str) {
        List<String> ans = new ArrayList<>();
        ans.add(str);

        int index = 1;
        while (index < str.length()) {
           int size = ans.size();

           for(int i=0;i<size;i++) {
               ans.add(str.substring(0,index)+"_"+str.substring(index));
           }
           index++;
        }
        return ans;
    }



}
