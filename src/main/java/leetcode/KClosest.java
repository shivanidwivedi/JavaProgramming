package leetcode;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 25/02/21
 * @project JavaProgramming
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int headIdx = 0;
        int tailIdx = points.length - 1;
        while (headIdx < tailIdx) {
            int sortedPosIdx = partition(points, headIdx, tailIdx);
            if (sortedPosIdx == K-1) {
                break;
            } else if (sortedPosIdx > K-1) {
                tailIdx = sortedPosIdx - 1;
            } else {
                headIdx = sortedPosIdx + 1;
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private int partition(int[][] points, int headIdx, int tailIdx) {
        int pivotIdx = headIdx;
        int pivotPointDistance = getDistance(points[pivotIdx]);
        swap(points, pivotIdx, tailIdx);
        int j = headIdx;
        for (int i = headIdx; i < tailIdx; i++) {
            int currPointDistance = getDistance(points[i]);
            if (currPointDistance < pivotPointDistance) {
                swap(points, i, j);
                j++;
            }
        }
        swap(points, j, tailIdx);
        return j;
    }

    private int getDistance(int[] points) {
        int x = Math.abs(points[0]);
        int y = Math.abs(points[1]);
        return x*x + y*y;
    }

    private void swap(int[][] points, int idx1, int idx2) {
        int[] temp = points[idx1];
        points[idx1] = points[idx2];
        points[idx2] = temp;
    }

    public static void main(String[] args) {
        KClosest obj = new KClosest();
        Assert.assertEquals(new int[][]{{3,3},{-2,4}}, obj.kClosest(
                new int[][]{{3,3},{5,-1},{-2,4}}, 2
        ));
    }
}
