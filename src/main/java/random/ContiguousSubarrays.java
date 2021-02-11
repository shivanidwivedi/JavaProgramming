package random;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shivanidwivedi on 10/02/21
 * @project JavaProgramming
 *
 * You are given an array arr of N integers. For each index i, you are required to determine the number
 * of contiguous subarrays that fulfills the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 *
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 *
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 */
public class ContiguousSubarrays {
    int[] countSubarrays(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] += ans[stack.pop()];
            }
            stack.push(i);
            ans[i]++;
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                ans[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ContiguousSubarrays contiguousSubarrays = new ContiguousSubarrays();
        System.out.println(Arrays.toString(contiguousSubarrays.countSubarrays(
                new int[]{3,4,1,6,2}
        )));
    }
}
