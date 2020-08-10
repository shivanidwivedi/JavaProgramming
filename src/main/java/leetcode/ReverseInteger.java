package leetcode;

/**
 * @author shivanidwivedi on 09/08/20
 * @project JavaProgramming
 * Given a 32-bit signed integer, reverse digits of an integer.
 *Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int original = x;
        if(x < 0){
            x = x * -1;
        }
        int number = 0;

        while(x > 0){
            if(number > 214748364){
                return 0;
            }
            number = number * 10 + x % 10;
            x = x / 10;
        }
        return original < 0 ? number * -1 : number;
    }
    public static void main(String[] str){
        System.out.println(reverse(-123));
        System.out.println(reverse(-120));
        System.out.println(reverse(123));
    }
}
