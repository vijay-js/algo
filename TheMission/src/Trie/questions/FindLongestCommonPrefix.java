package Trie.questions;

//Given a set of strings, find the longest common prefix
//
//
// //https://www.geeksforgeeks.org/longest-common-prefix-using-trie/?ref=rp.
public class FindLongestCommonPrefix {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("ape");
        trie.insert("april");
//        trie.insert("geezer");
//        trie.insert("zoo");

        System.out.println(findCommonPrefix(trie.root,4,"apple"));
    }
    public static String findCommonPrefix(TrieNode root,int numWords,String word) {
        int answer =0;

        for(int i=0;i<word.length();i++) {
            if(isMoreThanOneChildNotNull(root)) {
                answer = i;
                break;
            }
            char c = word.charAt(i);
            int idx = c - 'a';
            if(root.children[idx] !=null) {
                if(root.children[idx].prefixCount < numWords) {
                    answer = root.children[idx].prefixCount;
                }
                root = root.children[idx];
            }
            else {
                break;
            }
        }
        return word.substring(0,answer);
    }

    public static boolean isMoreThanOneChildNotNull(TrieNode node) {
        int count = 0;
        for(int i=0;i<node.children.length;i++) {
            if(node.children[i] !=null) count++;
        }
        return count > 1;
    }
}
