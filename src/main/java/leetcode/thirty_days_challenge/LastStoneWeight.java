package leetcode.thirty_days_challenge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 12/04/20
 * @project JavaProgramming
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        int weight = -2; //continue
        while(weight == -2) {
            stones = updateStones(stones);
            weight = shouldContinue(stones);
        }
        return weight;
    }
    /**
     *
     * @param stones
     * @return
     * -2: means have to iterate more;
     * 0: means all values are -1; Array has been iterated
     * weight: this means only one weight is remaining
     */
    private static int shouldContinue(int[] stones) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] != -1) {
                count++;
                result = stones[i];
            }
        }
        if (count == 0){
            return 0;
        }else if (count == 1) return result;
        else return -2;
    }

    /**
     * -1 indicates invalid weight
     * @param arr
     * @return
     */
    public static int[] updateStones(int[] arr){
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int maxIndex1 = 0, maxIndex2 = 0;

        //calculate two max
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != -1) {
                if (max1 < arr[i]) {
                    max2 = max1;
                    maxIndex2 = maxIndex1;
                    max1 = arr[i];
                    maxIndex1 = i;

                } else if (max2 < arr[i]) {
                    max2 = arr[i];
                    maxIndex2 = i;
                }
            }
        }
        if (max1 == max2){
            arr[maxIndex1] = arr[maxIndex2] = -1;
            return arr;
        }else {
            arr[maxIndex1] = max1 - max2;
            arr[maxIndex2] = -1;
        }
        return arr;
    }


}
