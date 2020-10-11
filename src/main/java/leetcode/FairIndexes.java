package leetcode;

/**
 * @author shivanidwivedi on 08/10/20
 * @project JavaProgramming
 */
public class FairIndexes {
    public static int fairindex(int[] A, int[] B){
        int N = A.length;
        int count = 0;
        int sumAleft = A[0], sumBleft = B[0];
        int sumAright = getRightSum(A);
        int sumBright = getRightSum(B);
        for(int k = 2; k < N; k++){
            sumAleft += A[k-1];
            sumBleft += B[k-1];
            sumAright -= A[k-1];
            sumBright -= B[k-1];
            if(sumAleft == sumBleft && sumAleft == sumAright && sumAleft == sumBright){
                count++;
            }
        }
        return count;
    }

    private static int getRightSum(int[] array){
        int sumRight = 0;
        for (int i = 1; i < array.length; i++){
            sumRight += array[i];
        }
        return sumRight;
    }

    public static void main(String[] s){
        System.out.println(fairindex(new int[]{4,-1,0,3}, new int[]{-2,5,0,3}));
        System.out.println(fairindex(new int[]{2,-2,-3,3}, new int[]{0,0,4,-4}));
        System.out.println(fairindex(new int[]{4,-1,0,3}, new int[]{-2,6,0,4}));
        System.out.println(fairindex(new int[]{3,2,6}, new int[]{4,1,6}));
        System.out.println(fairindex(new int[]{1,4,2,-2,5}, new int[]{7,-2,-2,2,5}));
    }
}
