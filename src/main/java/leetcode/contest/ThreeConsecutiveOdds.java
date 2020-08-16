package leetcode.contest;

/**
 * @author shivanidwivedi on 15/08/20
 * @project JavaProgramming
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 *
 *
 * Example 1:
 *
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * Example 2:
 *
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 */
public class ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++){
            int one = arr[i];
            int two = arr[i+1];
            int three = arr[i+2];
            if(one % 2 == 1 && two % 2 == 1 && three % 2 == 1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] s){
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
        System.out.println(threeConsecutiveOdds(new int[]{2,6,4,1}));
    }
}
