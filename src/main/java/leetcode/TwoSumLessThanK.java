package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 17/01/20
 * @project JavaProgramming
 */
public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] A, int k) {
        Arrays.sort(A);
        final int endIndex = getEndIndex(A, k);
        int j = endIndex;
        int max = -1;
        for (int i = 0; i <= endIndex; i++){
            while (i < j && A[i] + A[j] > k) {
                j--;
            }
            int tempMax = A[i] + A[j];
            if (i < j && tempMax > max && tempMax < k) {
                max = tempMax;
            }
        }

        return max;
    }

    static int getEndIndex(int[] sortedArray, int k) {
        int i = sortedArray.length - 1;
        while (i > 0 && sortedArray[i] >= k){
            i--;
        }
        return i;
    }
}
