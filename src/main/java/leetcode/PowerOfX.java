package leetcode;

/**
 * @author shivanidwivedi on 16/07/20
 * @project JavaProgramming
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Time complexity :O(logn). For each bit of n 's binary representation,
 * we will at most multiply once. So the total time complexity is O(logn).
 *
 * Space complexity : O(1). We only need two variables for the current product and the final result of x
 */
public class PowerOfX {
    public static double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double number = 1;
        double current_product = x;
        for(long i = N; i > 0; i /= 2){
            if((i % 2) == 1){
                number *= current_product;
            }
            current_product = current_product * current_product;
        }
        return number;
    }
}
