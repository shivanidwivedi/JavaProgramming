package leetcode;

/**
 * Fibonacci Sum
 */
public class Fibonacci {

    /**
     * Recursive solution
     * @param n
     * @return
     */
    public static int fib_recursive(int n) {
        int first = 0, second = 1;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fib_recursive(n - 1) + fib_recursive(n-2);
    }

    /**
     * Iterative solution
     * @param n
     * @return
     */
    public static int fib_iterative(int n) {
        int first = 0, second = 1;
        int limit = 2;

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int sum = 0;
        while(limit++ <= n){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
