package leetcode;

/**
 * Given an array arr of non-negative integers, half of the integers in arr are odd, and half of the integers are even.
 * Sort the array so that whenever arr[i] is odd, i is odd; and whenever arr[i] is even, i is even.
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int arr[]){
        if (arr == null || arr.length % 2 != 0){
            return arr;
        }
        int result[] = new int[arr.length];
        int index = 0;
        for (int i=0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                result[index] = arr[i];
                index += 2;
            }
        }
        index = 1;
        for (int i=0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                result[index] = arr[i];
                index += 2;
            }
        }

        return result;
    }
}
