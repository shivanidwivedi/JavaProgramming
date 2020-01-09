package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 */
public class MostCommonWord {

    /**
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned){
        String[] words = splitParagraphToStrings(paragraph);
        if (words==null){
            return null;
        }
        HashMap<String, Integer> map = paragraphWordsCount(words, banned);
        String answer = getMostCommonWord(map);
        return answer;

    }

    /**
     *
     * @param paragraph
     * @return
     */
    static String[] splitParagraphToStrings(String paragraph) {
        String[] words =  paragraph.toLowerCase().split("[, ?.@!';]+"); //!?',;.
        return words;
    }

    /**
     *
     * @param words
     * @param bannedWords
     * @return
     */
    private static HashMap<String, Integer> paragraphWordsCount(String[] words, String[] bannedWords) {
        HashSet<String> bannedSet = new HashSet<>();
        for(String s:bannedWords){
            bannedSet.add(s);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words){
            if(bannedSet.contains(s)) continue;
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            } else {
                map.put(s,1);
            }
        }
        return map;
    }

    /**
     *
     * @param map
     * @return
     */
    private static String getMostCommonWord(HashMap<String, Integer> map) {
        String answer = " ";
        int max = 0;
        for(String s: map.keySet()){
            if(map.get(s)>max){
                answer=s;
                max=map.get(s);
            }
        }
        return answer;
    }
}
