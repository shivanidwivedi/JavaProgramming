package leetcode.contest;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 15/08/20
 * @project JavaProgramming
 *
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
 * The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 * Example 2:
 *
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 */
public class MagneticForceBetweenBalls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int res = -1;
        int left = 0, right = position[n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            if (isFeasible(mid, position, n, m)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else
                right = mid;
        }
        return res;
    }

    static boolean isFeasible(int mid, int arr[],
                              int n, int m) {
        int pos = arr[0];
        int elements = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {
                pos = arr[i];
                elements++;
                if (elements == m)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] s) {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(maxDistance(new int[]{79, 74, 57, 22}, 4));

    }
}
