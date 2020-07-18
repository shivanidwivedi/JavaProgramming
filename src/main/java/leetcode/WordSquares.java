package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 18/07/20
 * @project JavaProgramming
 *
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 *
 * Input:
 * ["area","lead","wall","lady","ball"]
 *
 * Output:
 * [
 *   [ "wall",
 *     "area",
 *     "lead",
 *     "lady"
 *   ],
 *   [ "ball",
 *     "area",
 *     "lead",
 *     "lady"
 *   ]
 * ]
 *
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * Example 2:
 *
 * Input:
 * ["abat","baba","atan","atal"]
 *
 * Output:
 * [
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atan"
 *   ],
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atal"
 *   ]
 * ]
 *
 * Time complexity: O(N⋅26 *L)
 * Space complexity: O(N⋅L)
 */
public class WordSquares {
    int N = 0;
    String[] words = null;
    HashMap<String, List<String>> map = null;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> result = new ArrayList<>();
        this.buildPrefixHashTable(words);

        for(String word: words){
            LinkedList<String> wordSquares = new LinkedList<>();
            wordSquares.addLast(word);
            this.backtracking(1, wordSquares,result);
        }
        return result;
    }

    private void buildPrefixHashTable(String[] words){
        this.map = new HashMap<>();
        for(String word : words){
            for(int i = 1; i < N; i++){
                String prefix = word.substring(0,i);
                List<String> wordList = this.map.get(prefix);
                if(wordList == null){
                    wordList = new ArrayList<>();
                    wordList.add(word);
                    this.map.put(prefix,wordList);
                }else{
                    wordList.add(word);
                }

            }
        }
    }

    private void backtracking(int step, LinkedList<String> wordSquares,
                              List<List<String>> result){
        if(step == N){
            result.add((List<String>) wordSquares.clone());
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for(String word: wordSquares){
            prefix.append(word.charAt(step));
        }

        for(String candidate : getWordsWithPrefix(prefix.toString())){
            wordSquares.addLast(candidate);
            this.backtracking(step + 1, wordSquares,result);
            wordSquares.removeLast();
        }
    }

    private List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = this.map.get(prefix);
        return (wordList != null ? wordList : new ArrayList<String>());
    }
}
