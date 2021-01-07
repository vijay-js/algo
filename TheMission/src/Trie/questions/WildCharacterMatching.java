package Trie.questions;


import java.util.ArrayList;
import java.util.List;

//. matches wild charatcer -> See if the pattern matches the words in the disctionary
public class WildCharacterMatching {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");

        trie.insert("cde");

        System.out.println(hasMatch(trie.root,"..e",0));
        System.out.println(search(trie.root,"..e"));
    }


    public static boolean hasMatch(TrieNode node, String s, int index) {
        if(node == null) return false;

        if(index == s.length()) return node.isWord;

        if(s.charAt(index) == '.') {
            for(int i=0;i<node.children.length;i++) {
                if(node.children[i] !=null) {
                    if(hasMatch(node.children[i],s,index +1)) return true;
                }
            }
        }
        else {
            int tempIndex = s.charAt(index) - 'a';
            return hasMatch(node.children[tempIndex],s,index +1);
        }

        return false;
    }

    public static boolean search(TrieNode node , String s) {
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if(c == '.') {
                for(int j=0;j<node.children.length;j++) {
                    if(node.children[j] !=null) {
                        if(search(node.children[j],s.substring(i+1))) return true;
                    }
                }
                return false;
            }

            if(node.children[idx] !=null) {
                node = node.children[idx];
            }
            else {
                return false;
            }
        }
        return node!=null && node.isWord;

    }

}
