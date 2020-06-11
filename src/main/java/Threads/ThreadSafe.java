package Threads;

import java.util.Random;

/**
 * @author shivanidwivedi on 11/06/20
 * @project JavaProgramming
 */
public class ThreadSafe {
    public static void main(String s[]) throws InterruptedException {
       RaceCondition.runTest();
    }
}
class RaceCondition{
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 10000;
        while (i != 0) {
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0)
                    System.out.println(randInt);
            }
            i--;
        }
    }
    void modifier() {

        int i = 1000000;
        while (i != 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }
    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
