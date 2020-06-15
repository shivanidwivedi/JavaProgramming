package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 13/06/20
 * @project JavaProgramming
 */
public class Bouquets {
    public static int minDays(int[] bloomDay, int numberOfBouq, int flowersInOneBouq) {
        int low = 1; //lowest number of days
        int high = Integer.MAX_VALUE; //max number of days

        if(numberOfBouq*flowersInOneBouq > bloomDay.length) {
            return -1;
        }

        while (high > low) {
            int mid = (low + high) / 2, flowers = 0, bouq = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i] > mid) { //flower can not bloom, it breaks the adjacency
                    flowers = 0;
                } else if (++flowers >= flowersInOneBouq) {
                    bouq++;
                    flowers = 0; //reset
                }
            }

            if (bouq < numberOfBouq) { //if num of bouq is still less than required
                low = mid + 1;
            } else {
                high = mid; //keep squeezing the binary search array to find out the min no of days
            }
        }
        return low;
    }
}
