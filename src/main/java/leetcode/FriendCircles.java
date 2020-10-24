package leetcode;

/**
 * @author shivanidwivedi on 24/10/20
 * @project JavaProgramming
 *
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend of B,
 * and B is a direct friend of C,then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 * TC: O(n^2), SC: O(n)
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0){
            return 0;
        }
        int count = 0;
        int[] visited = new int[M.length];
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0){
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i){
        for(int j = 0; j < M.length; j++){
            if(M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        FriendCircles friendCircles = new FriendCircles();
        System.out.println(friendCircles.findCircleNum(new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
    }
}
