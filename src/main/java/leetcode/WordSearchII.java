package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 13/09/20
 * @project JavaProgramming
 */
public class WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    public static void dfs(char[][] board, int row, int col, TrieNode root, List<String> result){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] == '#' || root.children[board[row][col] - 'a'] == null){
            return;
        }
        char ch = board[row][col];
        root = root.children[ch - 'a'];
        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }

        board[row][col] = '#'; //change char to # to avoid revisiting
        dfs(board, row - 1, col ,root, result); //check in all directions
        dfs(board, row + 1, col,root, result);
        dfs(board, row, col - 1, root, result);
        dfs(board, row, col + 1, root, result);
        board[row][col] = ch; //restoring char after backtracking from # to char
    }

    public static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode temp = root;
            for(char ch : w.toCharArray()){
                if(temp.children[ch - 'a'] == null){
                    temp.children[ch - 'a'] = new TrieNode();
                }
                temp = temp.children[ch - 'a'];
            }
            temp.word = w;
        }
        return root;
    }

    public static void main(String[] s){
        System.out.println(findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"}));
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}
