package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 08/04/20
 * @project JavaProgramming
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, String[] wordList) {
       //create hashset to store words in set
        HashSet<String> set = new HashSet(Arrays.asList(wordList));
        //if set doesnt contains endword return 0
        if (!set.contains(endWord)){
            return 0;
        }
        //BFS uses queue, so create a queue and add beginword
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            //loop through the queue
            for (int i = queue.size(); i > 0; i--) {
                //remove word from queue
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level++;
                }
                //loop through each character in a single word
                for (int j = 0; j < word.length(); j++) {
                   // convert word to character array to loop through each character
                    char[] newWord = word.toCharArray();
                    //check for all characters and replace one character at a time
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        newWord[j] = ch;
                        //convert the array to string
                        String checkWord = String.valueOf(newWord);
                        //check if the resulting word is present in set and it is not same as beginword
                        if (set.contains(checkWord) && !checkWord.equals(word)){
                            //add it to the queue
                            queue.add(checkWord);
                            //remove it from the Hashset
                            set.remove(checkWord);
                        }
                    }
                }

            }
            level++;
        }
        return 0;
    }
}
