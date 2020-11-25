package leetcode;

import org.junit.Assert;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shivanidwivedi on 12/11/20
 * @project JavaProgramming
 * <p>
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * Time Complexity: O(N * (N/W)), where N is the length of hand.
 * The (N / W) factor comes from min(count). In Java, the (N / W) factor becomes logN due to the complexity of TreeMap.
 * <p>
 * Space Complexity: O(N).
 */
public class HandOfStraights {
    private TreeMap<Integer, Integer> map;

    public HandOfStraights() {
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        map = initializeCardCountMap(hand);
        if (hand.length % groupSize != 0) {
            return false;
        }
        while (!map.isEmpty()) {
            if(!isValidHandExistInGroup(groupSize, map.firstKey())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates if hand sequences are in order to given group size
     * @param groupSize: hand group size
     * @param firstCard: start hand sequence
     * @return
     */
    private boolean isValidHandExistInGroup(int groupSize, int firstCard) {
        pickAndRemoveCard(firstCard);
        for (int i = 1; i < groupSize; i++) {
            int target = firstCard + i;
            if (!map.containsKey(target)) {
                return false;
            }
            pickAndRemoveCard(target);
        }
        return true;
    }

    private TreeMap<Integer, Integer> initializeCardCountMap(int[] hand) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        return map;
    }

    private void pickAndRemoveCard(int cardSequence) {
        map.put(cardSequence, map.get(cardSequence) - 1); //pick
        if (map.get(cardSequence) == 0) {
            map.remove(cardSequence);
        }
    }

    public static void main(String[] args) {

        Assert.assertEquals(true, new HandOfStraights().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        Assert.assertEquals(false, new HandOfStraights().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
