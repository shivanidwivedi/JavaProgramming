package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers arr sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 */

public class SquaresArray {
    public static int[] squareOfArray(int [] arr){
        if (arr.length == 0){
            return arr;
        }
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
