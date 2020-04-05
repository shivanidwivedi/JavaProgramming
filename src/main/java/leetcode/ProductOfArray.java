package leetcode;


/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArray {

    public static int[] byDivision(int[] arr) {
        return null;
    }

    public static int[] byTwoArrays(int[] arr) {
        int length = arr.length;
        if(length==0||length==1) return null;
        int leftArr[] = new int [length];
        int rightArr[] = new int [length];
        int answer[] = new int [length];
        leftArr[0]=1;
        //Store the product of i-1 elements in left array. (except last element)
        for (int i=1; i<length ; i++) {
            leftArr[i] =  arr[i-1] * leftArr[i-1];
        }
        //Store the product of
        rightArr[length-1]= 1;
        for (int i= length-2; i>=0; i--) {
            rightArr[i]= arr[i+1]* rightArr[i+1];
        }
        for(int i=0; i< length; i++) {
            answer[i] = leftArr[i] * rightArr[i];
        }
        return answer;
    }
}
