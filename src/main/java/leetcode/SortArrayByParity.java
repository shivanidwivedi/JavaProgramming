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
        int temp, j=1;
        for (int i = 0; i < arr.length; i += 2){
            if (arr[i] % 2 == 1){
                while (arr[j] % 2 == 1){
                    j += 2;
                }
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        return arr;
    }
}
