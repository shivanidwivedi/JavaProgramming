package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 19/01/20
 * @project JavaProgramming
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 */

public class ShortestDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
       int minDistance = words.length;
       for(int i = 0; i < words.length; i++){
           if (words[i].equals(word1)){
               for (int j = 0; j < words.length; j++){
                   if (words[j].equals(word2)){
                       minDistance = Math.min(minDistance, Math.abs(i - j));
                   }
               }
           }
       }
        return minDistance;
    }

    public static int shortestDistanceOnePass(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
            } else if (words[i].equals(word2)){
                index2 = i;
            }
            if (index1 != -1 && index2 != -1){
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        return minDistance;
    }
}
