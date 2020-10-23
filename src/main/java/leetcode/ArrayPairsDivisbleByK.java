package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shivanidwivedi on 23/10/20
 * @project JavaProgramming
 *
 * Given an array of integers arr of even length n and an integer k.
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 * Return True If you can find a way to do that or False otherwise.
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: true
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: true
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 * Example 3:
 *
 * Input: arr = [1,2,3,4,5,6], k = 10
 * Output: false
 * Explanation: You can try all possible pairs to see that
 * there is no way to divide arr into 3 pairs each with sum divisible by 10.
 * Example 4:
 *
 * Input: arr = [-10,10], k = 2
 * Output: true
 */
public class ArrayPairsDivisbleByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if(rem < 0 ) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                map.put(rem,map.get(rem) - 1);
                if(map.get(rem) == 0)
                    map.remove(rem);
            } else {
                if(rem == 0) {
                    map.put(0,map.getOrDefault(0,0) +1);
                    continue;
                }
                map.put(k-rem,map.getOrDefault(k-rem,0) +1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        ArrayPairsDivisbleByK a = new ArrayPairsDivisbleByK();
        System.out.println(a.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        System.out.println(a.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
        System.out.println(a.canArrange(new int[]{1,2,3,4,5,6}, 10));
    }
}
