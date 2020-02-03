package leetcode;

import java.util.HashSet;

/**
 * Given a number, tell whether it is happy or not.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    public static boolean isHappy(int number){
        if (number==0){
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        while (number!=1 && !set.contains(number)){
            set.add(number);
            number = getNext(number);
        }
        return number==1;
    }

    /**
     * Method to get the next number
     * @param number
     * @return
     */
    private static int getNext(int number){
        int sum=0;
        while (number > 0){
            int rem= number%10;
            number/=10;
            sum+=(rem*rem);
        }
        return sum;
    }
}
