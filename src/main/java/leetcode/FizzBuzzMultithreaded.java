package leetcode;

import java.util.function.IntConsumer;

/**
 * @author shivanidwivedi on 25/09/20
 * @project JavaProgramming
 */
public class FizzBuzzMultithreaded {
    private static int n;
    private static Integer i;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        i = 1;
    }

    // printFizz.run() outputs "fizz".
    public static void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized (i) {
                if (i <= n && i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    ++i;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public static void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (i) {
                if (i <= n && i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    ++i;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public static void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (i) {
                if (i <= n && i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    ++i;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public static void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (i) {
                if (i <= n && i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    ++i;
                }
            }
        }
    }

    public static void main(String[] s){
        FizzBuzzMultithreaded fizzBuzzMultithreaded = new FizzBuzzMultithreaded(15);
    }
}
