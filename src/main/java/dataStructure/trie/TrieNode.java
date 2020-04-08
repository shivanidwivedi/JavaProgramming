package dataStructure.trie;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 */
public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

     TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}
