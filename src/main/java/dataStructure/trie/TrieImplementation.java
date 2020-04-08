package dataStructure.trie;

import leetcode.Trees.TreeNode;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 * TRIE IMPLEMENTATION
 * TC: O(l*n) l=average length of words n= total no of words
 */
public class TrieImplementation {
    private static TrieNode root;
    public TrieImplementation(){
        root = new TrieNode();
    }
    /**
    Insert into trie - iterative
     **/
    public static void insert(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (current == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }


    /**
     Insert into trie - Recursive
     **/
    public static void insertRecursively(String word){
        insertRecursively(root,word,0);
    }
    private static void insertRecursively(TrieNode current, String word, int index){
        if (index == word.length()){
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (current == null){
            node = new TrieNode();
            current.children.put(ch,node);
        }
        insertRecursively(current,word,index + 1);
    }
}
