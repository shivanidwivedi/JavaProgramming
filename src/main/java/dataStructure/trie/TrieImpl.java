package dataStructure.trie;

/**
 * @author shivanidwivedi on 27/07/20
 * @project JavaProgramming
 */
public class TrieImpl {
    private TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }
    //inserts a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.children.get(c) == null){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }
    //search a word in the trie
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.children.get(c) == null){
                return false;
            }else{
                current = current.children.get(c);
            }
        }
        return current.endOfWord;
    }
    //search for the prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(current.children.get(c) == null){
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}
