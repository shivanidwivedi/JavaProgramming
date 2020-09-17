package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 17/09/20
 * @project JavaProgramming
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 */
public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }

    private static List<String> helper(String s, List<String> wordDict,
                                HashMap<String, List<String>> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if(s.length() == 0){
            result.add("");
            return result;
        }


        for(String word : wordDict){
            if(s.startsWith(word)){
                String sub = s.substring(word.length());
                List<String> substring = helper(sub, wordDict, memo);

                for(String current : substring){
                    String optionalSpace = current.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace +current);
                }
            }
        }
        memo.put(s, result);
        return result;
    }

    public static void main(String[] s){
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(wordBreak("catsanddog",list ));
    }
}
