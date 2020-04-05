package leetcode;

import java.util.HashSet;

/**
 * Get count of jewels in the stone you have and return the count.
 * Given String jewels and String stones consisting of letters only and are case sensitive.
 */
public class Jewels_HM {
    public static int jewelsAndStones(String jewels, String stones){
        if (jewels==null || stones==null || jewels==null && stones==null) {
            return 0;
        }
        HashSet<Character> set = getHashSet(jewels);
        int count = getCount(set, stones);
        return count;
    }

    /**
     * Method to create HashSet of the String jewels
     * @param jewels
     * @return
     */
    private static HashSet<Character> getHashSet(String jewels){
        HashSet<Character> set = new HashSet<>();
        for(char s:jewels.toCharArray()){
            set.add(s);
        }
        return set;
    }

    /**
     *
     * @param set
     * @param stones
     * @return
     */
    private static int getCount(HashSet<Character> set, String stones){
        int count=0;
        for(char s:stones.toCharArray()){
            if(set.contains(s)){
                count++;
            }
        }
        return count;
    }
}
