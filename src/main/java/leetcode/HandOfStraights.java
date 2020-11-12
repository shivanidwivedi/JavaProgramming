package leetcode;

import java.util.TreeMap;

/**
 * @author shivanidwivedi on 12/11/20
 * @project JavaProgramming
 *
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 * Time Complexity: O(N * (N/W)), where N is the length of hand.
 * The (N / W) factor comes from min(count). In Java, the (N / W) factor becomes logN due to the complexity of TreeMap.
 *
 * Space Complexity: O(N).
 */
public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0){
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        while(!map.isEmpty()){
            int first = map.firstKey();
            map.put(first, map.get(first) - 1);
            if(map.get(first) == 0){
                map.remove(first);
            }
            for(int i = 1; i < W; i++){
                int target = first + i;
                if(!map.containsKey(target)){
                    return false;
                }
                map.put(target, map.get(target)-1);
                if(map.get(target) == 0){
                    map.remove(target);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }
}
