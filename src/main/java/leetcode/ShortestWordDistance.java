package leetcode;

/**
 * @author shivanidwivedi on 24/10/20
 * @project JavaProgramming
 *
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * TC: O(n), SC: O(1)
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int indexWord1 = -1, indexWord2 = -1;
        for(int i = 0; i < words.length; i++){
            if(word1.equals(words[i])){
                indexWord1 = i;
            }else if(word2.equals(words[i])){
                indexWord2 = i;
            }
            if(indexWord1 != -1 && indexWord2 != -1){
                minDistance = Math.min(minDistance, Math.abs(indexWord1 - indexWord2));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        System.out.println(shortestWordDistance.shortestDistance(new String[]
                        {"practice", "makes", "perfect", "coding", "makes"},
                "coding", "practice"));
    }
}
