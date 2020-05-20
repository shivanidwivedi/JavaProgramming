package leetcode;
import java.math.BigInteger;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Time complexity: O(max(N,M)), where N and M are lengths of the input strings a and b.
 *
 * Space complexity: O(max(N,M)) to keep the answer.
 */
//Approach-1 : Bit-by-Bit Computation
public class AddBinary {
    public static String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        if(a.length() == 0 && b.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1; int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(j >= 0) {
                sum += b.charAt(j--)-'0';
            }
            if(i >= 0) {
                sum += a.charAt(i--)-'0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    //Approach-2: Bit Manipulation(very important to understand)

    /**
     * Algorithm
     *
     * Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.
     * While carry is nonzero: y != 0:
     * ---Current answer without carry is XOR of x and y: answer = x^y.
     * ---Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
     * ---Job is done, prepare the next loop: x = answer, y = carry.
     *
     * Return x in the binary form.
     * Time complexity : O(N+M), where N and M are lengths of the input strings a and b.
     *
     * Space complexity : O(max(N,M)) to keep the answer.
     */
    public static String addBinary_2(String a, String b) {
        // converts binary to int (BigInteger is a class)
        BigInteger x = new BigInteger(a,2); // 2 is the radix here(base-2)
        BigInteger y = new BigInteger(b,2);
        BigInteger zero = new BigInteger("0",2);
        BigInteger carry, answer;
        while(y.compareTo(zero) != 0){
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
