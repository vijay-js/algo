package RecursionLearn.permutationsAndSubsets.subsets;

public class PermnutationWithCaseChange {
    public static void main(String[] args) {
        genCaseChange("abc","");
        System.out.println();
        genCaseChangeWithDigits("a1B2","");
    }


    private static void genCaseChange(String str, String output) {
        if(str.length() ==0) {
            System.out.print(output + " ");
            return;
        }

        genCaseChange(str.substring(1),output+str.charAt(0));
        genCaseChange(str.substring(1),output+Character.toUpperCase(str.charAt(0)));
    }

    private static void genCaseChangeWithDigits(String str, String output) {
        if(str.length() ==0) {
            System.out.print(output + " ");
            return;
        }

        char currentChar = str.charAt(0);

        boolean isLetter = Character.isLetter(currentChar);

        if(isLetter) {
            genCaseChangeWithDigits(str.substring(1),output+Character.toLowerCase(currentChar));
            genCaseChangeWithDigits(str.substring(1),output+Character.toUpperCase(currentChar));

        }
        else {
            genCaseChangeWithDigits(str.substring(1),output+currentChar);
        }

    }
}
