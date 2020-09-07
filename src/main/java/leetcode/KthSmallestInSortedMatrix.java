package leetcode;

import java.util.PriorityQueue;

/**
 * @author shivanidwivedi on 07/09/20
 * @project JavaProgramming
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 */
public class KthSmallestInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;

        if (k == 1) {
            return matrix[0][0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                heap.add(matrix[i][j]);
            }
        }
        int number = -1;
        while (k > 0) {
            number = heap.poll();
            k--;
        }
        return number;
    }

    public static int kthSmallestBinarySearch(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];

        while (min < max) {
            int mid = min + (max - min)/2;
            int[] smallLargePair = {matrix[0][0], matrix[n-1][n-1]};
            int count = countLessEqual(matrix, mid, smallLargePair);
            if(count == k){
                return smallLargePair[0];
            }
            if(count < k){
                min = smallLargePair[1];
            }else{
                max = smallLargePair[0];
            }
        }

        return min;
    }

    private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair){
        int count = 0;
        int n = matrix.length;
        int row = n-1;
        int col = 0;
        while(row >= 0 && col < n){
            if(matrix[row][col] > mid){
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            }else{
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    public static void main(String[] s) {
        System.out.println(kthSmallest(new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
        System.out.println(kthSmallestBinarySearch(new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
    }
}
