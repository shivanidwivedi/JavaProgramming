package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author shivanidwivedi on 19/08/20
 * @project JavaProgramming
 *
 * Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that
 * returns an array of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.
 *
 * Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space complexities
 * of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.
 *
 * Example:
 * input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]
 * output: [3, 6, 7]
 */
public class FindDuplicates {
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n:  arr1){
            set.add(n);
        }
        List<Integer> result = new ArrayList<>();
        for(int n:  arr2){
            if(set.contains(n))
                result.add(n);
        }
        int[] output = new int[result.size()];
        int j = 0;
        for(int n:  result){
            output[j++] = n;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};
        System.out.println(Arrays.toString(findDuplicates(arr1,arr2)));
    }

}
