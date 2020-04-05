package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void fib_recursive_test() {
        Assert.assertEquals(1, Fibonacci.fib_recursive(2));
        Assert.assertEquals(3, Fibonacci.fib_recursive(4));
        Assert.assertEquals(2, Fibonacci.fib_recursive(3));

    }

    @Test
    public void fib_iterative_test() {
        Assert.assertEquals(13, Fibonacci.fib_iterative(7));
        Assert.assertEquals(2, Fibonacci.fib_iterative(3));
    }
}
