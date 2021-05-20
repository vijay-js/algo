package Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Testfgsfgsd {

    static  Map<String,String> symbolMap = new HashMap<>();

    public static void main(String[] args) {

        symbolMap.put("&quot;","\\\"");
        symbolMap.put("&apos;","\'");
        symbolMap.put("&amp;","&");
        symbolMap.put("&gt;",">");
        symbolMap.put("&lt;","<");
        symbolMap.put("&frasl;","/");

        String out = entityParser("&amp;amp;");
        System.out.println(out);

    }

    public static  String entityParser(String text) {

        Stack<Character> st = new Stack<>();
        StringBuilder output = new StringBuilder();
        boolean wordStarted = false;

        for(int i=0;i<text.length();i++) {
            Character current = text.charAt(i);
            if( current == '&') {
                if(wordStarted) {
                    //pop everything out of stack and reverse the string and append to final string and insert current & into stack
                    String str = stringFromStack(st);
                    if(str.length() > 0) {
                        output.append(current);
                    }
                }
                wordStarted = true;
                st.push(current);

            }
           else if( current == ';') {
                if(wordStarted) {
                    //Pop everything out and reverse the string
                    st.push(current);
                    String str = stringFromStack(st);
                    if(symbolMap.get(str) !=null) {
                        output.append(symbolMap.get(str));

                    }
                    else {
                        output.append(str);
                    }
                    wordStarted = false;
                }
                else {
                    output.append(current);
                }
           }
           else {
               if(wordStarted) {
                   st.push(current);
               }
               else {
                   output.append(current);
               }
            }

        }

        String pending = stringFromStack(st);

        if(pending.length() > 0) {
            output.append(pending);
        }
        return output.toString();

    }


    private static String stringFromStack(Stack<Character> st) {
        StringBuilder out = new StringBuilder();
        while(!st.isEmpty()) {
            out.append(st.pop());
        }
        return out.reverse().toString();
    }
}
