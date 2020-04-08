package leetcode;
/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k){
                int first = arr[i];
                int second = arr[j];
                int third = arr[k];
                int sum = first + second + third;
                if (sum < 0){
                    j++;
                }else if (sum > 0){
                    k--;
                }else {
                    List<Integer> temp = createList(first,second,third);
                    result.add(temp);
                    while (j < k && arr[j] == arr[j+1]){
                        j++;
                    }
                    while (j < k && arr[k] == arr[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
            while (i + 1 < arr.length && arr[i] == arr[i+1]){
                i++;
            }
        }

        return result;
    }
    static List<Integer> createList(int a, int b, int c){
        List<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        return temp;
    }
}
