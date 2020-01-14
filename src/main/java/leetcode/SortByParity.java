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
        int result[] = new int[arr.length];
        int index=0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                result[index++] = arr[i];
            }
        }
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                result[index++] = arr[i];
            }
        }
        return result;
    }
}
