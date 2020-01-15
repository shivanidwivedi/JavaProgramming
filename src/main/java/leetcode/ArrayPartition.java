package leetcode;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */

public class ArrayPartition {
    public static int arrayPartition(int arr[]){
        int n = arr.length/2;
        if(arr.length==2) return Math.min(arr[0], arr[1]);
        Arrays.sort(arr);
        int sum = 0;
        for (int index=0; index < arr.length; index += 2){
            sum += arr[index];
        }
        return sum;
    }
}