package leetcode;

/**
 * Given an array arr of non-negative integers, return an array consisting of all the even elements of arr,
 * followed by all the odd elements of arr.
 */
public class SortByParity {
    public static int[] sortByParity(int[] arr){
        if (arr.length==0||arr.length==1){
            return arr;
        }
        int i = 0, j = arr.length - 1;
        while (i < j){
            if (arr[i] % 2 > arr[j] % 2){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[i] % 2 == 0){
                i++;
            }
            if (arr[j] % 2 == 1){
                j--;
            }
        }
        return arr;
    }
}
