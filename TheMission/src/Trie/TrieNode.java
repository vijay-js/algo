package Trie;

public class TrieNode {
   public char data;
   public TrieNode[] children;
   public boolean isWord;

   TrieNode() {
        this.children = new TrieNode[26];
   }

   TrieNode(char data) {
       this.data = data;
       children = new TrieNode[26];
       isWord = false;
   }

}
