package Trie.questions;


import java.util.ArrayList;
import java.util.List;

public class AutoCompleteUsingTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("ab");
        trie.insert("abd");
        trie.insert("abb");
        trie.insert("bcd");
        trie.insert("cde");

        List<String> answer = new ArrayList<>();

        String prefix = "b";
        int numSuggestions = 4;

        TrieNode prefixNode = getPrefixNode(trie.root,prefix);
        if(prefixNode == null) {
            System.out.println("Unable to find any suggestions with that prefix");
        }
        else {
            getTopSuggestions(prefixNode,prefix,answer,numSuggestions);
        }

        System.out.println(answer);

    }

    public static TrieNode getPrefixNode(TrieNode head, String prefix) {
        TrieNode curr = head;

        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] != null) {
                curr = curr.children[idx];
            }
            else {
                return null;
            }
        }
        return curr;
    }

    public static void getTopSuggestions(TrieNode node, String s, List<String> result,int numSuggestions) {
        if(result.size() == numSuggestions) {
            return;
        }
        if(node.isWord ) {
            result.add(s);
        }

        for(int i=0;i<node.children.length;i++) {
            if(node.children[i] !=null && numSuggestions > result.size()) {
                getTopSuggestions(node.children[i],s+node.children[i].data,result,numSuggestions);
            }
        }

    }
}
