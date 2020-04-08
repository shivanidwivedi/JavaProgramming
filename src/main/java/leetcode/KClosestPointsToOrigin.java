package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        int [] dist = new int[points.length];
        for (int i = 0; i < points.length; i++){
            dist[i] = distance(points[i]);
        }
        Arrays.sort(dist);
        int disK = dist[K-1];
        int result[][] = new int[K][2];
        int t = 0;
        for (int i = 0; i < points.length; i++){
            if (distance(points[i]) <= disK){
                result [t] = points[i];
                t++;
            }
        }
        return result;
    }
    private static int distance(int [] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
