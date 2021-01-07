package Trie;

import java.util.ArrayList;
import java.util.List;

public class TrieImplementationLearner {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("bat");
        trie.insert("geek");
        trie.insert("geeks");
        trie.insert("cat");
        trie.insert("cut");
        trie.insert("zoo");


        System.out.println(trie.search("bad"));
        System.out.println(trie.startsWith("zo"));
        List<String> answer = new ArrayList<>();
        trie.getAllWords(trie.root,"",answer);
//        trie.prefixSearch("cu");
        System.out.println(answer);
    }

}




