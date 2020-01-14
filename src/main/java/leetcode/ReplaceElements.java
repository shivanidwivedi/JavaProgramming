package leetcode;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 */

public class ReplaceElements {
    public static int[] replaceWithGreatest(int[] arr) {
        if (arr == null) {
            return arr;
        }
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int temp, max=-1;
        for(int i=arr.length-1; i>=0;i--){
            temp=arr[i];
            arr[i]=max;
            max=Math.max(temp,max);

        }
        return arr;
    }
}
