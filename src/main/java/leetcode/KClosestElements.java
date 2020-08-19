package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 19/08/20
 * @project JavaProgramming
 *
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 * Time complexity : O(logn+k).O(logn) is for the time of binary search, while O(k) is for shrinking the index range to k elements.
 * Space complexity : O(k). It is to generate the required sublist.
 */
public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        int index = findIndex(arr,x);
        int leftMost = Math.max(0, index - k);
        int rightMost = Math.min(n-1, index + k);

        while(rightMost - leftMost + 1 > k){
            if(Math.abs(arr[rightMost] - x) >= Math.abs(arr[leftMost] - x)){
                rightMost--;
            }else{
                leftMost++;
            }
        }
        for(int i = leftMost; i <= rightMost; i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static int findIndex(int[] arr, int x){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] < x){

                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] s){
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 6));
    }
}
