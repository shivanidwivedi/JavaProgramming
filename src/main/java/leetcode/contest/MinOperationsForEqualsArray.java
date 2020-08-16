package leetcode.contest;

/**
 * @author shivanidwivedi on 15/08/20
 * @project JavaProgramming
 *
 * Minimum Operations to Make Array Equal
 * User Accepted:5677
 * User Tried:5888
 * Total Accepted:5827
 * Total Submissions:7503
 * Difficulty:Medium
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 *
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y]
 * (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal.
 * It is guaranteed that all the elements of the array can be made equal using some operations.
 *
 * Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: arr = [1, 3, 5]
 * First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
 * In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
 * Example 2:
 *
 * Input: n = 6
 * Output: 9
 */
public class MinOperationsForEqualsArray {
    public static int minOperations(int n) {
        int ways = 0;
        /**
         * No need to calculate array.
         */
        for(int i = n-1; i >= n/2; i--) {
            ways += (getValue(i) - n);
        }
        return ways;
    }

    private static int getValue(int i) {
        return 2*i + 1;
    }


    public static void main(String[] s){
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
        System.out.println(minOperations(5));
        System.out.println(minOperations(6));
    }
}
