package concepts.comparator;

import java.util.Arrays;

/**
 *
 * Create compare class and implement below 3 methods:
 *
 * 1--> boolean compare(int a, int b)  ====> return true if a == b else false.
 * 2--> boolean compare(String a, String b)  ====> return true if String a == String b else false.
 * 1--> boolean compare(int[] a, int[])  return true
 *  a)if a.length == b.length , and
 *  b) for each i, a[i] == b[i];
 *
 * @author shivanidwivedi on 24/04/20
 * @project JavaProgramming
 */
public class CompareArrays {
    public boolean compare(int a, int b) {
        return a == b ? true : false;
    }
    public boolean compare(String a, String b) {
        return a.equals(b) ? true : false;
    }
    public boolean compare(int[] a, int[] b) {
        return Arrays.equals(a,b);
    }
}
