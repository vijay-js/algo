package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
   public TrieNode root;

   Trie() {
       this.root = new TrieNode();
   }


   public void insert(String word) {
       TrieNode curr = root;
       for(int i=0;i<word.length();i++) {
           char c = word.charAt(i);
           int id = c - 'a';
           if(curr.children[id] == null) {
               TrieNode node = new TrieNode(c);
               curr.children[id] = node;
           }
           curr = curr.children[id];
       }
       curr.isWord = true;
   }

   public void insertRecursion(TrieNode head, String word, int i) {
           char c = word.charAt(i);
           if(head.children[c-'a'] == null) {
               head.children[c-'a'] = new TrieNode(c);
               if(i==word.length() -1) {
                   head.isWord = true;
                   return;
               }
           }
           insertRecursion(head.children[c-'a'],word,i+1);
   }

   public boolean search(String word) {
       TrieNode curr = root;
       for(int i=0;i<word.length();i++) {
           char c = word.charAt(i);
           if(curr.children[c-'a'] == null) {
               return false;
           }
           else {
               curr = curr.children[c-'a'];
           }
       }
       return curr.isWord;
   }

   public boolean startsWith(String word) {
       TrieNode curr = root;

       for(int i=0;i<word.length();i++) {
           char c = word.charAt(i);

           if(curr.children[c-'a'] == null) {
               return false;
           }
           else {
               curr = curr.children[c-'a'];
           }
       }
       return true;
   }

   public void prefixSearch(String word) {
       List<String> answer = new ArrayList<>();
       TrieNode curr = root;
       String temp= "";
       for(int i=0;i<word.length();i++) {
           char c = word.charAt(i);
           if(curr.children[c-'a'] == null) {
               return ;
           }
           else {
               curr = curr.children[c-'a'];
               temp = temp + c;
           }
       }
       if(curr.isWord) answer.add(temp);

       TrieNode prefixNode = curr;

       getAllWordsWithStartNode(prefixNode,temp,answer);
   }



   private void getAllWordsWithStartNode(TrieNode node, String s, List<String> result) {
       if(node == null) return;
       s = s + node.data;
       if(node.isWord) {
           System.out.println(s);
           result.add(s);
       }
       for(int i=0;i<node.children.length;i++) {
           getAllWordsWithStartNode(node.children[i],s,result);
       }
   }

   public void getAllWords(TrieNode node, String s, List<String> result) {
        if(node == null) {
            return;
        }
        if(node.isWord) result.add(s);
        for(int i=0;i<node.children.length;i++) {
            if(node.children[i] !=null) {
                getAllWords(node.children[i],s + node.children[i].data, result);
            }
        }
   }
}
