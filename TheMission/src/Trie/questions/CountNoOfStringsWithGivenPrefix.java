package Trie.questions;

class TrieNode {
    char data;
    TrieNode children [] = new TrieNode[26];
    int prefixCount;
    boolean isWord;

    TrieNode() {
        this.prefixCount = 0;
    }
    TrieNode(char data) {
        this.data = data;
        this.prefixCount = 0;
        this.isWord = false;
    }


}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(c);
            }

            curr.prefixCount = curr.prefixCount + 1;
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public int getPrefixCount(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                return 0;
            }
            curr = curr.children[idx];
        }
        System.out.println(curr.prefixCount);
        return curr.prefixCount;
    }
}

public class CountNoOfStringsWithGivenPrefix {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("ball");
        trie.insert("bell");
        trie.insert("bat");
        trie.insert("geek");
        trie.insert("geeks");
        trie.insert("cat");
        trie.insert("cut");
        trie.insert("zoo");

        trie.getPrefixCount("m");

    }



}
