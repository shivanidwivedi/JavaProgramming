package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 25/02/21
 * @project JavaProgramming
 */
public class RandomPickWithWeight {
    int[] prefixSums;
    int totalSum;

    public RandomPickWithWeight(int[] w) {
        prefixSums = new int[w.length];
        int prefixSum = 0;
        for(int i = 0; i < w.length; i++){
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        RandomPickWithWeight obj = new RandomPickWithWeight(new int[]{1,3});
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }
}
