package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 14/12/20
 * @project JavaProgramming
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    // Approach - 1: Repeated Subtraction
    /*
    Time Complexity : O(n)
    Space Complexity : O(1)
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        int negatives = 0;
        if (dividend < 0) {
            negatives++;
            dividend = -dividend;
        }
        if (divisor < 0) {
            negatives++;
            divisor = -divisor;
        }
        int quotient = 0;
        while (dividend - divisor >= 0) {
            quotient++;
            dividend -= divisor;
        }
        if (negatives == 1) {
            quotient = -quotient;
        }
        return quotient;
    }

    // Approach - 2: Repeated Exponential Searches
    /*
    Time Complexity : O(log^2 n) : We started by performing an exponential search to find the biggest number that
    fits into the current dividend. This search took O(logn) operations. After doing this search,
    we updated the dividend by subtracting the number we found. In the worst case,
    we were left with a dividend slightly less than half of the previous dividend
    (if it was more than half, then we couldn't have found the maximum number that fit in by doubling!).
    So how many of these searches did we need to do? Well, with the dividend at least halving after each one,
    there couldn't have been more than O(logn) of them.
    So combined together, in the worst case, we have O(logn) searches with each search taking O(logn) time.
    This gives us O((log n).(log n)) = O(log^2 n) as our total time complexity.

    Space Complexity : O(1)
     */
    private static int HALF_INT_MIN = -1073741824;

    public static int divideExponential(int dividend, int divisor) {

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        int quotient = 0;
        while (divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            quotient += powerOfTwo;
            dividend -= value;
        }
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }

    public static void main(String[] args) {
        Assert.assertEquals(-6, divide(60, -10));
        Assert.assertEquals(3, divide(-6, -2));

        Assert.assertEquals(3, divideExponential(10, 3));
        Assert.assertEquals(-2, divideExponential(7, -3));
        Assert.assertEquals(0, divideExponential(0, 1));
        Assert.assertEquals(1, divideExponential(1, 1));
    }
}
