package leetcode_contest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shivanidwivedi on 26/08/20
 * @project JavaProgramming
 */
public class KickStart1 {
    public static int numberOfHouses(int N, int B, int[] A){
        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < A.length; i++){
            if(B >= A[i]){
                count++;
                B -= A[i];
            }else break;

        }
        return count;
    }
    public static void main(String[] s){
        //System.out.println(numberOfHouses(4,100, new int[]{20,90,40,90}));
        //System.out.println(numberOfHouses(4,50, new int[]{30,30,10,10}));
        //System.out.println(numberOfHouses(3,30, new int[]{999, 999, 999}));
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i=1; i<=count; i++) {
            int size = in.nextInt();
            int budget = in.nextInt();
            int[] arr = new int[size];
            for(int j=0; j<size; j++) {
                arr[j] = in.nextInt();
            }
            System.out.println("Case #"+i+": "+numberOfHouses(size,budget,arr));
        }
    }
}
