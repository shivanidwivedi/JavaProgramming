package leetcode;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 */
//Approach 1: Two Pass
public class MonotonicArray {
    public static boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }
    public static boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++)
            if (A[i] > A[i+1]) return false;
        return true;
    }

    public static boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++)
            if (A[i] < A[i+1]) return false;
        return true;
    }

    //Approach 2: One Pass
    public boolean isMonotonic_2(int[] A) {
        int store = 0;
        for(int i = 0; i < A.length-1; i++){
            int c = Integer.compare(A[i],A[i+1]);
            if(c != 0){
                if(c != store && store != 0){
                    return false;
                }
                store = c;
            }
        }
        return true;
    }
}
